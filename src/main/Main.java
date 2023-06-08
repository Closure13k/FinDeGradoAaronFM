package main;

import controller.ClienteController;
import controller.EjercicioController;
import controller.SQLExceptionController;
import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Ejercicio;
import model.entity.EjercicioEntity;

public class Main {

    public static void main(String[] args) {

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        System.out.println(currentTime);

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
        //ejecutaBackendPruebas();
        //ejecutaBackendPruebas();
    }

    private static void ejecutaBackendPruebas() {
        Connection con = DatabaseConnection.getInstance().getConnection();
        try {
            con.setAutoCommit(false);
            EjercicioController ejCon = EjercicioController.getInstance();
            System.out.println(
                    ejCon.getEjercicioByTipo("Cross")
                            .map(Ejercicio::getTipo)
                            .orElseGet(() -> "No hay ejercicio con ese tipo.")
            );
            
            Ejercicio e = new Ejercicio();
            e.setTipo("Sesión de crossfit.");
            //e.setTipo(null); //Excepción.
            e.setInstrucciones("Para lesionarse.");
            
            ejCon.addEjercicio(e);
            System.out.println(e.getIdEjercicio());

            e.setInstrucciones("Nuevas instrucciones.");
            ejCon.updateEjercicio(e);

            System.out.println(
                    ejCon.getEjercicioByTipo("Cross")
                            .map(Ejercicio::getTipo)
                            .orElseGet(() -> "No hay ejercicio con ese tipo.")
            );


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
