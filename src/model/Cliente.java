package model;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public static Cliente fromResultSet(ResultSet rs) throws SQLException{
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("id_cliente"));
        cliente.setNickname(rs.getString("nickname"));
        cliente.setNombreApellidos(rs.getString("nombre_apellidos"));
        cliente.setAltura(rs.getFloat("altura"));
        cliente.setPeso(rs.getFloat("peso"));
        cliente.setFotoPerfil(rs.getString("foto_perfil"));
        return cliente;
    }
    
    public Cliente() {
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public int getIdCliente() {
        return idCliente;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    //</editor-fold>

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
