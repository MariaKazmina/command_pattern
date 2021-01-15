package com.company;

public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(){}

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWathPressed(){
        System.out.println("CLick on button");
        slot.execute();
    }
}
