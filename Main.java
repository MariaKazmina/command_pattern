package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RemoteControl remoteControl = new RemoteControl();
        Light lightLivingRoom = new Light("LivingRoom");
        LightOnCommand lightOnInLivingRoom = new LightOnCommand(lightLivingRoom);
        LightOffCommand lightOffLivingRoom = new LightOffCommand(lightLivingRoom);

        Door garage = new Door("Garage");
        DoorOpenCommand openCommand = new DoorOpenCommand(garage);
        DoorCloseCommand closeCommand = new DoorCloseCommand(garage);

        remoteControl.setCommand(0, lightOnInLivingRoom, lightOffLivingRoom);
        remoteControl.setCommand(1, openCommand, closeCommand);

        // System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);   // включили свет
        remoteControl.onButtonWasPushed(1);   //открыли дверь
        remoteControl.offButtonWasPushed(0);  // выключили свет
        remoteControl.offButtonWasPushed(1);  //закрыли дверь
        remoteControl.deleteButtonWasPushed();       // отменили команду закрытия двери = открыли дверь
        remoteControl.deleteButtonWasPushed();       //отменили команду выключения света = вкл свет
        remoteControl.returnButtonWasPushed();      //вернули команду выключения света = выкл свет
        remoteControl.onButtonWasPushed(1);
        remoteControl.deleteButtonWasPushed();
        remoteControl.deleteButtonWasPushed();

    }
}
