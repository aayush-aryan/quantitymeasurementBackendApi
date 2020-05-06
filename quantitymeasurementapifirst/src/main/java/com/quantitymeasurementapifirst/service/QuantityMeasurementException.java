package com.quantitymeasurementapifirst.service;
public class QuantityMeasurementException extends Exception {
    ExceptionType type;
    enum ExceptionType{
        CLASS_NOT_EQUAL,INPUT_UNIT_NOT_AVAILABLE, CANNOT_ADD_TEMPERATURE;
    }

    public QuantityMeasurementException(String message,ExceptionType type) {
        super(message);
        this.type = type;
    }
}