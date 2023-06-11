package controller.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import controller.database.DatabaseController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import model.Cliente;
import model.entity.ClienteEntity;

import static controller.exception.SQLExceptionController.readSQLException;

/**
 * Clase gestora de operaciones sobre la tabla Clientes.
 * <br>Se encarga de realizar las operaciones de inserción, borrado y
 * actualización de la tabla.
 * <br>Se encarga de realizar las operaciones de consulta sobre la tabla.
 */
public class ClienteController {

    private static ClienteController instance;

    private DatabaseController databaseController;
    private List<Cliente> listadoClientes;

    /**
     * Singleton del controlador para no crear múltiples instancias.
     *
     * @return el controlador.
     */
    public static ClienteController getInstance() throws EntityControllersException, ConfigurationControllerException {
        if (instance == null) {
            instance = new ClienteController();
        }
        return instance;
    }

    private ClienteController() throws EntityControllersException, ConfigurationControllerException {
        databaseController = DatabaseController.getInstance();
    }

    /**
     * Recoge el listado de clientes del controlador.
     *
     * @return el listado.
     * @throws EntityControllersException si se produce un error en la consulta.
     */
    public List<Cliente> getListadoClientes() throws EntityControllersException {
        listadoClientes = getAllClientes();
        return listadoClientes;
    }

    /**
     * Actualiza la lista de clientes a usar y luego filtra dentro de la propia
     * lista.
     * <br> Se gestionará la acción en la llamada del método.
     *
     * @param nickname Nickname del cliente a buscar.
     * @return Optional de cliente. Este objeto envuelve a la clase, habilitando
     * una serie de utilidades (.orElse, .orElseThrow, .map, etc.) para
     * gestionar el objeto. Asegura los null-checks.
     *
     * @throws EntityControllersException si se produce un error en la consulta.
     */
    public Optional<Cliente> getClienteByNickname(String nickname) throws EntityControllersException {
        if (listadoClientes == null) {
            getListadoClientes();
        }
        return listadoClientes
                .stream()
                .filter(c -> c.getNickname().contains(nickname))
                .findFirst();
    }

    /**
     * Recupera toda la lista de clientes de la base de datos.
     *
     * @return Lista de clientes.
     * @throws EntityControllersException si se produce un error en la consulta.
     */
    private List<Cliente> getAllClientes() throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.selectQuery()); ResultSet rs = ps.executeQuery()) {
            List<Cliente> clientes = new ArrayList<>();
            if (rs.next()) {
                do {
                    Cliente cliente = Cliente.fromResultSet(rs);
                    clientes.add(cliente);
                } while (rs.next());
            }
            return clientes;
        } catch (SQLException ex) {
            throw new EntityControllersException(readSQLException(ex));
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
     * @throws EntityControllersException si se produce un error al insertar.
     */
    public Cliente addCliente(Cliente cliente) throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
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
        } catch (SQLException ex) {
            throw new EntityControllersException(readSQLException(ex));
        }
    }

    /**
     * Recibe un objeto de tipo cliente y lanza un UPDATE a la base de datos.
     *
     * @param cliente
     * @return el mismo cliente.
     * @throws EntityControllersException si se produce un error al actualizar.
     */
    public Cliente updateCliente(Cliente cliente) throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.updateQuery())) {
            //Campos a actualizar. Del primero al quinto.
            prepareInsertOrUpdate(ps, cliente);
            //Campo del where.
            ps.setInt(6, cliente.getIdCliente());
            ps.executeUpdate();
            return cliente;
        } catch (SQLException ex) {
            throw new EntityControllersException(readSQLException(ex));
        }
    }

    /**
     * Borra un cliente de la base de datos.
     *
     * @param cliente
     * @return el mismo cliente.
     * @throws EntityControllersException si se produce un error al borrar.
     */
    public Cliente deleteCliente(Cliente cliente) throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.deleteQuery())) {
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();

            return cliente;
        } catch (SQLException ex) {
            throw new EntityControllersException(readSQLException(ex));
        }
    }

    /**
     * Para evitar repetir código en el insert y update. Ambos usan los cinco
     * campos para sus set/insert.
     * <br>
     *
     * @param ps      El prepared sobre el que se trabaja.
     * @param cliente
     * @throws SQLException Si hubiera algún fallo mientras se procesa el
     *                      prepared.
     * @see ClienteEntity#insertQuery()
     */
    private void prepareInsertOrUpdate(final PreparedStatement ps, Cliente cliente) throws SQLException {
        ps.setString(1, cliente.getNickname());
        ps.setString(2, cliente.getFotoPerfil());
        ps.setString(3, cliente.getNombreApellidos());
        ps.setFloat(4, cliente.getAltura());
        ps.setFloat(5, cliente.getPeso());
    }

}
