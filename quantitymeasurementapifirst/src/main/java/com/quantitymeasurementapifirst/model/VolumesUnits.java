package com.quantitymeasurementapifirst.model;
public enum VolumesUnits implements IUnit {

    GALLON(3.78), LITRES(1), MILLILITERS(0.001);

    public final double measurementValue;

    VolumesUnits(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    @Override
    public Double conversion() {
        return this.measurementValue;
    }

    @Override
    public String getUnit() {
        return "LITRES";
    }
}