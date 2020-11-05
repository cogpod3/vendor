package com.application.vendor.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class VendorException extends RuntimeException {

	private static final long serialVersionUID = 4487277874271549662L;

	private String code;

	private String message;

	@Override

	public String toString() {

		return "VendorException [code=" + code + ", message=" + message + "]";

	}

}