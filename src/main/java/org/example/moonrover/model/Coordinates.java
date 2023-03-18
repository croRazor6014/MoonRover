package org.example.moonrover.model;

import lombok.Data;

/**
 *  created by lovro.vrlec@gmail.com on Mar,2023
 */
@Data
public class Coordinates {
    private Integer objectX;
    private Integer objectY;
    private Direction direction;

    /**
     * @param objectX
     * @param objectY
     * @param direction
     */
    public Coordinates(Integer objectX, Integer objectY, Direction direction) {
        this.objectX=objectX;
        this.objectY=objectY;
        this.direction=direction;
    }

}
