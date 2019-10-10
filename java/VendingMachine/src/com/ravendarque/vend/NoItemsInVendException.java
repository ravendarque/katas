package com.ravendarque.vend;

public class NoItemsInVendException extends Exception {

    NoItemsInVendException() {

        super("No items to process in vend transaction");
    }
}
