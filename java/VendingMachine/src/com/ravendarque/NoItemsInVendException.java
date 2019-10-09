package com.ravendarque;

class NoItemsInVendException extends Exception {

    NoItemsInVendException() {

        super("No items to process in vend transaction");
    }
}
