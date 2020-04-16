package com.quantitymeasurement.dto;

import com.quantitymeasurement.enums.SubUnits;

public class ConvertDTO {
    public double value;
    public SubUnits base;
    public SubUnits target;

    public ConvertDTO(double value, SubUnits base, SubUnits target) {
        this.value = value;
        this.base = base;
        this.target = target;
    }
}
