package main;

import controller.data.ClienteController;
import controller.exception.SQLExceptionController;
import controller.database.DatabaseController;

import java.sql.Connection;
import java.sql.SQLException;

import model.Cliente;

public class Main {

    public static void main(String[] args) {


        /*
        System.out
                .printf("Sentencias Ejercicios.")
                .printf(EjercicioEntity.insertQuery())
                .printf("\n")
                .printf(EjercicioEntity.selectQuery())
                .printf("\n")
                .printf(EjercicioEntity.selectQuery().concat(EjercicioEntity.whereId()))
                .printf("\n")
                .printf(EjercicioEntity.deleteQuery())
                .printf("\n")
                .printf(EjercicioEntity.updateQuery())
                .printf("\n")
                .printf("---------------------------------------------------------")
                .printf("\n");
*/
        try {
            ejecutaBackendPruebas();
        } catch (RuntimeException rex) {
            System.err.println(rex.getMessage());
        }
        //ejecutaBackendPruebas();
    }

    private static void ejecutaBackendPruebas() {
        Connection con = DatabaseController.getInstance().getConnection();
        try {
            con.setAutoCommit(false);

     






            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException rex) {
            System.err.println(SQLExceptionController.readSQLException(rex));
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.err.println(SQLExceptionController.readSQLException(ex));
            }
        }
        try {
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(SQLExceptionController.readSQLException(ex));
        }
    }
}
