package com.vim.util;
//todo done
//Follow TODOs (if available)
/**
 * 
 * This is a ServiceLocatorException class
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */
 
 //TODO 1 Implement it as a Unchecked Exception
public class ServiceLocatorException extends RuntimeException{

    public ServiceLocatorException() {
        super();
    }

    public ServiceLocatorException(String message) {
        super(message);
    }

    public ServiceLocatorException(Throwable cause) {
        super(cause);
    }

    public ServiceLocatorException(String message, Throwable cause) {
        super(message, cause);
    }

}
