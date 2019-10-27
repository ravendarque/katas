package com.ravendarque.vendingMachine.rails;

public class RailEmptyException extends Exception {

    public RailEmptyException() {

        super("Rail is empty)");
    }
}
