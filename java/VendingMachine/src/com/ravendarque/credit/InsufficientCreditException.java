package com.ravendarque.credit;

public class InsufficientCreditException extends Exception {

    public InsufficientCreditException() {

        super("Insufficient credit for vend");
    }
}
