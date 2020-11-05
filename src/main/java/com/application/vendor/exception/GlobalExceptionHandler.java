package com.application.vendor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.vendor.constant.ErrorConstant;
import com.application.vendor.model.ExceptionResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = VendorException.class)
	public ResponseEntity<ExceptionResponse> VendorNotFoundException(VendorException ex) {
		ExceptionResponse exception = new ExceptionResponse();
		exception.setErrorCode(ex.getCode());
		exception.setMessage(ex.getMessage());
		log.error("App Exception occured :{}", ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> globalException(final Exception ex) {
		ExceptionResponse exception = new ExceptionResponse();
		exception.setErrorCode(ErrorConstant.VENDOR_SAVE_ERROR);
		exception.setMessage(ex.getMessage());
		log.error("Global Exception occured :{}", ex.getCause());
		return new ResponseEntity<ExceptionResponse>(exception, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
