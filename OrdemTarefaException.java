

public class OrdemTarefaException extends Exception {
    public static final String MESSAGE = "Ordem de execução da tarefa incorreta!";

    public OrdemTarefaException() {
        super(MESSAGE);
    }

    public OrdemTarefaException(String message) {
        super(MESSAGE + " " + message);
    }

    public OrdemTarefaException(Throwable cause) {
        super(MESSAGE, cause);
    }

    public OrdemTarefaException(String message, Throwable cause) {
        super(MESSAGE + " " + message, cause);
    }

    public OrdemTarefaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
    }
}
