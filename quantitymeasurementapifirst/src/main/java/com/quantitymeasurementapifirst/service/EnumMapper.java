package com.quantitymeasurementapifirst.service;

import com.quantitymeasurementapifirst.model.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class EnumMapper {
    private Map<String, IUnit> enumMap;

    public EnumMapper() {
        this.enumMap = new HashMap<>();
        enumMap.put("feet", LengthsUnits.FEET);
        enumMap.put("inch", LengthsUnits.INCH);
        enumMap.put("yard", LengthsUnits.YARD);
        enumMap.put("centimeter", LengthsUnits.CENTIMETER);
        enumMap.put("gallon", VolumesUnits.GALLON);
        enumMap.put("liters", VolumesUnits.LITRES);
        enumMap.put("milliliters", VolumesUnits.MILLILITERS);
        enumMap.put("kilogram", WeightsUnits.KILOGRAMS);
        enumMap.put("grams", WeightsUnits.GRAMS);
        enumMap.put("tonnes", WeightsUnits.TONNES);
        enumMap.put("celsius", TemperatureUnit.CELSIUS);
        enumMap.put("fahrenheit", TemperatureUnit.FAHRENHEIT);
    }

    public IUnit get(String unitType) throws QuantityMeasurementException {
        if(enumMap.containsKey(unitType))
            return enumMap.get(unitType);
        throw new QuantityMeasurementException("please enter correct input type",
                QuantityMeasurementException.ExceptionType.INPUT_UNIT_NOT_AVAILABLE);
    }
}