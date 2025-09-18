package Quantity.Lenght;

import core.ConvertionException;

public enum LenghtUnits {
    METERS("meters" , 1.0),
    KILOMETERS("kilometers",1000.0),
    MILES("miles",1609.344);


    private final String element;
    private final double unit;
    LenghtUnits(String element, double unit) {
        this.element = element;
        this.unit = unit;
    }
    public String getElement(){
        return element;
    }

    public double getUnit() {
        return unit;
    }

    public static LenghtUnits fromString(String unitName) throws ConvertionException.UnknownUnitExceptions {
        for (LenghtUnits units : LenghtUnits.values()) {
            if (units.element.equalsIgnoreCase(unitName)) {
                return units;
            }
        }
        throw new ConvertionException.UnknownUnitExceptions(unitName);
    }
}
