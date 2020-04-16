package com.quantitymeasurement.controllers;

import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.enums.SubUnits;
import com.quantitymeasurement.enums.Units;
import com.quantitymeasurement.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityControllers {

    @Autowired
    private QuantityService quantityService;

    @GetMapping("/units")
    public Units[] getAllUnits() {
        return quantityService.getMainUnits();
    }

    @GetMapping("/units/{unit}")
    public List<SubUnits> getAllSubUnits(@PathVariable Units unit) {
        return quantityService.getSubUnits(unit);
    }

    @PostMapping(value = "/units/convert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public double getAllSubUnits(@RequestBody ConvertDTO convertDTO) {
        return quantityService.convert(convertDTO);
    }
}
