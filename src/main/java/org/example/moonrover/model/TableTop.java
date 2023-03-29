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
     * @param rover places the object in this case a Rover object on the tabletop
     * @param coordinates the coordinates of the rover to be placed on the tabletop
     * @throws ObjectAlreadyExistsException if an object occupies already that position
     *                                      and if it is not that very same rover an exception is thrown
     */
    public void placeRover(Rover rover, Coordinates coordinates) throws ObjectAlreadyExistsException {
        if(tableTop[coordinates.getObjectX()][coordinates.getObjectY()] == null) {
            if(this.rover != null){
                tableTop[this.rover.getObjectX()][this.rover.getObjectY()] = null;
            }
            else {
                this.rover = rover;
                this.rover.setTableTop(this);
            }
            tableTop[coordinates.getObjectX()][coordinates.getObjectY()] = rover;
            this.rover.setPosition(coordinates);
        } else {
            if(!tableTop[coordinates.getObjectX()][coordinates.getObjectY()].equals(this.rover)) {
                throw new ObjectAlreadyExistsException();
            }
        }
    }
}
