package com.example.saasutil.enums;

/**
 * kafka topic key
 */
public enum KafkaTopic {

  REST_TEMPLATE("rest-template-log", ""),
  OPERATOR("backend-operator-info", "operator-info"),
  BASIC_ACCOUNT("backend-basicAcount-mod-log", "user-mod-info"),
  ALERT("monitor", "alert");

  String topic;
  String routeKey;
  KafkaTopic(String topic, String routeKey) {
    this.topic = topic;
    this.routeKey = routeKey;
  }

  public String getRouteKey() {
    return routeKey;
  }

  public String getTopic() {
    return topic;
  }
}

