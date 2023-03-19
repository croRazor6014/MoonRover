package org.example.moonrover.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  created by lovro.vrlec@gmail.com on Mar,2023
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OutsideBoundsException extends Exception{

    public OutsideBoundsException() {
        super("Invalid tabletop position supplied");
    }
}
