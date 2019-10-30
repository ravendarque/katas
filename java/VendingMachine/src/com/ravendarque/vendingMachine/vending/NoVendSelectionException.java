package com.ravendarque.vendingMachine.vending;

public class NoVendSelectionException extends Exception {

    public NoVendSelectionException() {

        super("No rail has been selected to vend");
    }
}
