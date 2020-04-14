package com.quantitymeasurement.controllers;

import com.quantitymeasurement.enums.Units;
import com.quantitymeasurement.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class QuantityControllers {

    @Autowired
    private QuantityService quantityService;

    @GetMapping("/units")
    public Units[] getAllUnits() {
        return quantityService.getMainUnits();
    }

    @GetMapping("/units/{unit}")
    public Stream<SubUnits> getAllSubUnits(@PathVariable Units unit) {
        return quantityService.getSubUnits(unit);
    }
}
