/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 * Información de la tabla Ejercicios. Guarda los nombres de los campos de la
 * tabla en constantes para evitar errores de escritura.
 *
 * @author AaronFM
 * @see model.Ejercicio
 */
public class EjercicioEntity {

    public static final String EJERCICIOS = "ejercicios";

    public static final String ID_EJERCICIO = "id_ejercicio";

    public static final String TIPO = "tipo";

    public static final String FOTO = "foto_ejercicio";

    public static final String INSTRUCCIONES = "instrucciones";

    public static final String RECORD = "record";

    public static final String PROMEDIO = "promedio";


    /**
     * Devuelve la consulta para insertar un ejercicio en la base de datos.
     * <br>
     * Los campos y sus tipos de datos son:
     * <ul>
     * <li>tipo: String</li>
     * <li>foto_ejercicio: String</li>
     * <li>instrucciones: String</li>
     * </ul>
     * El número de parámetros para el prepared statement es 3.
     *
     * @return La consulta de inserción.
     */
    public static String insertQuery() {
        return "INSERT INTO " + EJERCICIOS
                + " (" + TIPO
                + ", " + FOTO
                + ", " + INSTRUCCIONES
                + ") VALUES (?, ?, ?)";
    }

    /**
     * Devuelve la orden de borrado de un ejercicio de la base de datos.
     * <br>El número de parámetros:
     * <ul><li>1 (id_ejercicio: int).</li></ul>
     *
     * @return La consulta de borrado.
     */
    public static String deleteQuery() {
        return "DELETE FROM " + EJERCICIOS
                + " WHERE " + ID_EJERCICIO + " = ?";
    }

    /**
     * Orden de actualización de un ejercicio en la base de datos.
     * <br>Los campos y sus tipos de datos son:
     * <ul>
     * <li>tipo: String</li>
     * <li>foto: String</li>
     * <li>instrucciones: String</li>
     * </ul>
     * <br> Promedio y record se actualizan al recibir entradas en la N:M.
     * <br> Además, recoge una referencia al id_ejercicio (int) para el where.
     * <br> Número de campos para prepared: 4.
     * @return La consulta de actualización.
     */
    public static String updateQuery() {
        return "UPDATE " + EJERCICIOS
                + " SET " + TIPO + " = ?"
                + ", " + FOTO + " = ?"
                + ", " + INSTRUCCIONES + " = ?"
                + " WHERE " + ID_EJERCICIO + " = ?";
    }

    /**
     * Devuelve la consulta para seleccionar todos los ejercicios de la base de
     * datos.
     * <br>Los campos y datos devueltos son:
     * <ul><li>id_ejercicio: int</li>
     *
     * @see #insertQuery()
     */
    public static String selectQuery() {
        return "SELECT " + ID_EJERCICIO
                + " ," + TIPO
                + " ," + FOTO
                + " ," + INSTRUCCIONES
                + " ," + RECORD
                + " ," + PROMEDIO
                + " FROM " + EJERCICIOS;
    }


}
