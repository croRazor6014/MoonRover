package org.example.moonrover.model;

import lombok.Data;
import org.example.moonrover.model.exception.ObjectAlreadyExistsException;

/**
 *
 */
@Data
public class TableTop {
    private TableTopObject[][] tableTop;
    private Rover rover;
    private int maxX;
    private int maxY;

    /**
     * @param dimensionX
     * @param dimensionY
     */
    public TableTop(int dimensionX, int dimensionY){
        this.tableTop = new TableTopObject[dimensionX][dimensionY];
        this.maxX = dimensionX;
        this.maxY= dimensionY;
    }


    /**
     * @param object
     * @param coordinates
     * @throws ObjectAlreadyExistsException
     */
    public void placeRover(Rover object, Coordinates coordinates) throws ObjectAlreadyExistsException {
        if(tableTop[coordinates.getObjectX()][coordinates.getObjectY()] == null) {
            if(this.rover != null){
                tableTop[rover.getObjectX()][rover.getObjectY()] = null;
            }
            else {
                rover = object;
                rover.setTableTop(this);
            }
            tableTop[coordinates.getObjectX()][coordinates.getObjectY()] = object;

            rover.setPosition(coordinates);


        } else {
            if(!tableTop[coordinates.getObjectX()][coordinates.getObjectY()].equals(rover)) {
                throw new ObjectAlreadyExistsException();
            }
        }
    }
}
