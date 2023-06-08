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

            var cliente = new Cliente();
            //TODO: Sólo tengo que meter este campo obligatorio.
            cliente.setNickname("Manolo");
            cliente.setNombreApellidos("Manuel García");
            System.out.println(cliente.getIdCliente());
            ClienteController.getInstance().addCliente(cliente);
            //TODO: Tras llamar al addCliente, se actualiza el id de Manolo.
            System.out.println(cliente.getIdCliente());
            //TODO: Subimos la foto al FTP.
            //FTPController.getInstance().uploadFile(imagen);
            //TODO: Tras recoger la foto.
            cliente.setFotoPerfil("patatas");
            //TODO: Actualizamos el cliente.
            ClienteController.getInstance().updateCliente(cliente);






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
