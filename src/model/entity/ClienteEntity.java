package model.entity;

/**
 * Información de la tabla Clientes.
 * Guarda los nombres de los campos de la tabla en constantes para evitar errores de escritura.
 *
 * @author AaronFM
 * @see model.Cliente
 */
public class ClienteEntity {
    public static final String CLIENTES = "clientes";
    public static final String ID_CLIENTE = "id_cliente";

    public static final String NICKNAME = "nickname";
    public static final String FOTO_PERFIL = "foto_perfil";
    public static final String NOMBRE_APELLIDOS = "nombre_apellidos";
    public static final String ALTURA = "altura";
    public static final String PESO_CLIENTE = "peso_cliente";

    /**
     * Devuelve la consulta para insertar un cliente en la base de datos.
     * <br>Los campos y sus tipos de datos son:
     * <ul>
     * <li>nickname: String</li>
     * <li>foto_perfil: String</li>
     * <li>nombre_apellidos: String</li>
     * <li>altura: float</li>
     * <li>peso: float</li>
     * </ul>
     * El número de parámetros para el prepared statement es 5.
     *
     * @return La consulta de inserción.
     */
    public static String insertQuery() {
        return "INSERT INTO " + CLIENTES
                + " (" + NICKNAME
                + ", " + FOTO_PERFIL
                + ", " + NOMBRE_APELLIDOS
                + ", " + ALTURA
                + ", " + PESO_CLIENTE
                + ") VALUES (?, ?, ?, ?, ?)";
    }

    /**
     * Devuelve la orden de borrado de un cliente de la base de datos.
     * <br>El número de parámetros:
     * <ul><li>1 (id_cliente: int).</li></ul>
     *
     * @return La consulta de borrado.
     */
    public static String deleteQuery() {
        return "DELETE FROM " + CLIENTES
                + " WHERE " + ID_CLIENTE + " = ?";
    }

    /**
     * Orden de actualización de un cliente en la base de datos.
     * <br>Los campos y sus tipos de datos son:
     * @see #insertQuery()
     * <br> Además, guarda una referencia al id_cliente (int) para el prepared statement.
     * @return La consulta de actualización.
     */
    public static String updateQuery() {
        return "UPDATE " + CLIENTES
                + " SET " + NICKNAME + " = ?"
                + ", " + FOTO_PERFIL + " = ?"
                + ", " + NOMBRE_APELLIDOS + " = ?"
                + ", " + ALTURA + " = ?"
                + ", " + PESO_CLIENTE + " = ?"
                + " WHERE " + ID_CLIENTE + " = ?";
    }

    /**
     * Devuelve la consulta para seleccionar todos los clientes de la base de datos.
     * <br>Los campos y datos devueltos son:
     * <ul><li>id_cliente: int</li></ul>
     * @see #insertQuery()
     */
    public static String selectQuery() {
        return "SELECT "+ ID_CLIENTE +
                ", " + NICKNAME +
                ", " + FOTO_PERFIL +
                ", " + NOMBRE_APELLIDOS +
                ", " + ALTURA +
                ", " + PESO_CLIENTE
                + " FROM " + CLIENTES;
    }

}
