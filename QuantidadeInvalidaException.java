

public class QuantidadeInvalidaException extends Exception {
    public static final String MESSAGE = "Quantidade de recursos inválidas!";

    public QuantidadeInvalidaException() {
        super(MESSAGE);
    }

    public QuantidadeInvalidaException(String message) {
        super(MESSAGE + " " + message);
    }

    public QuantidadeInvalidaException(Throwable cause) {
        super(MESSAGE, cause);
    }

    public QuantidadeInvalidaException(String message, Throwable cause) {
        super(MESSAGE + " " + message, cause);
    }

    public QuantidadeInvalidaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
    }
}
