package com.quantitymeasurementapifirst.model;
import org.springframework.stereotype.Component;
@Component
public class InputDTO {
    private long inputValue;
    private IUnit unitType;

    public InputDTO() {
    }

    public InputDTO(long inputValue, IUnit unitType) {
        this.unitType = unitType;
        this.inputValue = inputValue;
    }

    public IUnit getUnitType() {
        return this.unitType;
    }

    public long getValue() {
        return this.inputValue;
    }
}