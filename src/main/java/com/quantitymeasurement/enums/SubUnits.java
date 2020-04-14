package com.quantitymeasurement.enums;

public enum SubUnits {
    FEET(Units.LENGTH), INCH(Units.LENGTH), YARD(Units.LENGTH), CENTIMETER(Units.LENGTH),

    LITRE(Units.VOLUME), GALLON(Units.VOLUME), ML(Units.VOLUME),

    KG(Units.WEIGHT), GRAM(Units.WEIGHT), TONNE(Units.WEIGHT),

    CELSIUS(Units.TEMPERATURE), FAHRENHEIT(Units.TEMPERATURE);

    public Units mainUnit;

    SubUnits(Units mainUnit) {
        this.mainUnit = mainUnit;
    }
}
