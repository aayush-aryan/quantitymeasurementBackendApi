package com.quantitymeasurementapifirst.service;

import com.quantitymeasurementapifirst.model.InputDTO;
import com.quantitymeasurementapifirst.model.OutputDataDTO;
import com.quantitymeasurementapifirst.model.TemperatureUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class QuantityMeasurement {

    @Autowired
    private InputDTO inputDTO1;
    @Autowired
    private InputDTO inputDTO2;
    @Autowired
    private GetDtoObjects dtoObjects;
    @Autowired
    private OutputDataDTO outputDTO;


    public QuantityMeasurement() {
    }

    public String compareUnits(long measurementUnitValue1, String measurementQuantityType, long measurementUnitValue2, String measurementQuantityType2) throws QuantityMeasurementException {
        createInputDto(measurementUnitValue1, measurementQuantityType, measurementUnitValue2, measurementQuantityType2);
        boolean isEqual = Double.compare(inputDTO1.getValue() * inputDTO1.getUnitType().conversion(), inputDTO2.getValue() * inputDTO2.getUnitType().conversion()) == 0;
        outputDTO = dtoObjects.createComparisonOutputDtoObject(measurementUnitValue1, measurementUnitValue2, isEqual);
        return outputDTO.toComparedString();
    }

    public String additionOfUnits(long measurementUnitValue1, String measurementQuantityType, long measurementUnitValue2, String measurementQuantityType2) throws QuantityMeasurementException {
        createInputDto(measurementUnitValue1, measurementQuantityType, measurementUnitValue2, measurementQuantityType2);
        if (inputDTO1.getUnitType().getUnit().equals("celsius")) {
            throw new QuantityMeasurementException("Cannot add Temperatures", QuantityMeasurementException.ExceptionType.CANNOT_ADD_TEMPERATURE);
        }
        double output = inputDTO1.getValue() * inputDTO1.getUnitType().conversion() + inputDTO2.getValue() * inputDTO2.getUnitType().conversion();
        outputDTO = dtoObjects.createAdditionOutputDtoObject(measurementUnitValue1, measurementUnitValue2, output, inputDTO1.getUnitType().getUnit());
        return outputDTO.toAddedString();
    }

    public String temperatureComparision(long measurementUnitValue1, String measurementQuantityType, long measurementUnitValue2, String measurementQuantityType2) throws QuantityMeasurementException {
        boolean isEqual;
        createInputDto(measurementUnitValue1, measurementQuantityType, measurementUnitValue2, measurementQuantityType2);
        if (inputDTO1.getUnitType().equals(TemperatureUnit.CELSIUS))
            isEqual = Double.compare(Math.round(inputDTO1.getValue() - TemperatureUnit.FAHRENHEIT.measurementValue * (5 / 9)), Math.round(inputDTO1.getValue() * inputDTO2.getUnitType().conversion())) == 0;
        isEqual =  Double.compare(Math.round((inputDTO2.getValue() * 9 / 5) + 32), Math.round(inputDTO1.getValue())) == 0;
        outputDTO = dtoObjects.createComparisonOutputDtoObject(measurementUnitValue1, measurementUnitValue2, isEqual);
        return outputDTO.toComparedString();
    }

    private void checkMeasurementTypeEquals(InputDTO convertFromDTO, InputDTO convertToDTO) throws QuantityMeasurementException {
        if (!compareMeasurementType(convertFromDTO, convertToDTO)) {
            throw new QuantityMeasurementException("Class Not Equal", QuantityMeasurementException.ExceptionType.CLASS_NOT_EQUAL);
        }
    }

    private boolean compareMeasurementType(InputDTO convertFromDTO, InputDTO convertToDTO) {
        return convertFromDTO.getUnitType().getClass().equals(convertToDTO.getUnitType().getClass());
    }

    private void createInputDto(long measurementUnitValue1, String measurementQuantityType, long measurementUnitValue2, String measurementQuantityType2) throws QuantityMeasurementException {
        inputDTO1 = dtoObjects.createInputDtoObject(measurementUnitValue1, measurementQuantityType);
        inputDTO2 = dtoObjects.createInputDtoObject(measurementUnitValue2, measurementQuantityType2);
        checkMeasurementTypeEquals(inputDTO1, inputDTO2);
    }
}
