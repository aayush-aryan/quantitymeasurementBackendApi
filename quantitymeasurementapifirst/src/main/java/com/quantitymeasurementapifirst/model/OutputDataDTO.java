package com.quantitymeasurementapifirst.model;
import org.springframework.stereotype.Component;
@Component
public class OutputDataDTO {
    private long firstValue;
    private long secondValue;
    private Boolean isEqual;
    private double added_Unit;
    private String baseUnit;

    public OutputDataDTO() {
    }

    public OutputDataDTO(long firstValue, long secondValue, Boolean isEqual) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.isEqual = isEqual;
    }

    public OutputDataDTO(long firstValue, long secondValue, double added_Unit, String baseUnit) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.added_Unit = added_Unit;
        this.baseUnit = baseUnit;
    }

    public String toAddedString() {
        return '{' +
                "firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", added_Unit=" + added_Unit + " " + baseUnit +
                '}';
    }

    public String toComparedString() {
        return '{' +
                "firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                ", isEqual=" + isEqual +
                '}';
    }
}