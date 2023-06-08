package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ClienteEjercicio {
    private Cliente cliente;
    private Ejercicio ejercicio;
    private Date fecha;
    private int series;
    private float peso;
    private String comentario;

    public ClienteEjercicio() {
    }


    /**
     * Genera un objeto ClienteEjercicio a partir de un ResultSet.
     * @param rs ResultSet de la consulta.
     * @return ClienteEjercicio.
     * @throws SQLException Excepción de SQL.
     */
    public static ClienteEjercicio fromResultSet(ResultSet rs) throws SQLException {
        ClienteEjercicio clienteEjercicio = new ClienteEjercicio();
        clienteEjercicio.setFecha(rs.getDate("fecha"));
        clienteEjercicio.setSeries(rs.getInt("series"));
        clienteEjercicio.setPeso(rs.getFloat("peso"));
        clienteEjercicio.setComentario(rs.getString("comentario"));

        return clienteEjercicio;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public Cliente getCliente() {
        return cliente;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getSeries() {
        return series;
    }

    public float getPeso() {
        return peso;
    }

    public String getComentario() {
        return comentario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "ClienteEjercicio{" +
                "cliente=" + cliente +
                ", ejercicio=" + ejercicio +
                ", fecha=" + fecha +
                ", series=" + series +
                ", peso=" + peso +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
