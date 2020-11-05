package com.application.vendor.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = -8470428852166469675L;
	private String message;
	private String errorCode;
}