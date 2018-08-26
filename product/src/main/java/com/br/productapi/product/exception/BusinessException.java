package com.br.productapi.product.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1480967769977682161L;

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
