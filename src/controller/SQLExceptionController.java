package controller;

import java.sql.SQLException;

public class SQLExceptionController {

    public static String readSQLException(SQLException sqle) {
        System.out.println(sqle.getErrorCode() + ": " + sqle.getMessage());
        StringBuilder sb = new StringBuilder();
        switch (sqle.getErrorCode()) {
            case 1406 ->
                sb.append("Valor supera la capacidad del tipo de datos.\n");
            case 1048 ->
                sb.append("Hay una o varias columnas que no admiten valores nulos.\n");
            default ->
                sb.append("Surgió un error al trabajar contra la base de datos.\n");

        }
        return sb
                .append(sqle.getClass().getSimpleName()).append("  -  ") //TODO: Remove debug marks.
                .append("Este fue el error:\n")
                .append(sqle.getErrorCode())
                .append(": ")
                .append(sqle.getMessage())
                .toString();

    }
}
