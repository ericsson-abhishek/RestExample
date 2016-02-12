package com.abhi.rest.intercept.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.abhi.rest.intercept.validator.BaseValidator;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidator {
 
	Class <? extends BaseValidator> [] value();
}
