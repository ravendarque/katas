package com.ravendarque.vendingMachine.credit;

public class InsufficientCreditException extends Exception {

    public InsufficientCreditException() {

        super("Insufficient credit for vend");
    }
}
