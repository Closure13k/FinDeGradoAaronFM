package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import static model.entity.ClienteEjercicioEntity.*;

/**
 *
 * @author Administrador
 */
public class ClienteEjercicio {
    private Cliente cliente;
    private Ejercicio ejercicio;
    private Date fecha;
    private int series;
    private float peso;
    private String comentario;

    /**
     * Instancia una nueva relación cliente-ejercicio.
     */
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
        clienteEjercicio.setFecha(rs.getDate(FECHA));
        clienteEjercicio.setSeries(rs.getInt(SERIES));
        clienteEjercicio.setPeso(rs.getFloat(PESO));
        clienteEjercicio.setComentario(rs.getString(COMENTARIO));

        return clienteEjercicio;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @return
     */
    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    /**
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @return
     */
    public int getSeries() {
        return series;
    }

    /**
     *
     * @return
     */
    public float getPeso() {
        return peso;
    }

    /**
     *
     * @return
     */
    public String getComentario() {
        return comentario;
    }

    /**
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @param ejercicio
     */
    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @param series
     */
    public void setSeries(int series) {
        this.series = series;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     *
     * @param comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    //</editor-fold>

    /**
     *
     * @return
     */
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
