package br.com.ezequiellabs.curso_online.model.exceptions;


public class UserNotFoundLoginException extends RuntimeException {

    public UserNotFoundLoginException(String msg) {
        super(msg);
    }
    
    
    
}
