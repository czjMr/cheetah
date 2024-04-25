package com.cheetah.design.statements.exception;

public class FileNotExistsException extends RuntimeException{

    public FileNotExistsException(String message) {
        super(message);
    }
}
