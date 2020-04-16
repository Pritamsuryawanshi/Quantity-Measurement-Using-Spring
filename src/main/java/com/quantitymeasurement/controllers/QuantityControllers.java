package com.quantitymeasurement.controllers;

import com.quantitymeasurement.dto.ConvertDTO;
import com.quantitymeasurement.dto.ResponseDTO;
import com.quantitymeasurement.enums.SubUnits;
import com.quantitymeasurement.enums.Units;
import com.quantitymeasurement.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/units/convert")
    public ResponseEntity<ResponseDTO> getAllSubUnits(@RequestBody ConvertDTO convertDTO) {
        double convertedValue = quantityService.convert(convertDTO);
        ResponseDTO responseDTO = new ResponseDTO(convertedValue, "Converted Successful", 200);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
