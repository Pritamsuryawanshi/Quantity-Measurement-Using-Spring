package com.quantitymeasurement.enums;

public enum SubUnits {
    FEET(30.48, Units.LENGTH),
    CENTIMETER(1.0, Units.LENGTH),
    INCH(2.54, Units.LENGTH), YARD(91.44, Units.LENGTH),

    LITRE(1000.0, Units.VOLUME), GALLON(3785.41, Units.VOLUME),
    ML(1.0, Units.VOLUME),

    KG(1000.0, Units.WEIGHT), GRAM(1.0, Units.WEIGHT),
    TONNE(1000000.0, Units.WEIGHT);

    public Units mainUnit;
    public double value;

    SubUnits(double value, Units mainUnit) {
        this.mainUnit = mainUnit;
        this.value = value;
    }
}
