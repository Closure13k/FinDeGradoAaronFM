/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cliente;
import model.Ejercicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db.DatabaseConnection;
import model.entity.ClienteEntity;
import model.entity.EjercicioEntity;

import static controller.SQLExceptionController.readSQLException;

/**
 * @author Administrador
 */
public class EjercicioController {

    private static EjercicioController instance;

    private List<Ejercicio> listadoEjercicios;

    /**
     * Singleton del controlador para no crear múltiples instancias.
     *
     * @return el controlador.
     */
    public static EjercicioController getInstance() {
        if (instance == null) {
            instance = new EjercicioController();
        }
        return instance;
    }

    private EjercicioController() {
    }

    /**
     * Recoge el listado de ejercicios del controlador.
     *
     * @return el listado.
     */
    public List<Ejercicio> getListadoEjercicios() {
        listadoEjercicios = getAllEjercicios();
        return listadoEjercicios;
    }

    /**
     * Actualiza la lista de ejercicios a usar y luego filtra dentro de la
     * propia lista.
     *
     * @param type
     * @return
     */
    public Optional<Ejercicio> getEjercicioByTipo(String type) {
        if (listadoEjercicios == null) {
            getListadoEjercicios();
        }
        return listadoEjercicios
                .stream()
                .filter(e -> e.getTipo().contains(type))
                .findFirst();
    }

    /**
     * Recupera toda la lista de ejercicios de la base de datos.
     *
     * @return Lista de ejercicios.
     */
    public List<Ejercicio> getAllEjercicios() {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(EjercicioEntity.selectQuery()); ResultSet rs = ps.executeQuery()) {
            List<Ejercicio> ejercicios = new ArrayList<>();
            if (rs.next()) {
                ejercicios = new ArrayList<>();
                do {
                    Ejercicio ejercicio = Ejercicio.fromResultSet(rs);
                    ejercicios.add(ejercicio);
                } while (rs.next());
            }
            return ejercicios;
        } catch (SQLException ex) {
            throw new RuntimeException(readSQLException(ex));
        }
    }

    /**
     * Añade un ejercicio a la base de datos.
     * <br>
     * Una vez añadido, se le asigna el id generado a la instancia.
     *
     * @param ejercicio
     * @return el ejercicio con su id actualizado.
     */
    public Ejercicio addEjercicio(Ejercicio ejercicio) {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
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
            throw new RuntimeException(readSQLException(ex));
        }
    }

    /**
     * Recibe un ejercicio y lo actualiza en la base de datos.
     *
     * @param ejercicio
     * @return el mismo ejercicio.
     */
    public Ejercicio updateEjercicio(Ejercicio ejercicio) {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(EjercicioEntity.updateQuery())) {
            //Prepara los campos del statement.
            prepareInsertOrUpdate(ps, ejercicio);
            //Campo del where
            ps.setInt(4, ejercicio.getIdEjercicio());
            ps.executeUpdate();
            return ejercicio;
        } catch (SQLException ex) {
            throw new RuntimeException(readSQLException(ex));
        }
    }

    /**
     * Borra un ejercicio de la base de datos.
     *
     * @param ejercicio
     * @return el mismo ejercicio.
     */
    public Ejercicio deleteEjercicio(Ejercicio ejercicio) {
        Connection dbCon = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement ps = dbCon.prepareStatement(EjercicioEntity.deleteQuery())) {
            ps.setInt(1, ejercicio.getIdEjercicio());
            int result = ps.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("No se pudo borrar el ejercicio.");
            }
            return ejercicio;
        } catch (SQLException e) {
            throw new RuntimeException(readSQLException(e));
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
