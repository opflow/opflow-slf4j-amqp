package com.devebot.opflow.slf4j.client;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.concurrent.TimeoutException;

public class RabbitMQSender implements AutoCloseable {

    private static RabbitMQSender INSTANCE;
    
    public static RabbitMQSender getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RabbitMQSender();
        }
        return INSTANCE;
    }
    
    private RabbitMQConfig config;
    private ExecutorService threadPoolExecutor = null;
    private Connection conn = null;
    private AMQP.BasicProperties basicProperties = null;

    private RabbitMQSender() {
        super();
    }

    private Connection getConnection() throws IOException, TimeoutException {
        if (conn == null) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUsername(config.getUsername());
            factory.setPassword(config.getPassword());
            factory.setVirtualHost(config.getVirtualHost());
            factory.setHost(config.getHost());
            factory.setPort(config.getPort());

            if (threadPoolExecutor == null) {
                threadPoolExecutor = Executors.newCachedThreadPool();
            }

            conn = factory.newConnection(threadPoolExecutor);
        }
        return conn;
    }
    
    private AMQP.BasicProperties getBasicProperties() {
        if (basicProperties == null) {
            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
            basicProperties = builder.contentType("text/plain").build();
        }
        return basicProperties;
    }
    
    public void send(String level, String message) {
        try {
            Channel channel = getConnection().createChannel();
            channel.basicPublish(config.getExchange(), config.getRoutingKey(), getBasicProperties(), message.getBytes());
            channel.close();
        }
        catch (Exception ioExc) {
            throw new RuntimeException(ioExc);
        }
    }

    public RabbitMQConfig getConfig() {
        return config;
    }

    public void setConfig(RabbitMQConfig config) {
        this.config = config;
    }
    
    @Override
    public void close() {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
        if (conn != null) {
            try {
                conn.close();
            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            finally {
                conn = null;
            }
        }
    }
}
