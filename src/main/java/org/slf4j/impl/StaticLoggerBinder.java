package org.slf4j.impl;

import com.devebot.opflow.slf4j.client.RabbitMQSender;
import com.devebot.opflow.slf4j.client.RabbitMQConfig;
import com.devebot.opflow.slf4j.logger.RabbitMQLoggerFactory;

import java.io.IOException;
import java.util.Properties;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * The binding of {@link LoggerFactory} class with an actual instance of
 * {@link ILoggerFactory} is performed using information returned by this class.
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {

    /**
     * Declare the version of the SLF4J API this implementation is compiled against. The value of
     * this field is usually modified with each release. Per SLF4J,
     * "To avoid constant folding by the compiler, this field must *not* be final".
     */
    public static String REQUESTED_API_VERSION = "1.7";
    
    /**
     * The unique instance of this class.
     */
    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    /**
     * Return the singleton of this class.
     *
     * @return the StaticLoggerBinder singleton
     */
    public static final StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    /**
     * The ILoggerFactory instance returned by the {@link #getLoggerFactory} method should always be
     * the same object.
     */
    private final ILoggerFactory loggerFactory;

    private StaticLoggerBinder() {
        super();

        Properties props = new Properties();
        try {
            ClassLoader classLoader = StaticLoggerBinder.class.getClassLoader();
            props.load(classLoader.getResourceAsStream("slf4j-amqp.properties"));

            String username = props.getProperty("username");
            
            String password = props.getProperty("password");
            
            String host = props.getProperty("host");
            
            Integer port = 5672;
            if (props.getProperty("port") != null) {
                port = Integer.valueOf(props.getProperty("port"));
            }
            
            String virtualHost = props.getProperty("virtualHost");
            
            String exchange = props.getProperty("exchange");
            
            String routingKey = props.getProperty("routingKey");

            RabbitMQConfig config = new RabbitMQConfig(username, password, host, port, virtualHost, exchange, routingKey);

            RabbitMQSender.getInstance().setConfig(config);
        } catch (IOException throwable) {
            throw new RuntimeException(throwable);
        }
        
        loggerFactory = new RabbitMQLoggerFactory();
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return RabbitMQLoggerFactory.class.getName();
    }
}
