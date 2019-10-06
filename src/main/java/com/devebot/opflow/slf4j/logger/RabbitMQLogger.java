package com.devebot.opflow.slf4j.logger;

import com.devebot.opflow.slf4j.client.RabbitMQSender;
import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 *
 * @author acegik
 */
public class RabbitMQLogger implements Logger {

    private String className;

    public RabbitMQLogger(String className) {
        super();

        setClassName(className);
    }

    @Override
    public void debug(String arg0) {
        log("DEBUG", arg0);
    }

    @Override
    public void debug(String arg0, Object arg1) {
        log("DEBUG", arg0);
    }

    @Override
    public void debug(String arg0, Object... arg1) {
        log("DEBUG", arg0);
    }

    @Override
    public void debug(String arg0, Throwable arg1) {
        log("DEBUG", arg0);
    }

    @Override
    public void debug(Marker arg0, String arg1) {
        log("DEBUG", arg1);
    }

    @Override
    public void debug(String arg0, Object arg1, Object arg2) {
        log("DEBUG", arg0);
    }

    @Override
    public void debug(Marker arg0, String arg1, Object arg2) {
        log("DEBUG", arg1);
    }

    @Override
    public void debug(Marker arg0, String arg1, Object... arg2) {
        log("DEBUG", arg1);
    }

    @Override
    public void debug(Marker arg0, String arg1, Throwable arg2) {
        log("DEBUG", arg1);
    }

    @Override
    public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
        log("DEBUG", arg1);
    }

    @Override
    public void error(String arg0) {
        log("ERROR", arg0);
    }

    @Override
    public void error(String arg0, Object arg1) {
        log("ERROR", arg0);
    }

    @Override
    public void error(String arg0, Object... arg1) {
        log("ERROR", arg0);
    }

    @Override
    public void error(String arg0, Throwable arg1) {
        log("ERROR", arg0);
    }

    @Override
    public void error(Marker arg0, String arg1) {
        log("ERROR", arg1);
    }

    @Override
    public void error(String arg0, Object arg1, Object arg2) {
        log("ERROR", arg0);
    }

    @Override
    public void error(Marker arg0, String arg1, Object arg2) {
        log("ERROR", arg1);
    }

    @Override
    public void error(Marker arg0, String arg1, Object... arg2) {
        log("ERROR", arg1);
    }

    @Override
    public void error(Marker arg0, String arg1, Throwable arg2) {
        log("ERROR", arg1);
    }

    @Override
    public void error(Marker arg0, String arg1, Object arg2, Object arg3) {
        log("ERROR", arg1);
    }

    @Override
    public String getName() {
        return className;
    }

    @Override
    public void info(String arg0) {
        log("INFO", arg0);
    }

    @Override
    public void info(String arg0, Object arg1) {
        log("INFO", arg0);
    }

    @Override
    public void info(String arg0, Object... arg1) {
        log("INFO", arg0);
    }

    @Override
    public void info(String arg0, Throwable arg1) {
        log("INFO", arg0);
    }

    @Override
    public void info(Marker arg0, String arg1) {
        log("INFO", arg1);
    }

    @Override
    public void info(String arg0, Object arg1, Object arg2) {
        log("INFO", arg0);
    }

    @Override
    public void info(Marker arg0, String arg1, Object arg2) {
        log("INFO", arg1);
    }

    @Override
    public void info(Marker arg0, String arg1, Object... arg2) {
        log("INFO", arg1);
    }

    @Override
    public void info(Marker arg0, String arg1, Throwable arg2) {
        log("INFO", arg1);
    }

    @Override
    public void info(Marker arg0, String arg1, Object arg2, Object arg3) {
        log("INFO", arg1);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isDebugEnabled(Marker arg0) {
        return true;
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public boolean isErrorEnabled(Marker arg0) {
        return true;
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public boolean isInfoEnabled(Marker arg0) {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled(Marker arg0) {
        return true;
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public boolean isWarnEnabled(Marker arg0) {
        return true;
    }

    @Override
    public void trace(String arg0) {
        log("TRACE", arg0);
    }

    @Override
    public void trace(String arg0, Object arg1) {
        log("TRACE", arg0);
    }

    @Override
    public void trace(String arg0, Object... arg1) {
        log("TRACE", arg0);
    }

    @Override
    public void trace(String arg0, Throwable arg1) {
        log("TRACE", arg0);
    }

    @Override
    public void trace(Marker arg0, String arg1) {
        log("TRACE", arg1);
    }

    @Override
    public void trace(String arg0, Object arg1, Object arg2) {
        log("TRACE", arg0);
    }

    @Override
    public void trace(Marker arg0, String arg1, Object arg2) {
        log("TRACE", arg1);
    }

    @Override
    public void trace(Marker arg0, String arg1, Object... arg2) {
        log("TRACE", arg1);
    }

    @Override
    public void trace(Marker arg0, String arg1, Throwable arg2) {
        log("TRACE", arg1);
    }

    @Override
    public void trace(Marker arg0, String arg1, Object arg2, Object arg3) {
        log("TRACE", arg1);
    }

    @Override
    public void warn(String arg0) {
        log("WARNING", arg0);
    }

    @Override
    public void warn(String arg0, Object arg1) {
        log("WARNING", arg0);
    }

    @Override
    public void warn(String arg0, Object... arg1) {
        log("WARNING", arg0);
    }

    @Override
    public void warn(String arg0, Throwable arg1) {
        log("WARNING", arg0);
    }

    @Override
    public void warn(Marker arg0, String arg1) {
        log("WARNING", arg1);
    }

    @Override
    public void warn(String arg0, Object arg1, Object arg2) {
        log("WARNING", arg0);
    }

    @Override
    public void warn(Marker arg0, String arg1, Object arg2) {
        log("WARNING", arg1);
    }

    @Override
    public void warn(Marker arg0, String arg1, Object... arg2) {
        log("WARNING", arg1);
    }

    @Override
    public void warn(Marker arg0, String arg1, Throwable arg2) {
        log("WARNING", arg1);
    }

    @Override
    public void warn(Marker arg0, String arg1, Object arg2, Object arg3) {
        log("WARNING", arg1);
    }

    private void log(String level, String serializedMessage) {
        RabbitMQSender.getInstance().send(level, serializedMessage);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
