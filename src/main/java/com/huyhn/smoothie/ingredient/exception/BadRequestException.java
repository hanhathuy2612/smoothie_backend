package com.huyhn.smoothie.ingredient.exception;

/**
 * Exception
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
