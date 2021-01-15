package com.company;

public class DoorOpenCommand implements Command{

    Door door;

    public DoorOpenCommand(Door door){
        this.door = door;
    }

    public void execute(){
        door.open();
    }

    public void undo(){
        door.close();
    }
}
