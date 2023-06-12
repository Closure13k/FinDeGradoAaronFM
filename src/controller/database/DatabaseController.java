package controller.database;

import controller.config.ConfigurationController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import controller.exception.SQLExceptionController;
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
public class DatabaseController {

    // Instancia única de DatabaseController (patrón Singleton)
    private static DatabaseController instance = null;

    // Controlador de configuración
    private ConfigurationController configurationController;

    // Conexión a la base de datos
    private Connection connection;

    /**
     * Constructor privado para evitar la creación de instancias directamente.
     * Utiliza el patrón Singleton para garantizar una única instancia de la clase.
     */
    private DatabaseController() throws EntityControllersException, ConfigurationControllerException {
        try {
            configurationController = ConfigurationController.getInstance();
            connect();
        } catch (SQLException e) {
            throw new EntityControllersException(SQLExceptionController.readSQLException(e));
        }
    }

    /**
     * Devuelve la instancia única de DatabaseController.
     *
     * @return La instancia única de DatabaseController.
     * @throws controller.exception.EntityControllersException
     */
    public static DatabaseController getInstance() throws EntityControllersException, ConfigurationControllerException {
        if (instance == null) {
            instance = new DatabaseController();
        }
        return instance;
    }

    /**
     * Establece una conexión con la base de datos utilizando el URL especificado y las credenciales de administrador.
     *
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    private void connect() throws SQLException, ConfigurationControllerException {
        if(connection != null) {
            return;
        }
        String ip = "jdbc:mysql://" + configurationController.getDatabaseIP() +":"+ configurationController.getDatabasePort() + "/TFG";
        connection = DriverManager.getConnection(
                ip,
                configurationController.getDatabaseUser(),
                configurationController.getDatabasePassword()
        );
    }

    /**
     * Cierra la conexión con la base de datos.
     *
     * @throws controller.exception.EntityControllersException
     */
    public void disconnect() throws EntityControllersException  {
        try{
        if (connection != null) {
            connection.close();
            connection = null;
        }
        instance = null;
        } catch (SQLException ex){
            throw new EntityControllersException(ex.getMessage());
        }
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


