package App;

import Quantity.Lenght.LenghtConverter;
import Quantity.Lenght.LenghtUnits;
import Quantity.Mass.MassConverter;
import Quantity.Mass.MassUnits;
import Quantity.Temperature.TemperatureConverter;
import Quantity.Temperature.TemperatureUnits;
import core.BaseConverter;
import core.ConverterFactory;
import core.ConvertionException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду: в формате length/mass/temperature + число в double + meters/kilometers/miles");
            System.out.println(" kilogram/pound/ounces или celsius/fahrenheit/kelvin");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("Выход из программы ");
                break;
            }
            if (input.isEmpty()){
                continue;
            }
            try {
                proccesInput(input);
            }catch (ConvertionException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Ошибка: "+ e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }
        private static void proccesInput (String input) throws ConvertionException {
            String[] parts = input.split(" ");
            if (parts.length !=4){
                throw new ConvertionException("Ошибка: Неверный формат ввода. Ожидается category value from_unit to_unit");
            }
            String category = parts[0];
            String valueStr = parts[1];
            String fromStr = parts[2];
            String toStr = parts[3];

            double value;
            try {
                value = Double.parseDouble(valueStr);
            } catch (NumberFormatException e ){
                throw new ConvertionException("Ошибка: " + valueStr + " не является числом");
            }
            BaseConverter<?> converter = ConverterFactory.createConverter(category);
            if (converter instanceof LenghtConverter){
                LenghtUnits from =((LenghtConverter) converter).getUnitFromString(fromStr);

                LenghtUnits to = ((LenghtConverter) converter).getUnitFromString(toStr);
                
                double result = ((LenghtConverter) converter).convert(value, from, to);
                printResult(value,from,result,to);
            }
            else if (converter instanceof TemperatureConverter){
                TemperatureUnits from =((TemperatureConverter) converter).getUnitFromString(fromStr);

                TemperatureUnits to = ((TemperatureConverter) converter).getUnitFromString(toStr);

                double result = ((TemperatureConverter) converter).convert(value, from, to);
                printResult(value,from,result,to);
            }
            else if (converter instanceof MassConverter){
                MassUnits from =((MassConverter) converter).getUnitFromString(fromStr);

                MassUnits to = ((MassConverter) converter).getUnitFromString(toStr);

                double result = ((MassConverter ) converter).convert(value, from, to);
                printResult(value,from,result,to);
            }
        }

    private static void printResult(double value,Enum<?> from, double result, Enum<?> to) {
        System.out.printf("%.2f %s = %.2f %s%n",value,
                from.name().toUpperCase(),
                result,
                to.name().toUpperCase());
    }
}

