package com.ravendarque;

class InsufficientCreditException extends Exception {

    InsufficientCreditException() {

        super("Insufficient credit for transaction");
    }
}
