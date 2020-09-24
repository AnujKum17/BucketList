package com.logmein.challenge.bucketedit.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3899636763217056193L;

	public ObjectNotFoundException(String message){
        super(message);
    }
}
