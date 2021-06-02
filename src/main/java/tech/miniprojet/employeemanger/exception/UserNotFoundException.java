package tech.miniprojet.employeemanger.exception;

public class UserNotFoundException extends RuntimeException {
	    public UserNotFoundException(String message) {
	        super(message);
	    }
}
