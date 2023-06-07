package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db.DatabaseConnection;
import model.Cliente;
import model.entity.ClienteEntity;

/**
 * Clase gestora de operaciones sobre la tabla Clientes.
 * <br>Se encarga de realizar las operaciones de inserción, borrado y actualización de la tabla.
 * <br>Se encarga de realizar las operaciones de consulta sobre la tabla.
 */
public class ClienteController {
    private static ClienteController instance;

    public static ClienteController getInstance() {
        if (instance == null) {
            instance = new ClienteController();
        }
        return instance;
    }

    private ClienteController() {
    }

    private List<Cliente> listadoClientes;

    public List<Cliente> getListadoClientes() {
        try {
            listadoClientes = getAllClientes();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listadoClientes;
    }

    public Optional<Cliente> getCliente(int id) {
        return getListadoClientes()
                .stream()
                .filter(c -> c.getIdCliente() == id)
                .findFirst();
    }

    private List<Cliente> getAllClientes() throws SQLException {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.selectQuery());
             ResultSet rs = ps.executeQuery()
        ) {
            List<Cliente> clientes = new ArrayList<>();
            if (rs.next()) {
                clientes = new ArrayList<>();
                do {
                    Cliente cliente = Cliente.fromResultSet(rs);
                    clientes.add(cliente);
                } while (rs.next());
            }
            return clientes;
        } catch (SQLException e) {
            throw e;
        }
    }
    public Cliente addCliente(Cliente cliente) {
        try {
            Connection dbCon = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.insertQuery(), Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, cliente.getNickname());
                ps.setString(2, cliente.getNombreApellidos());
                ps.setFloat(3, cliente.getAltura());
                ps.setFloat(4, cliente.getPeso());
                ps.setString(5, cliente.getFotoPerfil());
                ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();
                if(keys.next()){
                    cliente.setIdCliente(keys.getInt(1));
                }
                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCliente(Cliente cliente) {
        try {
            Connection dbCon = DatabaseConnection.getInstance().getConnection();
            try (PreparedStatement ps = dbCon.prepareStatement(ClienteEntity.updateQuery())) {
                ps.setString(1, cliente.getNickname());
                ps.setString(2, cliente.getNombreApellidos());
                ps.setFloat(3, cliente.getAltura());
                ps.setFloat(4, cliente.getPeso());
                ps.setString(5, cliente.getFotoPerfil());
                ps.setInt(6, cliente.getIdCliente());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
