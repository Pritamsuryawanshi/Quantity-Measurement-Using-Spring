package com.quantitymeasurement.service;

import com.quantitymeasurement.enums.Units;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class QuantityService {

    public Units[] getMainUnits() {
        return Units.values();
    }
}
