package org.example.moonrover.model;

import lombok.Data;

/**
 *  created by lovro.vrlec@gmail.com on Mar,2023
 */
@Data
public class Rover extends TableTopObject{

    private Direction direction;

    /**
     * @param coordinates to be placed
     */
    public void setPosition(Coordinates coordinates){
        this.setObjectX(coordinates.getObjectX());
        this.setObjectY(coordinates.getObjectY());
        this.setDirection(coordinates.getDirection());
    }

    /**
     * @return coordinateds and facing of the rover
     */
    public Coordinates getCurrentPosition(){
        return new Coordinates(getObjectX(),getObjectY(),direction);
    }

    /**
     *
     * @return coordinates after moving one spot
     */
    public Coordinates getMoveNextPosition(){
        if(direction.equals(Direction.East)){
            return new Coordinates(
                    getObjectX()+1%getTableTop().getMaxX(),
                    getObjectY(),
                    direction);
        }
        if(direction.equals(Direction.North)){
            return new Coordinates(
                    getObjectX(),
                    getObjectY()+1%getTableTop().getMaxY(),
                    direction);
        }
        if(direction.equals(Direction.West)){
            return new Coordinates(
                    Math.max(getObjectX() - 1, 0),
                    getObjectY(),
                    direction);
        }
        if(direction.equals(Direction.South)){
            return new Coordinates(
                    getObjectX(),
                    Math.max(getObjectY() - 1, 0),
                    direction);
        }
        return new Coordinates(
                getObjectX(),
                getObjectY(),
                direction);
    }




}
