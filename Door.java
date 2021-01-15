package com.company;

public class Door {

    private String location;

    public Door(String location){
        this.location = location;
    }

    public void open(){
        System.out.println("Door's open");
    }

    public void close(){
        System.out.println("Door's close");
    }
}
