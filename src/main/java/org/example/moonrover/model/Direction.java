package org.example.moonrover.model;

/**
 *  created by lovro.vrlec@gmail.com on Mar,2023
 */
public enum Direction {

    North,
    South,
    West,
    East;

    /**
     * @param rotation wearher we are rotating left or right
     * @return Direction after rotating left or right
     */
    public Direction nextDirection(Rotation rotation){
        if(this.equals(North) && Rotation.Left.equals(rotation)){
            return West;
        } else if(this.equals(North) && Rotation.Right.equals(rotation)){
            return East;
        } else if(this.equals(West) && Rotation.Left.equals(rotation)){
            return South;
        } else if(this.equals(West) && Rotation.Right.equals(rotation)){
            return North;
        } else if(this.equals(East) && Rotation.Left.equals(rotation)){
            return North;
        } else if(this.equals(East) && Rotation.Right.equals(rotation)){
            return South;
        } else if(this.equals(South) && Rotation.Left.equals(rotation)){
            return East;
        } else if(this.equals(South) && Rotation.Right.equals(rotation)){
            return West;
        }
        return North;
    }
}
