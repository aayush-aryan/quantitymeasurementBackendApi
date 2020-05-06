package com.quantitymeasurementapifirst.controllertest;
import com.quantitymeasurementapifirst.controller.MeasurementController;
import com.quantitymeasurementapifirst.service.QuantityMeasurement;
import com.quantitymeasurementapifirst.service.QuantityMeasurementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.Mockito.when;

public class MeasurementControllerTest {

    @Mock
    QuantityMeasurement measurement;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    MeasurementController controller;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void givenInputDataAndUnitType_ShouldReturnString() {
        try {
            String expectedOutput = "{firstValue=1, secondValue=12, isEqual=true}";
            when(measurement.compareUnits(1, "feet", 12, "inch")).thenReturn(expectedOutput);


            Assert.assertEquals(expectedOutput,
                    controller.compareUnits(1, "feet", 12, "inch"));
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenInputDataAndUnitTypeAsTemperature_ShouldReturnString() {
        try {
            String expectedOutput = "{firstValue=100, secondValue=212, isEqual=true}";
            when(measurement.temperatureComparision(100, "celsius", 212, "fahrenheit")).thenReturn(expectedOutput);
            Assert.assertEquals(expectedOutput,
                    controller.compareTemperature(100, "celsius", 212, "fahrenheit"));
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenInputDataAndUnitTypeToAdd_ShouldReturnString() {
        try {
            String expectedOutput = "{firstValue=1, secondValue=2, added_Unit=36.0 INCH}";
            when(measurement.additionOfUnits(1, "feet", 2, "feet")).thenReturn(expectedOutput);
            Assert.assertEquals(expectedOutput,
                    controller.addUnits(1, "feet", 2, "feet"));
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenInputDataAndUnitTypeWhenMeasurementQuantityTypeMissMatchShouldThrowException() {
        try {
            String expectedOutput = "Class Not Equal";
            when(measurement.compareUnits(1, "feet", 12, "kilogram")).thenReturn(expectedOutput);
            Assert.assertEquals(expectedOutput,
                    controller.compareUnits(1, "feet", 12, "kilogram"));
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }
}