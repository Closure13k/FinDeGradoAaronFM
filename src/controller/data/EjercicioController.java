/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.data;

import controller.database.DatabaseController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import static controller.exception.SQLExceptionController.readSQLException;
import model.Ejercicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.entity.EjercicioEntity;

import model.entity.ClienteEjercicioEntity;
import model.entity.ClienteEntity;

/**
 * @author Administrador
 */
public class EjercicioController {

    private static EjercicioController instance;

    private final DatabaseController databaseController;

    /**
     * Singleton del controlador para no crear múltiples instancias.
     *
     * @return el controlador.
     * @throws controller.exception.EntityControllersException
     * @throws controller.exception.ConfigurationControllerException
     */
    public static EjercicioController getInstance() throws EntityControllersException, ConfigurationControllerException {
        if (instance == null) {
            instance = new EjercicioController();
        }
        return instance;
    }

    private EjercicioController() throws EntityControllersException, ConfigurationControllerException {
        databaseController = DatabaseController.getInstance();
    }

    /**
     * Recupera toda la lista de ejercicios de la base de datos.
     *
     * @return Lista de ejercicios.
     * @throws EntityControllersException si se produce un error en la consulta.
     */
    public List<Ejercicio> getAllEjercicios() throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(EjercicioEntity.selectQuery()); ResultSet rs = ps.executeQuery()) {
            List<Ejercicio> ejercicios = new ArrayList<>();
            if (rs.next()) {
                do {
                    Ejercicio ejercicio = Ejercicio.fromResultSet(rs);
                    ejercicios.add(ejercicio);
                } while (rs.next());
            }
            return ejercicios;
        } catch (SQLException ex) {
            throw new EntityControllersException(readSQLException(ex));
        }
    }

    /**
     * Añade un ejercicio a la base de datos.
     * <br>
     * Una vez añadido, se le asigna el id generado a la instancia.
     *
     * @param ejercicio
     * @return el ejercicio con su id actualizado.
     * @throws EntityControllersException si se produce un error al insertar.
     */
    public Ejercicio addEjercicio(Ejercicio ejercicio) throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(EjercicioEntity.insertQuery(), Statement.RETURN_GENERATED_KEYS)) {
            //Prepara los campos del statement.
            prepareInsertOrUpdate(ps, ejercicio);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    ejercicio.setIdEjercicio(keys.getInt(1));
                }
            }
            return ejercicio;
        } catch (SQLException ex) {
            throw new EntityControllersException(readSQLException(ex));
        }
    }

    /**
     * Recibe un ejercicio y lo actualiza en la base de datos.
     *
     * @param ejercicio
     * @return el mismo ejercicio.
     * @throws EntityControllersException si se produce un error al actualizar.
     */
    public Ejercicio updateEjercicio(Ejercicio ejercicio) throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(EjercicioEntity.updateQuery())) {
            //Prepara los campos del statement.
            prepareInsertOrUpdate(ps, ejercicio);
            //Campo del where
            ps.setInt(4, ejercicio.getIdEjercicio());
            ps.executeUpdate();
            return ejercicio;
        } catch (SQLException ex) {
            throw new EntityControllersException(readSQLException(ex));
        }
    }

    /**
     * Borra un ejercicio de la base de datos.
     *
     * @param ejercicio
     * @return el mismo ejercicio.
     * @throws EntityControllersException si se produce un error al borrar.
     */
    public Ejercicio deleteEjercicio(Ejercicio ejercicio) throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(EjercicioEntity.deleteQuery())) {
            ps.setInt(1, ejercicio.getIdEjercicio());
            ps.executeUpdate();

            return ejercicio;
        } catch (SQLException ex) {
            throw new EntityControllersException(readSQLException(ex));
        }
    }

    /**
     * Borra recursivamente.
     *
     * @param ejercicio
     * @return
     * @throws EntityControllersException
     */
    public Ejercicio deleteEjercicioRecursively(Ejercicio ejercicio) throws EntityControllersException {
        Connection dbCon = databaseController.getConnection();
        try (PreparedStatement relacionStatement = dbCon.prepareStatement(ClienteEjercicioEntity.deleteBy(EjercicioEntity.ID_EJERCICIO)); PreparedStatement clienteStatement = dbCon.prepareStatement(EjercicioEntity.deleteQuery())) {
            dbCon.setAutoCommit(false);
            relacionStatement.setInt(1, ejercicio.getIdEjercicio());
            relacionStatement.executeUpdate();
            clienteStatement.setInt(1, ejercicio.getIdEjercicio());
            clienteStatement.executeUpdate();
            dbCon.commit();
            dbCon.setAutoCommit(true);
            return ejercicio;
        } catch (SQLException ex) {
            try {
                dbCon.rollback();
                dbCon.setAutoCommit(true);
            } catch (SQLException ex1) {
                throw new EntityControllersException(readSQLException(ex));
            }
            throw new EntityControllersException(readSQLException(ex));
        }

    }

    /**
     * Para evitar repetir código en insert y update. Ambos usan todos los
     * campos para sus set/insert.
     * <br>
     *
     * @see EjercicioEntity#insertQuery()
     * @param ps El prepared sobre el que trabajo.
     * @param ejercicio
     * @throws SQLException Si hubiera algún fallo mientras se procesa el
     * prepared.
     */
    private void prepareInsertOrUpdate(final PreparedStatement ps, Ejercicio ejercicio) throws SQLException {
        ps.setString(1, ejercicio.getTipo());
        ps.setString(2, ejercicio.getFotoEjercicio());
        ps.setString(3, ejercicio.getInstrucciones());
    }
}
