package com.quantitymeasurementapifirst.service;
import com.quantitymeasurementapifirst.model.InputDTO;
import com.quantitymeasurementapifirst.model.OutputDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GetDtoObjects {

    @Autowired
    EnumMapper mapper;

    public InputDTO createInputDtoObject(long measurementUnitValue, String measurementQuantityType) {
        try {
            return new InputDTO(measurementUnitValue, mapper.get(measurementQuantityType));
        } catch (QuantityMeasurementException e) {
            return null;
        }
    }

    public OutputDataDTO createComparisonOutputDtoObject(long measurementUnitValue, long measurementUnitValue1, Boolean isEquals)
    {
        return new OutputDataDTO(measurementUnitValue, measurementUnitValue1, isEquals);
    }

    public OutputDataDTO createAdditionOutputDtoObject(long measurementUnitValue1, long measurementUnitValue2, double output, String unit) {
        return new OutputDataDTO(measurementUnitValue1,measurementUnitValue2,output,unit);
    }
}