package core;

public interface BaseConverter<T extends Enum<T>>{
    double convert(double value, T from, T to) throws ConvertionException;
    T getUnitFromString(String unitName) throws ConvertionException.UnknownUnitExceptions;
}


