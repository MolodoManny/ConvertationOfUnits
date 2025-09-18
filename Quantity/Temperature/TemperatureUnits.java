package Quantity.Temperature;

import Quantity.Lenght.LenghtUnits;
import core.ConvertionException;

public enum TemperatureUnits {
    CELSIUS("celsius",1.0),
    FAHRENHEIT("fahrenheit",33.8),
    KELVIN("kelvin",-272.15);

    private final String element;
    private final double unit;

    TemperatureUnits(String element, double unit) {
        this.element = element;
        this.unit = unit;
    }

    public String getElement() {
        return element;
    }

    public double getUnit() {
        return unit;
    }
    public static TemperatureUnits fromString(String unitName) throws ConvertionException.UnknownUnitExceptions{
        for (TemperatureUnits units : TemperatureUnits.values()){
            if (units.element.equalsIgnoreCase(unitName)){
                return units;
            }
        }
        throw new ConvertionException.UnknownUnitExceptions(unitName);
    }
}
