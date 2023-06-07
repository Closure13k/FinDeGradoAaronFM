package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db.DatabaseConnection;
import model.Cliente;
import model.entity.ClienteEntity;

import static controller.SQLExceptionController.readSQLException;

/**
 * Clase gestora de operaciones sobre la tabla Clientes.
 * <br>Se encarga de realizar las operaciones de inserción, borrado y
 * actualización de la tabla.
 * <br>Se encarga de realizar las operaciones de consulta sobre la tabla.
 */
public class ClienteController {

    private static ClienteController instance;

    /**
     * Singleton del controlador para no crear múltiples instancias.
     *
     * @return el controlador.
     */
    public static ClienteController getInstance() {
        if (instance == null) {
            instance = new ClienteController();
        }
        return instance;
    }

    private ClienteController() {
    }

    private List<Cliente> listadoClientes;

    /**
     * Recoge el listado de clientes del controlador.
     *
     * @return el listado.
     */
    public List<Cliente> getListadoClientes() {
        listadoClientes = getAllClientes();
        return listadoClientes;
    }

    /**
     * Actualiza la lista de clientes a usar y luego filtra dentro de la propia
     * lista.
     * <br> Se gestionará la acción en la llamada del método.
     *
     * @param id
     * @return Optional de cliente. Este objeto envuelve a la clase, habilitando
     * una serie de utilidades (.orElse, .orElseThrow, .map, etc.) para
     * gestionar el objeto. Asegura los null-checks.
     */
    public Optional<Cliente> getCliente(int id) {
        return getListadoClientes()
                .stream()
                .filter(c -> c.getIdCliente() == id)
                .findFirst();
    }

    /**
     * Recupera toda la lista de clientes de la base de datos.
     *
     * @return Lista de clientes.
     */
    private List<Cliente> getAllClientes() {
        try {
            Connection dbCon = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.selectQuery()); ResultSet rs = ps.executeQuery()) {
                List<Cliente> clientes = new ArrayList<>();
                if (rs.next()) {
                    clientes = new ArrayList<>();
                    do {
                        Cliente cliente = Cliente.fromResultSet(rs);
                        clientes.add(cliente);
                    } while (rs.next());
                }
                return clientes;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(readSQLException(ex));
        }
    }

    /**
     * Añade un nuevo cliente a la base de datos.
     * <br>
     * Una vez se añade el cliente, se recupera el ID que generó su clave auto
     * incremental. Se actualiza el objeto que se pasó para que muestre dicha
     * clave.
     *
     * @param cliente
     * @return cliente con la clave actualizada.
     */
    public Cliente addCliente(Cliente cliente) {
        try {
            Connection dbCon = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.insertQuery(), Statement.RETURN_GENERATED_KEYS)) {
                //Prepara los campos del statement.
                prepareInsertOrUpdate(ps, cliente);
                ps.executeUpdate();
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        cliente.setIdCliente(keys.getInt(1));
                    }
                }

                return cliente;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(readSQLException(ex));
        }
    }

    /**
     * Recibe un objeto de tipo cliente y lanza un UPDATE a la base de datos.
     *
     * @param cliente
     * @return el mismo cliente.
     */
    public Cliente updateCliente(Cliente cliente) {
        try {
            Connection dbCon = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.updateQuery())) {
                //Campos a actualizar. Del primero al quinto.
                prepareInsertOrUpdate(ps, cliente);
                //Campo del where.
                ps.setInt(6, cliente.getIdCliente());
                ps.executeUpdate();
                return cliente;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(readSQLException(ex));
        }
    }

    public Cliente deleteCliente(Cliente cliente) {
        try {
            Connection dbCon = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.deleteQuery())) {
                ps.setInt(1, cliente.getIdCliente());
                int result = ps.executeUpdate();
                if (result == 0) {
                    throw new RuntimeException("No se pudo borrar el cliente.");
                }
                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(readSQLException(e));
        }
    }

    /**
     * Para evitar repetir código en el insert y update. Ambos usan los cinco
     * campos para sus set/insert.
     * <br>
     *
     * @see ClienteEntity#insertQuery()
     * @param ps El prepared sobre el que se trabaja.
     * @param cliente
     * @throws SQLException Si hubiera algún fallo mientras se procesa el
     * prepared.
     */
    private void prepareInsertOrUpdate(final PreparedStatement ps, Cliente cliente) throws SQLException {
        ps.setString(1, cliente.getNickname());
        ps.setString(2, cliente.getFotoPerfil());
        ps.setString(3, cliente.getNombreApellidos());
        ps.setFloat(4, cliente.getAltura());
        ps.setFloat(5, cliente.getPeso());
    }

}
