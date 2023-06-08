package main;

import controller.data.ClienteController;
import controller.data.ClienteEjercicioController;
import controller.data.EjercicioController;
import controller.exception.SQLExceptionController;
import controller.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import model.ClienteEjercicio;

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
        ejecutaBackendPruebas();
        //ejecutaBackendPruebas();
    }

    private static void ejecutaBackendPruebas() {
        Connection con = DatabaseConnection.getInstance().getConnection();
        try {
            con.setAutoCommit(false);

            var controller = ClienteEjercicioController.getInstance();
            var ce = new ClienteEjercicio();
            ce.setCliente(ClienteController.getInstance().getClienteByNickname("user1").orElseThrow());
            ce.setEjercicio(EjercicioController.getInstance().getEjercicioByTipo("Sentadilla").orElseThrow());

            ce.setFecha(new Date(System.currentTimeMillis()));
            ce.setPeso(200);
            ce.setSeries(5);
            ce.setComentario("Probado desde controller.");
            controller.deleteClienteEjercicio(ce);
            controller.addClienteEjercicio(ce);


            ce.setComentario("Probado desde controller 2.");
            ce.setCliente(ClienteController.getInstance().getClienteByNickname("user2").orElseThrow());
            ce.setEjercicio(EjercicioController.getInstance().getEjercicioByTipo("Press Banca").orElseThrow());
            ce.setSeries(10);
            ce.setPeso(10);
            System.out.println(controller.updateClienteEjercicio(ce));

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
