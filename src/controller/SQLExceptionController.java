package controller;

import java.sql.SQLException;

public class SQLExceptionController {

    public static String readSQLException(SQLException sqle) {
        System.out.println(sqle.getErrorCode() + ": " + sqle.getMessage());
        StringBuilder sb = new StringBuilder();
        switch (sqle.getErrorCode()) {
            case 1048 ->
                sb.append("Hay una o varias columnas que no admiten valores nulos.\n");
            default ->
                sb.append("Surgió un error al trabajar contra la base de datos.\n");

        }
        return sb
                .append("Este fue el error:\n")
                .append(sqle.getMessage())
                .toString();

    }
}
