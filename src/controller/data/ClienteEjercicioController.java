package controller.data;

import controller.database.DatabaseConnection;
import model.Cliente;
import model.ClienteEjercicio;
import model.Ejercicio;
import model.entity.ClienteEjercicioEntity;
import model.entity.ClienteEntity;
import model.entity.EjercicioEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static controller.exception.SQLExceptionController.readSQLException;


public class ClienteEjercicioController {
    private static ClienteEjercicioController instance;

    private List<ClienteEjercicio> listadoClienteEjercicio;

    /**
     * Singleton del controlador para no crear múltiples instancias.
     *
     * @return el controlador.
     */
    public static ClienteEjercicioController getInstance() {
        if (instance == null) {
            instance = new ClienteEjercicioController();
        }
        return instance;
    }

    private ClienteEjercicioController() {
    }

    /**
     * Recoge el listado del controlador.
     *
     * @return el listado.
     */
    public List<ClienteEjercicio> getListadoClienteEjercicio() {
        listadoClienteEjercicio = getAllClienteEjercicio();
        return listadoClienteEjercicio;
    }

    /**
     * Actualiza la lista de ejercicios a usar y luego filtra dentro de la
     * propia lista.
     * <br> Se gestionará la acción en la llamada del método.
     */
    public List<ClienteEjercicio> getEjerciciosByClienteId(int idCliente) {
        if (listadoClienteEjercicio == null) {
            getListadoClienteEjercicio();
        }
        return listadoClienteEjercicio.stream()
                .filter(clienteEjercicio -> clienteEjercicio.getCliente().getIdCliente() == idCliente)
                .collect(Collectors.toList());
    }

    /**
     * Actualiza la lista de ejercicios a usar y luego filtra dentro de la
     * propia lista.
     * <br> Se gestionará la acción en la llamada del método.
     */
    public List<ClienteEjercicio> getClientesByEjercicioId(int idEjercicio) {
        if (listadoClienteEjercicio == null) {
            getListadoClienteEjercicio();
        }
        return listadoClienteEjercicio.stream()
                .filter(clienteEjercicio -> clienteEjercicio.getEjercicio().getIdEjercicio() == idEjercicio)
                .collect(Collectors.toList());
    }

    /**
     * Recupera toda la lista de cliente_ejercicio de la base de datos.
     *
     * @return Lista de cliente_ejercicio.
     */
    private List<ClienteEjercicio> getAllClienteEjercicio() {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
        try (var ps = dbCon.prepareStatement(ClienteEjercicioEntity.selectQuery());
             var rs = ps.executeQuery()) {
            List<ClienteEjercicio> listado = new ArrayList<>();
            if (rs.next()) {
                do {
                    var ejercicio = new Ejercicio();
                    ejercicio.setIdEjercicio(rs.getInt(ClienteEjercicioEntity.ID_EJERCICIO));
                    ejercicio.setTipo(rs.getString(EjercicioEntity.TIPO));

                    var cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt(ClienteEjercicioEntity.ID_CLIENTE));
                    cliente.setNickname(rs.getString(ClienteEntity.NICKNAME));

                    var clienteEjercicio = ClienteEjercicio.fromResultSet(rs);
                    clienteEjercicio.setEjercicio(ejercicio);
                    clienteEjercicio.setCliente(cliente);

                    listado.add(clienteEjercicio);
                } while (rs.next());
            }
            return listado;
        } catch (SQLException e) {
            throw new RuntimeException(readSQLException(e));
        }
    }

    /**
     * Inserta un cliente_ejercicio en la base de datos.
     *
     * @param clienteEjercicio el cliente_ejercicio a insertar.
     */
    public ClienteEjercicio addClienteEjercicio(ClienteEjercicio clienteEjercicio) {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(ClienteEjercicioEntity.insertQuery())) {

            prepareInsert(clienteEjercicio, ps);

            ps.executeUpdate();
            return clienteEjercicio;
        } catch (SQLException e) {
            throw new RuntimeException(readSQLException(e));
        }
    }

    public ClienteEjercicio updateClienteEjercicio(ClienteEjercicio clienteEjercicio) {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(ClienteEjercicioEntity.updateQuery())) {
            prepareUpdate(clienteEjercicio, ps);

            ps.executeUpdate();
            return clienteEjercicio;
        } catch (SQLException e) {
            throw new RuntimeException(readSQLException(e));
        }
    }

    public ClienteEjercicio deleteClienteEjercicio(ClienteEjercicio clienteEjercicio) {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(ClienteEjercicioEntity.deleteQuery())) {
            ps.setInt(1, clienteEjercicio.getCliente().getIdCliente());
            ps.setInt(2, clienteEjercicio.getEjercicio().getIdEjercicio());
            ps.setDate(3, clienteEjercicio.getFecha());

            ps.executeUpdate();
            return clienteEjercicio;
        } catch (SQLException e) {
            throw new RuntimeException(readSQLException(e));
        }
    }


    /**
     * Prepara el statement para insertar.
     *
     * @param clienteEjercicio el cliente_ejercicio a insertar.
     * @param ps               el PreparedStatement.
     * @throws SQLException
     */
    private void prepareInsert(ClienteEjercicio clienteEjercicio, PreparedStatement ps) throws SQLException {
        ps.setInt(1, clienteEjercicio.getCliente().getIdCliente());
        ps.setInt(2, clienteEjercicio.getEjercicio().getIdEjercicio());
        ps.setDate(3, clienteEjercicio.getFecha());
        ps.setInt(4, clienteEjercicio.getSeries());
        ps.setFloat(5, clienteEjercicio.getPeso());
        ps.setString(6, clienteEjercicio.getComentario());
    }

    /**
     * Prepara el statement para actualizar.
     *
     * @param clienteEjercicio el cliente_ejercicio a actualizar.
     * @param ps               el PreparedStatement.
     * @throws SQLException
     */
    private static void prepareUpdate(ClienteEjercicio clienteEjercicio, PreparedStatement ps) throws SQLException {
        ps.setInt(1, clienteEjercicio.getSeries());
        ps.setFloat(2, clienteEjercicio.getPeso());
        ps.setString(3, clienteEjercicio.getComentario());
        ps.setInt(4, clienteEjercicio.getCliente().getIdCliente());
        ps.setInt(5, clienteEjercicio.getEjercicio().getIdEjercicio());
        ps.setDate(6, clienteEjercicio.getFecha());
    }

}
