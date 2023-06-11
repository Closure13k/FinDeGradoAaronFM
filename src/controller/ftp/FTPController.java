package controller.ftp;


import controller.config.ConfigurationController;
import controller.exception.FTPControllerException;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FTPController {

    //************************************************************
    //TODO: Remove plain text properties in production.
    //************************************************************
    private static final String FTP_WIFI = "192.168.0.28";
    private static final String FTP_MOVIL = "192.168.235.131";

    public static final int PORT = 21;

    public static final String USER = "clienteftp";

    public static final String PASSWORD = "Abcd1234..";

    /**
     * Instancia única de FTPController (patrón Singleton).
     */
    private static FTPController instance;
    private ConfigurationController configurationController;
    /**
     * Cliente FTP.
     */
    private FTPClient ftp;

    /**
     * Devuelve la instancia única de FTPController.
     *
     * @return La instancia única de FTPController.
     */
    public static FTPController getInstance() throws FTPControllerException {
        if (instance == null) {
            instance = new FTPController();
        }
        return instance;
    }

    /**
     * Inicia sesión en el servidor FTP.
     *
     * @throws FTPControllerException Si ocurre un error al iniciar sesión.
     */
    private FTPController() throws FTPControllerException {
        ftp = new FTPClient();
        try {
            connect();
        } catch (FTPControllerException e) {
            throw new FTPControllerException("Error al instanciar FTPController: " + e.getMessage());
        }
    }

    /**
     * Comprueba que sigue conectado al servidor FTP.
     * Si no lo está, refresca la conexión.
     */
    public FTPController refreshConnection() throws FTPControllerException {
        if (!isConnected()) {
            connect();
        }
        return this;
    }


    /**
     * Inicia sesión en el servidor FTP.
     *
     * @throws FTPControllerException Si ocurre un error al iniciar sesión.
     */
    private void connect() throws FTPControllerException {
        try {
            ftp.connect(FTP_MOVIL, PORT);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.login(USER, PASSWORD);
        } catch (IOException e) {
            throw new FTPControllerException(e.getMessage());
        }
    }

    /**
     * Compueba si el cliente está conectado al servidor FTP.
     *
     * @return true si el cliente está conectado al servidor FTP, false en caso contrario.
     */
    private boolean isConnected() {
        return ftp.isConnected();
    }

    /**
     * Cierra la conexión con el servidor FTP.
     *
     * @throws FTPControllerException Si ocurre un error al cerrar la conexión.
     */
    public void disconnect() throws FTPControllerException {
        try {
            ftp.disconnect();
            instance = null;
        } catch (IOException e) {
            throw new FTPControllerException(e.getMessage());
        }
    }

    public String uploadImage(String ftpFolder, File imageFile, String imageName) throws FTPControllerException {
        if (!imageFile.exists()) {
            throw new FTPControllerException("La imagen no existe.");
        }
        try (var inputStream = new FileInputStream(imageFile)) {
            if(!ftp.changeWorkingDirectory(ftpFolder)){
                ftp.mkd(ftpFolder);
                ftp.changeWorkingDirectory(ftpFolder);
            }
            if (!ftp.storeFile(imageName, inputStream)) {
                throw new FTPControllerException("No se pudo subir la imagen.");
            }
            return String.join("/", ftpFolder, imageName);
        } catch (IOException e) {
            throw new FTPControllerException(e.getMessage());
        }
    }

    public File downloadImage(String ftpFolder, String imageName) throws FTPControllerException {
        try {
            if(!ftp.changeWorkingDirectory(ftpFolder)){
                throw new FTPControllerException("No se pudo acceder a la carpeta.");
            }
            File imageFile = new File(imageName);
            if (!ftp.retrieveFile(imageName, new FileOutputStream(imageFile))) {
                throw new FTPControllerException("No se pudo descargar la imagen.");
            }
            return imageFile;
        } catch (IOException e) {
            throw new FTPControllerException(e.getMessage());
        }
    }


}
