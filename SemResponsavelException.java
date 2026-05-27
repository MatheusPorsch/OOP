

public class SemResponsavelException extends Exception {
    public static final String MESSAGE = "Nenhum responsável foi designado para a Tarefa!";

    public SemResponsavelException() {
        super(MESSAGE);
    }

    public SemResponsavelException(String message) {
        super(MESSAGE + " " + message);
    }

    public SemResponsavelException(Throwable cause) {
        super(MESSAGE, cause);
    }

    public SemResponsavelException(String message, Throwable cause) {
        super(MESSAGE + " " + message, cause);
    }

    public SemResponsavelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
    }
}
