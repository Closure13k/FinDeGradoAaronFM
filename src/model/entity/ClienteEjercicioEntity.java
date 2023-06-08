package model.entity;

/**
 * Información de la tabla Ejercicios. Guarda los nombres de los campos de la
 * tabla en constantes para evitar errores de escritura.
 *
 * @author AaronFM
 * @see model.ClienteEjercicio
 */
public class ClienteEjercicioEntity {
    /**
     * Nombre de la tabla.
     */
    public static final String CLIENTE_EJERCICIO = "cliente_ejercicio";
    /**
     * Nombre de los campos de la tabla.
     */
    public static final String ID_CLIENTE = "id_cliente";

    public static final String ID_EJERCICIO = "id_ejercicio";

    public static final String FECHA = "fecha";

    public static final String SERIES = "series";

    public static final String PESO = "peso";

    public static final String COMENTARIO = "comentario";


    /**
     * Devuelve la orden de inserción de ClienteEjercicio.
     * <br>
     * Los campos y sus tipos de datos son:
     * <ul>
     * <li>id_cliente: int</li>
     * <li>id_ejercicio: int</li>
     * <li>fecha: Date</li>
     * <li>series: int</li>
     * <li>peso: float</li>
     * <li>comentario: String</li>
     * </ul>
     * El número de parámetros para el prepared es 6.
     *
     * @return consulta de inserción.
     */
    public static String insertQuery() {
        return "INSERT INTO " + CLIENTE_EJERCICIO
                + " ("+ ID_CLIENTE
                + ", " + ID_EJERCICIO
                + ", " + FECHA
                + ", " + SERIES
                + ", " + PESO
                + ", " + COMENTARIO
                + ") VALUES (?, ?, ?, ?, ?, ?)";
    }

    /**
     * Orden de borrado de un cliente_ejercicio.
     * <br>
     * El número de parámetros:
     * <ul>
     * <li>id_cliente: int</li>
     * <li>id_ejercicio: int</li>
     * <li>fecha: date</li>
     * </ul>
     * El número de parámetros para el prepared es 3.
     *
     * @return La consulta de borrado.
     */
    public static String deleteQuery() {
        return "DELETE FROM " + CLIENTE_EJERCICIO
                + " WHERE " + ID_CLIENTE + " = ?"
                + " AND " + ID_EJERCICIO + " = ?"
                + " AND " + FECHA + " = ?";

    }

    /**
     * Orden de actualización de un cliente_ejercicio.
     * <br>
     * Los campos y sus tipos de datos son:
     * <ul>
     * <li>series: int</li>
     * <li>peso: float</li>
     * <li>comentario: String</li>
     * </ul>
     * <br>
     * Los campos de la cláusula WHERE son:
     * <ul>
     * <li>id_cliente: int</li>
     * <li>id_ejercicio: int</li>
     * <li>fecha: date</li>
     * </ul>
     * <br>
     * El número de <b>parámetros para el prepared es 6</b>.
     * @return
     */
    public static String updateQuery() {
        return "UPDATE " + CLIENTE_EJERCICIO
                + " SET " + SERIES + " = ?"
                + ", " + PESO + " = ?"
                + ", " + COMENTARIO + " = ?"
                + " WHERE " + ID_CLIENTE + " = ?"
                + " AND " + ID_EJERCICIO + " = ?"
                + " AND " + FECHA + " = ?";
    }

    /**
     * Orden de selección de todos los ejercicios.
     * <br>
     * Los campos seleccionados son:
     * <ul>
     * <li>id_cliente: int</li>
     * <li>nickname: String</li>
     * <li>id_ejercicio: int</li>
     * <li>tipo: String</li>
     * <li>fecha: date</li>
     * <li>series: int</li>
     * <li>peso: float</li>
     * <li>comentario: String</li>
     * </ul>
     * @return
     */
    public static String selectQuery() {
        return "SELECT " + ID_CLIENTE
                + ", " + ClienteEntity.NICKNAME
                + ", " + ID_EJERCICIO
                + ", " + EjercicioEntity.TIPO
                + ", " + FECHA
                + ", " + SERIES
                + ", " + PESO
                + ", " + COMENTARIO
                + " FROM " + CLIENTE_EJERCICIO
                + " INNER JOIN " + ClienteEntity.CLIENTES
                + " USING (" + ID_CLIENTE + ")"
                + " INNER JOIN " + EjercicioEntity.EJERCICIOS
                + " USING (" + ID_EJERCICIO + ")";
    }

}
