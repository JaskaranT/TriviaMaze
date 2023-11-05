package model;

public class Room {

    private Door myDoors[];

    private Question_Answer myQuestion;

    private int myX;

    private int myY;

    private String myDoorNumber;


    public Room(final int theX, final int theY, final String theDoorNumber) {

        if(theX < 0) {
            throw new IllegalArgumentException("x cannot be negative");
        }

        if(theY < 0) {
            throw new IllegalArgumentException("y cannot be negative");
        }




    }

    public boolean unlockDoor() {

    }

    public String Question() {


    }
}
