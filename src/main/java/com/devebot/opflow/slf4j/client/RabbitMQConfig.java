package com.devebot.opflow.slf4j.client;

/**
 *
 * @author acegik
 */
public class RabbitMQConfig {

    private String username;

    private String password;

    private String virtualHost;

    private String host;

    private Integer port;

    private String exchange;

    private String routingKey;

    public RabbitMQConfig(String username, String password, String host, Integer port, String virtualHost, String exchange, String routingKey) {
        this.username = username;
        this.password = password;
        this.virtualHost = virtualHost;
        this.host = host;
        this.port = port;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public String getExchange() {
        return exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }
}
