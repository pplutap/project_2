package com.kodilla.ecommercee.controller;

import java.util.logging.Logger;

public class ProductNotFoundException extends Exception {
    private static final Logger LOGGER = Logger.getLogger( ProductNotFoundException .class.getName());

    public void showtMessage(Long productId){
        LOGGER.warning("Dont find product for id: " + productId);
    }
}
