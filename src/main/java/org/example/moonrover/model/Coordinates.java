package org.example.moonrover.model;

import lombok.Data;

@Data
public class Coordinates {
    Integer objectX;
    Integer objectY;
    Direction direction;

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
