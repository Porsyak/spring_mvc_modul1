package org.example.app.exception;

import lombok.Getter;

@Getter
public class BookShelfLoginException extends RuntimeException {

    private final String massage;

    public BookShelfLoginException(String massage) {
        this.massage = massage;
    }

}
