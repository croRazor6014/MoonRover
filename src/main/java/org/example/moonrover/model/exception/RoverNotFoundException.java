package org.example.moonrover.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoverNotFoundException extends Exception{

    public RoverNotFoundException() {
        super("Rover Not Found");
    }
}
