package ro.itschool.exception;

public class CityNotFoundException extends Exception{
    public CityNotFoundException(final String message) {
        super(message);
    }
}
