package ru.iatsuk.usertest.util.exception;

public class AlreadyAddedException extends RuntimeException {
    public AlreadyAddedException(String msg) {
        super(msg + " already added to list");
    }
}
