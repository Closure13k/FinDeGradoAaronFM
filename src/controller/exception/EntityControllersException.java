package controller.exception;

import java.sql.SQLException;

/**
 * Identificador personalizado para SQLExceptions.
 * @author AaronFM
 */
public class EntityControllersException extends SQLException {

    /**
     *
     * @param reason
     */
    public EntityControllersException(String reason) {
        super(reason);
    }

}
