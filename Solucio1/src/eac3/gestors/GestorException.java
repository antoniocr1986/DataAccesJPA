package eac3.gestors;

/**
 *
 * @author joan
 */
public class GestorException extends Exception {

    public GestorException() {
    }

    public GestorException(String message) {
        super(message);
    }

    public GestorException(String message, Throwable cause) {
        super(message, cause);
    }

    public GestorException(Throwable cause) {
        super(cause);
    }

    public GestorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
