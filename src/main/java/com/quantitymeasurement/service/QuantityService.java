package com.quantitymeasurement.service;

import com.quantitymeasurement.enums.SubUnits;
import com.quantitymeasurement.enums.Units;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityService {

    public Units[] getMainUnits() {
        return Units.values();
    }

    public List<SubUnits> getSubUnits(Units unit) {
        List<SubUnits> subUnitsStream = Arrays.stream(SubUnits.values())
                .filter(temp -> temp.mainUnit.equals(unit))
                .collect(Collectors.toList());
        return subUnitsStream;
    }
}
