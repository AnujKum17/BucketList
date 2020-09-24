package com.logmein.challenge.bucketedit.exception;

public class ItemAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 5578691584272926766L;

	public ItemAlreadyExistsException(String message){
        super(message);
    }
}
