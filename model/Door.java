package model;

public class Door {

    private boolean myIsLocked;

    private boolean myForeverLocked;

    private Question myQuestion;



    public Door(){
        myIsLocked = true;
        myForeverLocked = false;

    }

    public void unlock() {
        myIsLocked = false;
    }

    public boolean isDoorLocked() {
        return myIsLocked;

    }

    public boolean isDoorForeverLocked() {
        return myForeverLocked;
    }




}
