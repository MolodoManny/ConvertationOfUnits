package Quantity.Lenght;

import core.BaseConverter;
import core.ConvertionException;

public class LenghtConverter implements BaseConverter<LenghtUnits> {
    @Override
    public double convert(double value, LenghtUnits from, LenghtUnits to) throws ConvertionException {
        double valueInMeters = value * from.getUnit();
        return valueInMeters / to.getUnit();
    }

    @Override
    public LenghtUnits getUnitFromString(String unitName) throws ConvertionException.UnknownUnitExceptions {
        return LenghtUnits.fromString(unitName);
    }

}
