package model;

import java.io.Serializable;

public class Room implements Serializable {


    private Question myQuestion;

    private Door myNorth;

    private Door mySouth;

    private Door myEast;

    private Door myWest;

    private boolean myVisited;

    private Room myCurrentRoom;


    public Room() {
        myEast = new Door();
        myNorth = new Door();
        myWest = new Door();
        mySouth = new Door();
        myVisited = false;

    }
    public Door getDoor(final String theDoor) {
        Door door = null;
        if(theDoor.equals("north")) {
            door = myNorth;
        }
        else if(theDoor.equals("south")) {
            door = mySouth;
        }
        else if(theDoor.equals("west")) {
            door = myWest;
        }
        else if(theDoor.equals("east")) {
            door = myEast;
        }
        return door;
    }

    public void setNorth(final Door theNorth) {
        myNorth = theNorth;
    }


    public void setSouth(final Door theSouth) {
        mySouth = theSouth;
    }


    public void setEast(final Door theEast) {
        myEast = theEast;
    }


    public void setWest(final Door theWest) {
        myWest = theWest;
    }


    public boolean isVisited() {
        return myVisited;
    }

    public void setMyVisited(boolean theValue) {
        myVisited = theValue;
    }

    public String checkSurroundings() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Current position: ");
        final Door doors[] = {myNorth, mySouth, myWest, myEast};
        final String[] doorString = {"North: " , "South: ", "East: " , "West: "};
        for(int i =0; i<doors.length; i++) {
            sb.append("\n");
            sb.append(doorString[i]);
            if(!doors[i].isDoorLocked()&& doors[i].getAnswered()) {
                sb.append("OPEN");
            }
            else if(doors[i].isDoorLocked() && doors[i].getAnswered()) {
                sb.append("CLOSED");
            }
            else if(doors[i]== null) {
                sb.append("WALL");
            }
            else if(!doors[i].isDoorLocked() && !doors[i].getAnswered()) {
                sb.append("AVAILABLE");
            }
        }

        sb.append("\n");
        return sb.toString();
    }





}