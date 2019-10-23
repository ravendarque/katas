package com.ravendarque.credit;

public class InsufficientCreditException extends Exception {

    InsufficientCreditException() {

        super("Insufficient credit for transaction");
    }
}
