package com.loganhere.auto_log_starter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoLog {

    String value() default "";

    LogLevel level() default LogLevel.INFO;

    boolean logExecutionTime() default true;

    boolean logResult() default true;

    boolean logArgs() default true;

    String[] maskFields() default {};

    boolean logOnlyOnError() default false;
}
