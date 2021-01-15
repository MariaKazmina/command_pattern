package com.company;

public class Light {

    private String location;

    public Light(String location){
        this.location = location;
    }

    public void on(){
        System.out.println("Light's on");
    }

    public void off(){
        System.out.println("Light's off");
    }
}
