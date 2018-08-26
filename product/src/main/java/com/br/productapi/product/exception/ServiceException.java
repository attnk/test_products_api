package com.br.productapi.product.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -3999538128714378317L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
