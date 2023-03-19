/* (C)2023 */
package org.example.moonrover.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** created by lovro.vrlec@gmail.com on Mar,2023 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoverNotFoundException extends Exception {

    public RoverNotFoundException() {
        super("Rover Not Found");
    }
}
