package com.abhi.rest.intercept.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.resteasy.annotations.interception.Precedence;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Precedence("HIGHEST_PRECEDENCE")
public @interface HighestPrecedence {

}
