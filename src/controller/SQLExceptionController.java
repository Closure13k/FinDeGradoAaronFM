package controller;

import java.sql.SQLException;

public class SQLExceptionController {

    public static String readSQLException(SQLException sqle) {
        final String message = sqle.getMessage();
        if (message.contains("link failure")) {
            return """
                   Error al conectarse contra la base de datos.
                   Es posible que la IP no esté bien configurada o que el servidor no está disponible.""";
        }

        //TODO: Remove debugging checks in production.
        final int errorCode = sqle.getErrorCode();
        StringBuilder sb = new StringBuilder();
        switch (errorCode) {
            case 1406 ->
                sb.append("Valor supera la capacidad del tipo de datos.\n");
            case 1048 ->
                sb.append("Hay una o varias columnas que no admiten valores sin dato.\n");
            case 1062 ->
                sb.append("Se está usando un valor que ya existe en la tabla.\n");
            default ->
                sb.append("Surgió un error al trabajar contra la base de datos.\n");

        }
        return sb
                .append(sqle.getClass().getSimpleName()).append("  -  ") //TODO: Remove debug marks.
                .append("Información detallada:\n")
                .append(errorCode)
                .append(": ")
                .append(message)
                .toString();

    }
}
