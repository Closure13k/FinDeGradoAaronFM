package db;

import controller.SQLExceptionController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase representa una conexión a una base de datos MySQL.
 * Proporciona métodos para establecer y cerrar la conexión, así como
 * para obtener la conexión activa.
 */
/******************************************************************************
 * TODO: Reemplazar URL y credenciales por archivo de configuración externo.
 ******************************************************************************/
public class DatabaseConnection {
    // URLs de la base de datos
    private static final String DB_URL_WIFI = "jdbc:mysql://192.168.0.28:3306/TFG";
    private static final String DB_URL_MOVIL = "jdbc:mysql://192.168.235.131:3306/TFG";

    // Credenciales de administrador
    public static final String ADMIN = "admin";
    public static final String ADMIN_PASSWORD = "a";

    // Instancia única de DatabaseConnection (patrón Singleton)
    private static DatabaseConnection instance = null;
    private Connection connection;

    /**
     * Constructor privado para evitar la creación de instancias directamente.
     * Utiliza el patrón Singleton para garantizar una única instancia de la clase.
     */
    private DatabaseConnection() {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(SQLExceptionController.readSQLException(e));
        }
    }

    /**
     * Devuelve la instancia única de DatabaseConnection.
     *
     * @return La instancia única de DatabaseConnection.
     */
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /**
     * Establece una conexión con la base de datos utilizando el URL especificado y las credenciales de administrador.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    private void connect() throws SQLException {
        if(connection != null) {
            return;
        }
        connection = DriverManager.getConnection(
                DB_URL_MOVIL,
                ADMIN,
                ADMIN_PASSWORD
        );
    }

    /**
     * Cierra la conexión con la base de datos.
     *
     * @throws SQLException Si ocurre un error al cerrar la conexión.
     */
    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
        instance = null;
    }

    /**
     * Obtiene la conexión establecida con la base de datos.
     *
     * @return La conexión establecida con la base de datos.
     */
    public Connection getConnection() {
        return connection;
    }
}


