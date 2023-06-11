package controller.exception;

public class ConfigurationControllerException extends Exception {
    public static final String MISSING = "No se pudo encontrar la propiedad: ";
    public static final String DB_IP = "db.ip: IP de la base de datos.";
    public static final String DB_PORT = "db.port: Puerto de la base de datos.";
    public static final String DB_USER = "db.user: Usuario de la base de datos.";
    public static final String DB_PASSWORD = "db.password: Clave de la base de datos.";
    public static final String FTP_IP = "ftp.ip: IP del servidor FTP.";
    public static final String FTP_PORT = "ftp.port: Puerto del servidor FTP.";
    public static final String FTP_USER = "ftp.user: Usuario del servidor FTP.";
    public static final String FTP_PASSWORD = "ftp.password: Clave del servidor FTP.";


    public ConfigurationControllerException(String message) {
        super(message);
    }

}
