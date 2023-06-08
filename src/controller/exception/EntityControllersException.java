package controller.exception;

import java.sql.SQLException;

public class EntityControllersException extends SQLException {
    public EntityControllersException(String reason) {
        super(reason);
    }

}
