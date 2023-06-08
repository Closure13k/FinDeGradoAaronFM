package model.entity;

/**
 * Información de la tabla Ejercicios. Guarda los nombres de los campos de la
 * tabla en constantes para evitar errores de escritura.
 *
 * @author AaronFM
 * @see model.ClienteEjercicio
 */
public class ClienteEjercicioEntity {
    private static final String TABLE_NAME = "cliente_ejercicio";

    private static final String ID_CLIENTE_FIELD = "id_cliente";

    private static final String ID_EJERCICIO_FIELD = "id_ejercicio";

    private static final String FECHA_FIELD = "fecha";

    public static final String[] FIELDS = {
            "series",
            "peso",
            "comentario"
    };

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
     * El número de parámetros para el prepared es 5.
     *
     * @return consulta de inserción.
     */
    public static String insertQuery() {
        return "INSERT INTO " + TABLE_NAME
                + " (" + ID_CLIENTE_FIELD + ", " + ID_EJERCICIO_FIELD + ", " + FECHA_FIELD + ", " + FIELDS[0] + ", " + FIELDS[1] + ", " + FIELDS[2] + ") "
                + "VALUES (?, ?, ?, ?, ?, ?)";
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
     * @return La consulta de borrado.
     */
    public static String deleteQuery() {
        return "DELETE FROM " + TABLE_NAME
                + " WHERE " + ID_CLIENTE_FIELD + " = ?"
                + " AND " + ID_EJERCICIO_FIELD + " = ?"
                + " AND " + FECHA_FIELD + " = ?";

    }



}
