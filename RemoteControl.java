package com.company;

import java.util.EmptyStackException;
import java.util.Stack;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private boolean flag = false;
    private Stack undoCommand = new Stack();
    private Stack redoCommand = new Stack();

    public RemoteControl() {
        onCommands = new Command[2];
        offCommands = new Command[2];

        Command noCommand = new NoCommand();

        for (int i = 0; i < 2; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand.push(noCommand);
        redoCommand.push(noCommand);
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void deleteButtonWasPushed() {
        try {
            Command c = (Command) undoCommand.peek();
            c.undo();
            redoCommand.push(undoCommand.pop());
            flag = false;
            // showCommandsStackTrace(redoCommand);
        } catch (EmptyStackException e) {
            System.out.println("Отменение невозможно");
            e.printStackTrace();
        }
    }

    public void returnButtonWasPushed() {
        try {
            Command c = (Command) redoCommand.peek();
            c.execute();
            undoCommand.push(redoCommand.pop());
            // showCommandsStackTrace(undoCommand);
        } catch (EmptyStackException e) {
            System.out.println("Возвращение невозможно");
            e.printStackTrace();
        }
    }

    public void onButtonWasPushed(int slot) {
        if (flag == false) {
            redoCommand.clear();
            undoCommand.clear();
        }
        onCommands[slot].execute();
        undoCommand.push(onCommands[slot]);
        flag = true;
        // showCommandsStackTrace(undoCommand);
    }

    public void offButtonWasPushed(int slot) {
        if (flag == false) {
            redoCommand.clear();
            undoCommand.clear();
        }
        offCommands[slot].execute();
        undoCommand.push(offCommands[slot]);
        flag = true;
        // showCommandsStackTrace(undoCommand);
    }

    public void showCommandsStackTrace(Stack stack) {
        for (int i = 1; i < stack.size(); i++) {
            System.out.println("Number command " + i + " Command " + stack.get(i));
        }
    }
}
