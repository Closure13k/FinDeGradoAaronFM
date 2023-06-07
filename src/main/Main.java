
package main;

import db.DatabaseConnection;
import model.entity.ClienteEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            DatabaseConnection.getInstance().connect();

            var con = DatabaseConnection.getInstance().getConnection();
            var ps = con.prepareStatement(ClienteEntity.insertQuery());
            ps.setString(1, "Prueba insert2");
            ps.setString(2, "Prueba insert2");
            ps.setString(3, "Prueba insert2");
            ps.setFloat(4, 1.0f);
            ps.setFloat(5, 1.0f);
            int i = ps.executeUpdate();
            System.out.println("Filas insertadas: " + i);


            DatabaseConnection.getInstance().disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(ClienteEntity.insertQuery());
        System.out.println(ClienteEntity.deleteQuery());
        System.out.println(ClienteEntity.updateQuery());

    }
    
}
