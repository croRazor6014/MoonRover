package org.example.moonrover.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//TODO Do i need this
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadMoveException extends Exception {

    public BadMoveException() {
        super("Bad Move Exception");
    }
}
