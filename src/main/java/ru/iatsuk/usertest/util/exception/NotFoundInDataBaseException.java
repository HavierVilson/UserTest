package ru.iatsuk.usertest.util.exception;

public class NotFoundInDataBaseException extends RuntimeException {
    public NotFoundInDataBaseException(String msg) {
        super(msg + " not founded in list");
    }
}
