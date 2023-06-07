package model.entity;

import java.util.Arrays;

/**
 * Información de la tabla Clientes.
 * Guarda los nombres de los campos de la tabla en constantes para evitar errores de escritura.
 *
 * @author AaronFM
 * @see model.Cliente
 */
public class ClienteEntity {
    private static final String TABLE_NAME = "clientes";
    private static final String ID_FIELD = "id_cliente";
    public static final String[] FIELDS = {
            "nickname",
            "foto_perfil",
            "nombre_apellidos",
            "altura",
            "peso"
    };

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
        return "INSERT INTO " + TABLE_NAME
                + " (" + String.join(", ", FIELDS) + ")"
                + " VALUES (?, ?, ?, ?, ?)";
    }

    /**
     * Devuelve la orden de borrado de un cliente de la base de datos.
     * <br>El número de parámetros para el prepared statement es 1 (id_cliente: int).
     *
     * @return La consulta de borrado.
     */
    public static String deleteQuery() {
        return "DELETE FROM " + TABLE_NAME
                + " WHERE " + ID_FIELD + " = ?";
    }

    /**
     * Orden de actualización de un cliente en la base de datos.
     * <br>Los campos y sus tipos de datos son:
     * @see #insertQuery()
     * <br> Además, guarda una referencia al id_cliente (int) para el prepared statement.
     */
    public static String updateQuery() {
        return "UPDATE " + TABLE_NAME
                + " SET " + String.join(" = ?, ", Arrays.copyOfRange(FIELDS, 0, FIELDS.length - 1)) + " = ?"
                + " WHERE " + ID_FIELD + " = ?";
    }

    /**
     * Devuelve la consulta para seleccionar todos los clientes de la base de datos.
     * <br>Los campos y sus tipos de datos son:
     * @see #insertQuery()
     */
    public static String selectQuery() {
        return "SELECT "+ID_FIELD+", "+String.join(", ", FIELDS)
                + " FROM " + TABLE_NAME;
    }

    /**
     * Devuelve el where para seleccionar un cliente por su id.
     */
    public static String whereId() {
        return " WHERE " + ID_FIELD + " = ?";
    }
}
