package org.slf4j.impl;

import com.devebot.opflow.slf4j.client.RabbitMQSender;
import com.devebot.opflow.slf4j.client.RabbitMQConfig;
import com.devebot.opflow.slf4j.logger.RabbitMQLoggerFactory;
import com.devebot.opflow.slf4j.util.EnvTool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * The binding of {@link LoggerFactory} class with an actual instance of
 * {@link ILoggerFactory} is performed using information returned by this class.
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {

    public static String SLF4J_AMQP_CONFIG_FILE_KEY = "opflow.slf4j.amqp.configfile";
    
    public static String SLF4J_AMQP_PARAM_PREFIX_KEY = "opflow.slf4j.amqp.param.";
    
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

        Properties props = loadResourceFile();
        
        String username = getParameter(props, "username", String.class, null);
            
        String password = getParameter(props, "password", String.class, null);

        String host = getParameter(props, "host", String.class, "localhost");

        Integer port = getParameter(props, "port", Integer.class, 5672);

        String virtualHost = getParameter(props, "virtualHost", String.class, null);

        String exchange = getParameter(props, "exchange", String.class, null);

        String routingKey = getParameter(props, "routingKey", String.class, null);

        RabbitMQConfig config = new RabbitMQConfig(username, password, host, port, virtualHost, exchange, routingKey);

        RabbitMQSender.getInstance().setConfig(config);
        
        loggerFactory = new RabbitMQLoggerFactory();
    }
    
    private Properties loadResourceFile() {
        Properties props = new Properties();
        try {
            ClassLoader classLoader = StaticLoggerBinder.class.getClassLoader();
            
            String configFile = EnvTool.getSystemProperty(SLF4J_AMQP_CONFIG_FILE_KEY, "slf4j-amqp.properties");
            InputStream is = classLoader.getResourceAsStream(configFile);
            
            if (is == null) {
                throw new IOException("can't read the configuration file [" + configFile + "]");
            }
            
            props.load(is);
            
            return props;
        } catch (IOException throwable) {
            throw new RuntimeException(throwable);
        }
    }
    
    private String getParameterString(Properties props, String paramName) {
        return EnvTool.getSystemProperty(SLF4J_AMQP_PARAM_PREFIX_KEY + paramName, props.getProperty(paramName));
    }
    
    private <T> T getParameter(Properties props, String paramName, Class<T> type, T defval) {
        String str = getParameterString(props, paramName);
        if (str == null) {
            return defval;
        }
        if (type == String.class) {
            return (T) str;
        }
        if (type == Integer.class) {
            return (T) Integer.valueOf(str);
        }
        if (type == Long.class) {
            return (T) Long.valueOf(str);
        }
        if (type == Float.class) {
            return (T) Float.valueOf(str);
        }
        if (type == Double.class) {
            return (T) Double.valueOf(str);
        }
        if (type == Boolean.class) {
            return (T) Boolean.valueOf(str);
        }
        return null;
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
