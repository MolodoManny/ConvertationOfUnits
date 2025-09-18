package core;

public class ConvertionException extends RuntimeException {
    public ConvertionException(String message) {
        super(message);
    }


    public static class UnknownCategoryExceptions extends ConvertionException{
        public UnknownCategoryExceptions(String category){
            super("Ошибка: Неизвестная категория " + category);
        }
    }
    public static class UnknownUnitExceptions extends ConvertionException{
        public UnknownUnitExceptions(String unit){
            super("Ошибка: Неизвестная единица " + unit);
        }
    }

    public class InvalidConvertationExceptions extends ConvertionException{
        public InvalidConvertationExceptions(String from, String to){
            super("Ошибка: Невозможно конвертировать из " + from + " в " + to);
        }
    }
}
