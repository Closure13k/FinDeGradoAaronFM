/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 * Información de la tabla Ejercicios.
 * Guarda los nombres de los campos de la tabla en constantes para evitar errores de escritura.
 * @author AaronFM
 * @see model.Ejercicio
 */
public class EjercicioEntity {
    private static final String TABLE_NAME = "ejercicios";

    private static final String ID_FIELD = "id_ejercicio";

    public static final String[] FIELDS = {
            "tipo",
            "foto_ejercicio",
            "instrucciones",
            "record",
            "promedio"
    };

    /**
     * Devuelve la consulta para insertar un ejercicio en la base de datos.
     * <br>Los campos y sus tipos de datos son:
     * <ul>
     *     <li>tipo: String</li>
     *     <li>foto_ejercicio: String</li>
     *     <li>instrucciones: String</li>
     *     <li>record: int</li>
     *     <li>promedio: int</li>
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
     * Devuelve la orden de borrado de un ejercicio de la base de datos.
     * <br>El número de parámetros:
     * <ul><li>1 (id_ejercicio: int).</li></ul>
     *
     * @return La consulta de borrado.
     */
    public static String deleteQuery() {
        return "DELETE FROM " + TABLE_NAME
                + " WHERE " + ID_FIELD + " = ?";
    }

    /**
     * Orden de actualización de un ejercicio en la base de datos.
     * <br>Los campos y sus tipos de datos son:
     * @see #insertQuery()
     * <br> Además, guarda una referencia al id_ejercicio (int) para el prepared statement.
     * @return La consulta de actualización.
     */
    public static String updateQuery() {
        return "UPDATE " + TABLE_NAME
                + " SET " + String.join(" = ?, ", FIELDS) + " = ?"
                + " WHERE " + ID_FIELD + " = ?";
    }

    /**
     * Devuelve la consulta para seleccionar todos los ejercicios de la base de datos.
     * <br>Los campos y datos devueltos son:
     * <ul><li>id_ejercicio: int</li>
     * @see #insertQuery()
     */
    public static String selectQuery() {
        return "SELECT " + ID_FIELD + ", " + String.join(", ", FIELDS)
                + " FROM " + TABLE_NAME;
    }

    /**
     * Devuelve el where para seleccionar un ejercicio por su id.
     */
    public static String whereId() {
        return " WHERE " + ID_FIELD + " = ?";
    }

}
