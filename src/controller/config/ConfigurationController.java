package controller.config;

import config.ProjectStateConfiguration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

}
