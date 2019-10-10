package com.ravendarque.vend;

public class InsufficientCreditException extends Exception {

    InsufficientCreditException() {

        super("Insufficient credit for transaction");
    }
}
