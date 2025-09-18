package Quantity.Temperature;

import core.BaseConverter;
import core.ConvertionException;

public class TemperatureConverter implements BaseConverter<TemperatureUnits> {
    @Override
    public double convert(double value, TemperatureUnits from, TemperatureUnits to) throws ConvertionException {
        double celsius;

        switch (from) {
            case CELSIUS:
                return celsius = value;
            case FAHRENHEIT:
                celsius = (value - 32) * 5 / 9;
                break;
            case KELVIN:
                celsius = value - 273.15;
                break;
            default:
                celsius = value;
        }
        switch (to) {
            case CELSIUS:
                return celsius;
            case FAHRENHEIT:
                celsius = (value * 9 / 5) + 32;
                break;
            case KELVIN:
                celsius = value + 273.15;
                break;
            default:
        }
        return celsius;
    }


    @Override
    public TemperatureUnits getUnitFromString(String unitName) throws ConvertionException.UnknownUnitExceptions {
        return TemperatureUnits.fromString(unitName);
    }

}
