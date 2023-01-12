package br.com.ezequiellabs.curso_online.model.exceptions;


public class WrongPasswordLoginException extends RuntimeException {

    public WrongPasswordLoginException(String msg) {
        super(msg);
    }
    
    
    
}
