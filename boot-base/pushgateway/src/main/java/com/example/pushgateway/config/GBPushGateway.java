package com.example.pushgateway.config;

import io.prometheus.client.Collector;
import io.prometheus.client.Collector.MetricFamilySamples;
import io.prometheus.client.Collector.MetricFamilySamples.Sample;
import io.prometheus.client.Collector.Type;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.DefaultHttpConnectionFactory;
import io.prometheus.client.exporter.HttpConnectionFactory;
import io.prometheus.client.exporter.common.TextFormat;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: huacailiang
 * @date: 2021/4/17
 * @description:
 **/
@Slf4j
public class GBPushGateway {

  private static final int MILLISECONDS_PER_SECOND = 1000;
  protected final String gatewayBaseURL;
  private HttpConnectionFactory connectionFactory;

  public GBPushGateway(String address) {
    this(createURLSneakily("http://" + address));
  }

  public GBPushGateway(URL serverBaseURL) {
    this.connectionFactory = new DefaultHttpConnectionFactory();
    this.gatewayBaseURL = URI.create(serverBaseURL.toString() + "/metrics/").normalize().toString();
  }

  public void setConnectionFactory(HttpConnectionFactory connectionFactory) {
    this.connectionFactory = connectionFactory;
  }

  private static URL createURLSneakily(String urlString) {
    try {
      return new URL(urlString);
    } catch (MalformedURLException var2) {
      throw new RuntimeException(var2);
    }
  }

  public void push(CollectorRegistry registry, String job) throws IOException {
    this.doRequest(registry, job, (Map)null, "PUT");
  }

  public void push(Collector collector, String job) throws IOException {
    CollectorRegistry registry = new CollectorRegistry();
    collector.register(registry);
    this.push(registry, job);
  }

  public void push(CollectorRegistry registry, String job, Map<String, String> groupingKey) throws IOException {
    this.doRequest(registry, job, groupingKey, "PUT");
  }

  public void push(Collector collector, String job, Map<String, String> groupingKey) throws IOException {
    CollectorRegistry registry = new CollectorRegistry();
    collector.register(registry);
    this.push(registry, job, groupingKey);
  }

  public void pushAdd(CollectorRegistry registry, String job) throws IOException {
    this.doRequest(registry, job, (Map)null, "POST");
  }

  public void pushAdd(Collector collector, String job) throws IOException {
    CollectorRegistry registry = new CollectorRegistry();
    collector.register(registry);
    this.pushAdd(registry, job);
  }

  public void pushAdd(CollectorRegistry registry, String job, Map<String, String> groupingKey) throws IOException {
    this.doRequest(registry, job, groupingKey, "POST");
  }

  public void pushAdd(Collector collector, String job, Map<String, String> groupingKey) throws IOException {
    CollectorRegistry registry = new CollectorRegistry();
    collector.register(registry);
    this.pushAdd(registry, job, groupingKey);
  }

  public void delete(String job) throws IOException {
    this.doRequest((CollectorRegistry)null, job, (Map)null, "DELETE");
  }

  public void delete(String job, Map<String, String> groupingKey) throws IOException {
    this.doRequest((CollectorRegistry)null, job, groupingKey, "DELETE");
  }

  void doRequest(CollectorRegistry registry, String job, Map<String, String> groupingKey, String method) throws IOException {
    String url = this.gatewayBaseURL;
    if (job.contains("/")) {
      url = url + "job@base64/" + base64url(job);
    } else {
      url = url + "job/" + URLEncoder.encode(job, "UTF-8");
    }

    if (groupingKey != null) {
      Iterator var6 = groupingKey.entrySet().iterator();

      while(var6.hasNext()) {
        Entry<String, String> entry = (Entry)var6.next();
        if (((String)entry.getValue()).isEmpty()) {
          url = url + "/" + (String)entry.getKey() + "@base64/=";
        } else if (((String)entry.getValue()).contains("/")) {
          url = url + "/" + (String)entry.getKey() + "@base64/" + base64url((String)entry.getValue());
        } else {
          url = url + "/" + (String)entry.getKey() + "/" + URLEncoder.encode((String)entry.getValue(), "UTF-8");
        }
      }
    }
    log.info("【推送pushgatway url: {}】", url);
    HttpURLConnection connection = this.connectionFactory.create(url);
    connection.setRequestProperty("Content-Type", "text/plain; version=0.0.4; charset=utf-8");
    if (!method.equals("DELETE")) {
      connection.setDoOutput(true);
    }

    connection.setRequestMethod(method);
    connection.setConnectTimeout(10000);
    connection.setReadTimeout(10000);
    connection.connect();

    try {
      if (!method.equals("DELETE")) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
        write004(writer, registry.metricFamilySamples());
        writer.flush();
        writer.close();
      }

      int response = connection.getResponseCode();
      if (response / 100 != 2) {
        InputStream errorStream = connection.getErrorStream();
        String errorMessage;
        if (errorStream != null) {
          String errBody = readFromStream(errorStream);
          errorMessage = "Response code from " + url + " was " + response + ", response body: " + errBody;
        } else {
          errorMessage = "Response code from " + url + " was " + response;
        }

        throw new IOException(errorMessage);
      }
    } finally {
      connection.disconnect();
    }

  }

  private static String base64url(String v) {
    try {
      return DatatypeConverter
          .printBase64Binary(v.getBytes("UTF-8")).replace("+", "-").replace("/", "_");
    } catch (UnsupportedEncodingException var2) {
      throw new RuntimeException(var2);
    }
  }

  public static Map<String, String> instanceIPGroupingKey() throws UnknownHostException {
    Map<String, String> groupingKey = new HashMap();
    groupingKey.put("instance", InetAddress.getLocalHost().getHostAddress());
    return groupingKey;
  }

  private static String readFromStream(InputStream is) throws IOException {
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];

    int length;
    while((length = is.read(buffer)) != -1) {
      result.write(buffer, 0, length);
    }

    return result.toString("UTF-8");
  }

  public static void write004(Writer writer, Enumeration<MetricFamilySamples> mfs) throws IOException {
    TreeMap omFamilies = new TreeMap();

    label72:
    while(mfs.hasMoreElements()) {
      MetricFamilySamples metricFamilySamples = (MetricFamilySamples)mfs.nextElement();
      String name = metricFamilySamples.name;
      writer.write("# HELP ");
      writer.write(name);
      if (metricFamilySamples.type == Type.COUNTER) {
        writer.write("_total");
      }

      if (metricFamilySamples.type == Type.INFO) {
        writer.write("_info");
      }

      writer.write(32);
      writeEscapedHelp(writer, metricFamilySamples.help);
      writer.write(10);
      writer.write("# TYPE ");
      writer.write(name);
      if (metricFamilySamples.type == Type.COUNTER) {
        writer.write("_total");
      }

      if (metricFamilySamples.type == Type.INFO) {
        writer.write("_info");
      }

      writer.write(32);
      writer.write(typeString(metricFamilySamples.type));
      writer.write(10);
      String createdName = name + "_created";
      String gcountName = name + "_gcount";
      String gsumName = name + "_gsum";
      Iterator var8 = metricFamilySamples.samples.iterator();

      while(true) {
        while(true) {
          if (!var8.hasNext()) {
            continue label72;
          }

          Sample sample = (Sample)var8.next();
          if (!sample.name.equals(createdName) && !sample.name.equals(gcountName) && !sample.name.equals(gsumName)) {
            writer.write(sample.name);
            if (sample.labelNames.size() > 0) {
              writer.write(123);

              for(int i = 0; i < sample.labelNames.size(); ++i) {
                writer.write((String)sample.labelNames.get(i));
                writer.write("=\"");
                writeEscapedLabelValue(writer, (String)sample.labelValues.get(i));
                writer.write("\",");
              }

              writer.write(125);
            }

            writer.write(32);
            writer.write(Collector.doubleToGoString(sample.value));
            if (sample.timestampMs != null) {
              writer.write(32);
              writer.write(sample.timestampMs.toString());
            }

            writer.write(10);
          } else {
            MetricFamilySamples omFamily = (MetricFamilySamples)omFamilies.get(sample.name);
            if (omFamily == null) {
              omFamily = new MetricFamilySamples(sample.name, Type.GAUGE, metricFamilySamples.help, new ArrayList());
              omFamilies.put(sample.name, omFamily);
            }

            omFamily.samples.add(sample);
          }
        }
      }
    }

    if (!omFamilies.isEmpty()) {
      write004(writer, Collections.enumeration(omFamilies.values()));
    }

  }

  private static void writeEscapedHelp(Writer writer, String s) throws IOException {
    for(int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      switch(c) {
        case '\n':
          writer.append("\\n");
          break;
        case '\\':
          writer.append("\\\\");
          break;
        default:
          writer.append(c);
      }
    }

  }


  private static String typeString(Type t) {
    switch(t) {
      case GAUGE:
        return "gauge";
      case COUNTER:
        return "counter";
      case SUMMARY:
        return "summary";
      case HISTOGRAM:
        return "histogram";
      case GAUGE_HISTOGRAM:
        return "histogram";
      case STATE_SET:
        return "gauge";
      case INFO:
        return "gauge";
      default:
        return "untyped";
    }
  }


  private static void writeEscapedLabelValue(Writer writer, String s) throws IOException {
    for(int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      switch(c) {
        case '\n':
          writer.append("\\n");
          break;
        case '"':
          writer.append("\\\"");
          break;
        case '\\':
          writer.append("\\\\");
          break;
        default:
          writer.append(c);
      }
    }

  }
}
