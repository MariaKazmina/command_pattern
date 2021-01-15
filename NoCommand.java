package com.company;

public class NoCommand implements Command {
    public void execute(){}

    @Override
    public void undo() {}
}
