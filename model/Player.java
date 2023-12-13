package model;

import java.io.Serializable;

public class Player implements Serializable {


    private int myX;

    private int myY;

    private boolean myAlive;


    public Player() {
        myX = 0;
        myY = 0;
        this.myAlive = true;

    }





    public int getX() {
        return myX;
    }

    public int getY() {

        return myY;

    }

    public void setX(int theX){
        myX = theX;
    }

    public void setY(int theY){
        myY = theY;
    }

    public void moveNorth(){
        myX--;
    }

    public void moveSouth() {
        myX++;
    }

    public void moveEast() {
        myY++;
    }

    public void moveWest() {
        myY++;
    }


    public boolean isAlive() {
        return myAlive;

    }
}
