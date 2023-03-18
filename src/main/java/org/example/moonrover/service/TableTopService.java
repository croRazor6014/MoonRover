package org.example.moonrover.service;

import lombok.extern.slf4j.Slf4j;
import org.example.moonrover.model.*;
import org.example.moonrover.model.exception.ObjectAlreadyExistsException;
import org.example.moonrover.model.exception.OutsideBoundsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 *  created by lovro.vrlec@gmail.com on Mar,2023
 */
@Service
@Slf4j
@PropertySource("classpath:/application.properties")
public class TableTopService {
    TableTop tableTop;

    public TableTopService( @Value("${tabletop.x}") int configX,
                            @Value("${tabletop.y}") int configY){
        tableTop = new TableTop(configX,configY);
    }

    /**
     * @param coordinates
     * @throws ObjectAlreadyExistsException
     * @throws OutsideBoundsException
     */
    public void placeRover(Coordinates coordinates) throws ObjectAlreadyExistsException, OutsideBoundsException {
        if (isValidCoordinates(coordinates,tableTop)) {

            //TODO refactor
            if (tableTop.getRover() == null) {
                Rover rover = new Rover();
                this.tableTop.placeRover(rover, coordinates);
            } else {
                this.tableTop.placeRover(tableTop.getRover(), coordinates);
            }
        } else {
            throw  new OutsideBoundsException();
        }
    }

    /**
     * @return Coordinates of the rovers position
     */
    public Coordinates reportRover(){
        Rover rover = this.tableTop.getRover();
        return rover.getCurrentPosition();
    }

    /**
     * @return moves Rover in the facing direction by one place
     * @throws ObjectAlreadyExistsException in case there is an obstacle
     */
    public Direction moveRover() throws ObjectAlreadyExistsException {
        Rover rover = this.tableTop.getRover();
        this.tableTop.placeRover(rover,rover.getMoveNextPosition());
        return rover.getDirection();
    }

    /**
     * @param rotation direction of the Rover rotation
     * @return Direction of the rover after the rotation
     */
    public Direction rotateRover(Rotation rotation){
        Rover rover = this.tableTop.getRover();
        rover.setDirection(rover.getDirection().nextDirection(rotation));
        return rover.getDirection();
    }

    /**
     * @param coordinates coordinates where to place the object
     * @param tableTop tabletop needed to see the dimensions and validate against
     * @return boolean weather the coordinates fit within the tabletop
     */
    private boolean isValidCoordinates(Coordinates coordinates, TableTop tableTop){
        return (coordinates.getObjectX()< tableTop.getMaxX() && coordinates.getObjectY() < tableTop.getMaxY());
    }

}
