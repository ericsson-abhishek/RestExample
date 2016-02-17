package com.abhi.rest.intercept.validator;

import org.jboss.resteasy.spi.HttpRequest;

public interface BaseValidator {

	public void validate(HttpRequest req);
}
