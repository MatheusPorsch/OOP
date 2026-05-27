

public class HorarioInvalidoException extends Exception {
    public static final String MESSAGE = "Data informada inválida!";

    public HorarioInvalidoException() {
        super(MESSAGE);
    }

    public HorarioInvalidoException(String message) {
        super(MESSAGE + " " + message);
    }

    public HorarioInvalidoException(Throwable cause) {
        super(MESSAGE, cause);
    }

    public HorarioInvalidoException(String message, Throwable cause) {
        super(MESSAGE + " " + message, cause);
    }

    public HorarioInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
    }
}
