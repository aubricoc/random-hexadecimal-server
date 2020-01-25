package cat.aubricoc.randomhexadecimal.exception;

public class InvalidPortParameterException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidPortParameterException() {
        super("Invalid port value");
    }
}
