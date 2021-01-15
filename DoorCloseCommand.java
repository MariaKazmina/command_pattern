package com.company;

public class DoorCloseCommand implements Command{
    Door door;

    public DoorCloseCommand(Door door){
        this.door = door;
    }

    public void execute(){
        door.close();
    }

    public void undo(){
        door.open();
    }
}
