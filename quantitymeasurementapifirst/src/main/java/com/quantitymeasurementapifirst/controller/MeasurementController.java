package com.quantitymeasurementapifirst.controller;

import com.quantitymeasurementapifirst.service.QuantityMeasurement;
import com.quantitymeasurementapifirst.service.QuantityMeasurementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
    @RestController
    public  class MeasurementController {

        @Autowired
        private QuantityMeasurement measurement;


        @RequestMapping("/compareUnits")
        @ResponseBody
        public String compareUnits(@RequestParam("unit") long measurementUnitValue1, @RequestParam("unitType1") String measurementQuantityType,
                                   @RequestParam("unit2") long measurementUnitValue2, @RequestParam("unitType2") String measurementQuantityType2) {
            try {
                return measurement.compareUnits(measurementUnitValue1, measurementQuantityType, measurementUnitValue2, measurementQuantityType2);
            } catch (QuantityMeasurementException e) {
                return e.getMessage();
            }
        }

        @RequestMapping("/temperatureCompare")
        @ResponseBody
        public String compareTemperature(@RequestParam("unit1") long measurementUnitValue1, @RequestParam("unitType1") String measurementQuantityType,
                                         @RequestParam("unit2") long measurementUnitValue2, @RequestParam("unitType2") String measurementQuantityType2) {
            try {
                return measurement.temperatureComparision(measurementUnitValue1, measurementQuantityType, measurementUnitValue2, measurementQuantityType2);
            } catch (QuantityMeasurementException e) {
                return e.getMessage();
            }
        }

        @RequestMapping("/addUnits")
        @ResponseBody
        public String addUnits(@RequestParam("unit") long measurementUnitValue1, @RequestParam("unitType1") String measurementQuantityType,
                               @RequestParam("unit2") long measurementUnitValue2, @RequestParam("unitType2") String measurementQuantityType2) {
            try {
                return measurement.additionOfUnits(measurementUnitValue1, measurementQuantityType, measurementUnitValue2, measurementQuantityType2);
            } catch (QuantityMeasurementException e) {
                return e.getMessage();
            }
        }
    }

