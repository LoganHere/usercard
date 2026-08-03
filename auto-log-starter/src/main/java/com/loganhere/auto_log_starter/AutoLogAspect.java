package com.loganhere.auto_log_starter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class AutoLogAspect {
    private final AutoLogProperties properties;

    public AutoLogAspect(AutoLogProperties properties) {
        this.properties = properties;
    }

    @Around("@annotation(autoLog)")
    public Object logMethod(ProceedingJoinPoint joinPoint, AutoLog autoLog) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        String operation = autoLog.value();
        if (operation.isEmpty()) {
            operation = joinPoint.getSignature().getName();
        }

        long start = System.currentTimeMillis();

        logMessage(log, autoLog, ">>> {} | args: {}", operation, Arrays.toString(joinPoint.getArgs()));

        try {
            Object result = joinPoint.proceed();
            long time = System.currentTimeMillis() - start;

            logMessage(log, autoLog, "<<< {} | time: {}ms | result: {}", operation, time, result);

            return result;

        } catch (Exception e) {
            long time = System.currentTimeMillis() - start;

            logMessage(log, autoLog, "<<< {} | time: {}ms | ERROR: {}", operation, time, e.getMessage());
            throw e;
        }
    }

    private void logMessage(Logger log, AutoLog autoLog, String format, Object... args) {
        switch (autoLog.level()) {
            case TRACE -> log.trace(format, args);
            case DEBUG -> log.debug(format, args);
            case WARN  -> log.warn(format, args);
            case ERROR -> log.error(format, args);
            default    -> log.info(format, args);
        }
    }
}
