package com.devebot.opflow.slf4j.logger;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 *
 * @author acegik
 */
public class RabbitMQLoggerFactory implements ILoggerFactory {

    @Override
    public Logger getLogger(String loggerClassName) {
        return new RabbitMQLogger(loggerClassName);
    }
}
