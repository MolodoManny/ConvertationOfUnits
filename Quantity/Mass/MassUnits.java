package Quantity.Mass;

import Quantity.Lenght.LenghtUnits;
import core.ConvertionException;

public enum MassUnits {
    KILOGRAMS("kilogram", 1.0), POUNDS("pound", 0.45), OUNCES("ounces", 16.0);

    private final String element;
    private final double unit;

    MassUnits(String element, double unit) {
        this.element = element;
        this.unit = unit;
    }

    public String getElement() {
        return element;
    }

    public double getUnit() {
        return unit;
    }

    public static MassUnits fromString(String unitName) throws ConvertionException.UnknownUnitExceptions {
        for (MassUnits units : MassUnits.values()) {
            if (units.element.equalsIgnoreCase(unitName)) {
                return units;
            }
        }
        throw new ConvertionException.UnknownUnitExceptions(unitName);
    }
}
