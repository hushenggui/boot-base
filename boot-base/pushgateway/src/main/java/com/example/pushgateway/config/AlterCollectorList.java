package com.example.pushgateway.config;

import io.prometheus.client.Collector;
import io.prometheus.client.CounterMetricFamily;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.util.CollectionUtils;

/**
 * @program: components
 * @description:
 * @author: hushenggui
 * @create: 2021-03-10 14:42
 **/
@Data
public class AlterCollectorList extends Collector implements Serializable {
    private Map<String, Object> labels;
    private int value;

    private List labelsListNew ;
    private List metricListNew ;

    public AlterCollectorList(ArrayList labelsListNew, ArrayList metricListNew ,int value){
        this.labelsListNew = labelsListNew;
        this.metricListNew = metricListNew;
        this.value = value;
    }
    @Override
    public List<MetricFamilySamples> collect() {
        String gauge = "SaaS";
        List<MetricFamilySamples> mfs = new ArrayList<>();
        if(!CollectionUtils.isEmpty(labels)){
            for (Map.Entry<String, Object> entry : labels.entrySet()){
                labelsListNew.add(entry.getKey());
                metricListNew.add(entry.getValue());
            }
        }
        CounterMetricFamily labeledGauge = new CounterMetricFamily(gauge, "help", labelsListNew);
        labeledGauge.addMetric(metricListNew, value );
        mfs.add(labeledGauge);
        return mfs;
    }
}
