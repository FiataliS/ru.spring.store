package ru.spring.store.exceptions;

public class ExistEntityException extends RuntimeException{
    public ExistEntityException(String message) {
        super(message);
    }
}
