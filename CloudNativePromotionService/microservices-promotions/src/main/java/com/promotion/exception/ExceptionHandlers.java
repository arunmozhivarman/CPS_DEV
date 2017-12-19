package com.promotion.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
	public class ExceptionHandlers extends BaseExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);
	    public ExceptionHandlers() {
	        super(log);
	        registerMapping(Exception.class, "USER_NOT_FOUND", "User not found", HttpStatus.NOT_FOUND);
	    }
	}

