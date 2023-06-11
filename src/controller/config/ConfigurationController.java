package controller.config;

import config.ProjectStateConfiguration;
import controller.exception.ConfigurationControllerException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Properties;
import javax.naming.ConfigurationException;
import javax.swing.JOptionPane;

import static controller.exception.ConfigurationControllerException.*;

public class ConfigurationController {

    /**
     * Rutas como constantes.
     */
    private static final String DEV_PROPERTIES_LOCATION = "/config/appconfiguration.properties";
    private static final String PRODUCTION_LOCATION = "./appconfiguration.properties";
    /**
     * Instancia del controlador.
     */
    private static ConfigurationController instance;

    private Properties properties;

    /**
     * Inicializo de forma pasiva.
     *
     * @return el controlador, si la carga ocurre correctamente.
     */
    public static ConfigurationController getInstance() {
        if (instance == null) {
            instance = new ConfigurationController();
        }
        return instance;
    }

    /**
     * Carga del archivo de configuración.
     * <br>
     * Se comprueba en qué etapa de desarrollo nos encontramos. Se carga
     * conforme a la etapa.
     * <br>
     * En caso de no hallar un archivo durante la etapa de producción, se carga
     * el archivo de desarrollo como una plantilla para generar un .properties
     * en producción.
     */
    private ConfigurationController() {
        properties = new Properties();
        InputStream stream;
        if (ProjectStateConfiguration.IS_PRODUCTION_STATE) {
            try {
                stream = new FileInputStream(PRODUCTION_LOCATION);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Archivo appconfiguration.properties no encontrado.\nSe generará un archivo nuevo.");
                stream = this.getClass().getResourceAsStream(DEV_PROPERTIES_LOCATION);
            }
        } else {
            stream = this.getClass().getResourceAsStream(DEV_PROPERTIES_LOCATION);
        }
        try {
            properties.load(stream);
            stream.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error cargando el archivo appconfiguration.properties.\nCerrando el programa.");
            System.exit(1);
        }
    }

    /**
     * Guarda la configuración aplicada en producción.
     */
    public void storeAppConfiguration() {
        if (properties != null) {
            if (ProjectStateConfiguration.IS_PRODUCTION_STATE) {
                try (OutputStream stream = Files.newOutputStream(Path.of(PRODUCTION_LOCATION))) {
                    properties.store(stream, "Last updated: " + new Date());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error guardando el archivo appconfiguration.properties.");
                    System.exit(1);
                }
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters para properties.">
    //Lista de propiedades. Getters.
    public String getDatabaseIP() throws ConfigurationControllerException {
        String ip = properties.getProperty("db.ip");
        if (ip == null || ip.isBlank()) {
            throw new ConfigurationControllerException(MISSING + DB_IP);
        }
        return ip;
    }

    public String getDatabasePort() throws ConfigurationControllerException {
        String port = properties.getProperty("db.port");
        if (port == null || port.isBlank()) {
            throw new ConfigurationControllerException(MISSING + DB_PORT);
        }
        return port;
    }

    public String getDatabaseUser() throws ConfigurationControllerException {
        String user = properties.getProperty("db.user");
        if (user == null || user.isBlank()) {
            throw new ConfigurationControllerException(MISSING + DB_USER);
        }
        return user;
    }

    public String getDatabasePassword() throws ConfigurationControllerException {
        String password = properties.getProperty("db.password");
        if (password == null || password.isBlank()) {
            throw new ConfigurationControllerException(MISSING + DB_PASSWORD);
        }
        return password;
    }

    public String getFtpIP() throws ConfigurationControllerException {
        String ip = properties.getProperty("ftp.ip");
        if (ip == null || ip.isBlank()) {
            throw new ConfigurationControllerException(MISSING + FTP_IP);
        }
        return ip;
    }

    public int getFtpPort() throws ConfigurationControllerException {
        String port = properties.getProperty("ftp.port");
        if (port == null || port.isBlank()) {
            throw new ConfigurationControllerException(MISSING + FTP_PORT);
        }
        try {
            return Integer.parseInt(port);
        } catch (NumberFormatException ex) {
            throw new ConfigurationControllerException("Valor no numérico en: " + FTP_PORT);
        }
    }

    public String getFtpUser() throws ConfigurationControllerException {
        String user = properties.getProperty("ftp.user");
        if (user == null || user.isBlank()) {
            throw new ConfigurationControllerException(MISSING + FTP_USER);
        }
        return user;
    }

    public String getFtpPassword() throws ConfigurationControllerException {
        String password = properties.getProperty("ftp.password");
        if (password == null || password.isBlank()) {
            throw new ConfigurationControllerException(MISSING + FTP_PASSWORD);
        }
        return password;
    }

    /**
     * Lista de propiedades. Setters.
     */
    public void setDatabaseIP(String ip) {
        properties.setProperty("db.ip", ip);
    }

    public void setDatabasePort(String port) {
        properties.setProperty("db.port", port);
    }

    public void setDatabaseUser(String user) {
        properties.setProperty("db.user", user);
    }

    public void setDatabasePassword(String password) {
        properties.setProperty("db.password", password);
    }

    public void setFtpIP(String ip) {
        properties.setProperty("ftp.ip", ip);
    }

    public void setFtpPort(String port) {
        properties.setProperty("ftp.port", port);
    }

    public void setFtpUser(String user) {
        properties.setProperty("ftp.user", user);
    }

    public void setFtpPassword(String password) {
        properties.setProperty("ftp.password", password);
    }
//</editor-fold>
}
