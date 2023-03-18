package org.example.moonrover.model;

import lombok.Data;
import org.example.moonrover.model.exception.ObjectAlreadyExistsException;

/**
 *  created by lovro.vrlec@gmail.com on Mar,2023
 */
@Data
public class TableTop {
    private TableTopObject[][] tableTop;
    private Rover rover;
    private int maxX;
    private int maxY;

    /**
     * @param dimensionX width of the tabletop
     * @param dimensionY height of the tabletop
     */
    public TableTop(int dimensionX, int dimensionY){
        this.tableTop = new TableTopObject[dimensionX][dimensionY];
        this.maxX = dimensionX;
        this.maxY= dimensionY;
    }


    /**
     * @param object places the object in this case a Rover object on the tabletop
     * @param coordinates the coordinates of the rover to be placed on the tabletop
     * @throws ObjectAlreadyExistsException if an object occupies already that position
     *                                      and if it is not that very same rover an exception is thrown
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
