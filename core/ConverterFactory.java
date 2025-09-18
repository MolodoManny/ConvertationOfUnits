package core;

import Quantity.Lenght.LenghtConverter;
import Quantity.Mass.MassConverter;
import Quantity.Temperature.TemperatureConverter;

public class ConverterFactory {
    public static BaseConverter<?> createConverter(String category) throws ConvertionException.UnknownCategoryExceptions{
        switch (category.toLowerCase()){
            case "lenght":
                return new LenghtConverter();
            case "temperature":
                return new TemperatureConverter();
            case "mass":
                return new MassConverter();
            default:
                throw new ConvertionException.UnknownCategoryExceptions(category);
        }

    }
}
