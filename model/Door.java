package model;

public class Door {

    private boolean myIsLocked;



    public Door(){

    }

    public void unlock() {
        myIsLocked = false;
    }

    public void lock() {
        myIsLocked = true;


    }




}
