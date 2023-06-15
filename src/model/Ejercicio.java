package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Representación de la tabla Ejercicios.
 *
 * @author AaronFM
 */
public class Ejercicio {

    private int idEjercicio;
    private String tipo;
    private String fotoEjercicio;
    private String instrucciones;
    private float record;
    private float promedio;

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Ejercicio fromResultSet(ResultSet rs) throws SQLException {
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setIdEjercicio(rs.getInt("id_ejercicio"));
        ejercicio.setTipo(rs.getString("tipo"));
        ejercicio.setFotoEjercicio(rs.getString("foto_ejercicio"));
        ejercicio.setInstrucciones(rs.getString("instrucciones"));
        ejercicio.setRecord(rs.getFloat("record"));
        ejercicio.setPromedio(rs.getFloat("promedio"));
        return ejercicio;
    }
    /**
     * Genera un ejercicio en base al recibido.
     * @param e
     * @return 
     */
    public static Ejercicio forUpdate(Ejercicio e) {
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setIdEjercicio(e.getIdEjercicio());
        ejercicio.setTipo(e.getTipo());
        ejercicio.setFotoEjercicio(e.getFotoEjercicio());
        ejercicio.setInstrucciones(e.getInstrucciones());
        ejercicio.setRecord(e.getRecord());
        ejercicio.setPromedio(e.getPromedio());
        return ejercicio;
    }

    /**
     * Instancia un nuevo ejercicio.
     */
    public Ejercicio() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">

    /**
     *
     * @return
     */
    public int getIdEjercicio() {
        return idEjercicio;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @return
     */
    public String getFotoEjercicio() {
        return fotoEjercicio;
    }

    /**
     *
     * @return
     */
    public String getInstrucciones() {
        return instrucciones;
    }

    /**
     *
     * @return
     */
    public float getRecord() {
        return record;
    }

    /**
     *
     * @return
     */
    public float getPromedio() {
        return promedio;
    }

    /**
     *
     * @param idEjercicio
     */
    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @param fotoEjercicio
     */
    public void setFotoEjercicio(String fotoEjercicio) {
        this.fotoEjercicio = fotoEjercicio;
    }

    /**
     *
     * @param instrucciones
     */
    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    /**
     *
     * @param record
     */
    public void setRecord(float record) {
        this.record = record;
    }

    /**
     *
     * @param promedio
     */
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    //</editor-fold>

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Ejercicio{"
                + "idEjercicio=" + idEjercicio
                + ", tipo=" + tipo
                + ", fotoEjercicio=" + fotoEjercicio
                + ", instrucciones=" + instrucciones
                + ", record=" + record
                + ", promedio=" + promedio
                + '}';
    }

}
