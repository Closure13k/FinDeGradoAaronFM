package controller.exception;

import java.io.IOException;
/**
 * Excepciones personalizadas para InputOutput(específicas de FTP).
 * @author AaronFM
 */
public class FTPControllerException extends IOException {

    /**
     *
     * @param message
     */
    public FTPControllerException(String message) {
        super(message);
    }
}
