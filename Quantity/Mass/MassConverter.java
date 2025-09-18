package Quantity.Mass;

import core.BaseConverter;
import core.ConvertionException;

public class MassConverter implements BaseConverter<MassUnits> {

    public double convert(double value, MassUnits from, MassUnits to) {
        double valueInKilogram = value * from.getUnit();
        return  valueInKilogram / to.getUnit();
    }

    @Override
    public MassUnits getUnitFromString(String unitName) throws ConvertionException.UnknownUnitExceptions {
        return MassUnits.fromString(unitName);
    }
}
