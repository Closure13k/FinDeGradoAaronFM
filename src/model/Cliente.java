package model;


import java.sql.ResultSet;
import java.sql.SQLException;

import static model.entity.ClienteEntity.*;

/**
 * Representación de la tabla Clientes.
 *
 * @author AaronFM
 */
public class Cliente {

    private int idCliente;
    private String nickname;
    private String fotoPerfil;
    private String nombreApellidos;
    private float altura;
    private float peso;

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Cliente fromResultSet(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt(ID_CLIENTE));
        cliente.setNickname(rs.getString(NICKNAME));
        cliente.setNombreApellidos(rs.getString(NOMBRE_APELLIDOS));
        cliente.setAltura(rs.getFloat(ALTURA));
        cliente.setPeso(rs.getFloat(PESO_CLIENTE));
        cliente.setFotoPerfil(rs.getString(FOTO_PERFIL));
        return cliente;
    }
    /**
     * Genera un nuevo cliente a partir del recibido.
     * <br>
     * Similar a un método .copyWith()
     * @param c
     * @return 
     */
    public static Cliente forUpdate(Cliente c) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(c.getIdCliente());
        cliente.setNickname(c.getNickname());
        cliente.setNombreApellidos(c.getNombreApellidos());
        cliente.setAltura(c.getAltura());
        cliente.setPeso(c.getPeso());
        cliente.setFotoPerfil(c.getFotoPerfil());
        return cliente;
    }

    /**
     * Instancia un nuevo cliente.
     */
    public Cliente() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">

    /**
     *
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @return
     */
    public String getNombreApellidos() {
        return nombreApellidos;
    }

    /**
     *
     * @return
     */
    public float getAltura() {
        return altura;
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
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @param nombreApellidos
     */
    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    /**
     *
     * @param altura
     */
    public void setAltura(float altura) {
        this.altura = altura;
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
     * @param fotoPerfil
     */
    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    //</editor-fold>

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cliente{"
                + "idCliente=" + idCliente
                + ", nickname=" + nickname
                + ", nombreApellidos=" + nombreApellidos
                + ", altura=" + altura
                + ", peso=" + peso
                + ", fotoPerfil=" + fotoPerfil
                + '}';
    }

}
