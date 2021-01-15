package com.company;

public interface Command {
    void execute();   //выполнить команду
    void undo();      //удалить команду
}
