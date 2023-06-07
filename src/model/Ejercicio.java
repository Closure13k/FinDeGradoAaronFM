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

    public Ejercicio() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public int getIdEjercicio() {
        return idEjercicio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFotoEjercicio() {
        return fotoEjercicio;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public float getRecord() {
        return record;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFotoEjercicio(String fotoEjercicio) {
        this.fotoEjercicio = fotoEjercicio;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void setRecord(float record) {
        this.record = record;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    //</editor-fold>

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
