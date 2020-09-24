package com.logmein.challenge.bucketedit.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -2932455674090095343L;

	public ValidationException(String message){
        super(message);
    }
}
