package controller.ftp;

import controller.config.ConfigurationController;
import controller.exception.ConfigurationControllerException;
import controller.exception.FTPControllerException;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

public class FTPController {
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
    public static FTPController getInstance() throws FTPControllerException, ConfigurationControllerException {
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
    private FTPController() throws FTPControllerException, ConfigurationControllerException {
        try {
            configurationController = ConfigurationController.getInstance();
            ftp = new FTPClient();
            connect();
        } catch (FTPControllerException e) {
            throw new FTPControllerException("Error al instanciar FTPController: " + e.getMessage());
        }
    }

    /**
     * Comprueba que sigue conectado al servidor FTP. Si no lo está, refresca la
     * conexión.
     */
    public FTPController refreshConnection() throws FTPControllerException, ConfigurationControllerException {
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
    private void connect() throws FTPControllerException, ConfigurationControllerException {
        try {
            ftp.connect(configurationController.getFtpIP(), configurationController.getFtpPort());
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.login(configurationController.getFtpUser(), configurationController.getFtpPassword());
        } catch (IOException e) {
            throw new FTPControllerException(e.getMessage());
        }
    }

    /**
     * Compueba si el cliente está conectado al servidor FTP.
     *
     * @return true si el cliente está conectado al servidor FTP, false en caso
     * contrario.
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
            if (!ftp.changeWorkingDirectory(ftpFolder)) {
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

    public InputStream downloadImage(String ftpFolder, String imageName) throws FTPControllerException {
        try {
            System.out.println(ftpFolder + ": " + imageName);
            System.out.println(ftp.printWorkingDirectory());
            if (!ftp.printWorkingDirectory().equals("/" + ftpFolder)) {
                if (!ftp.changeWorkingDirectory(ftpFolder)) {
                    throw new FTPControllerException("No se pudo acceder a la carpeta.");
                }
            }

            InputStream fileStream = ftp.retrieveFileStream(imageName);
            if (fileStream == null) {
                throw new FTPControllerException("No se pudo descargar la imagen.");
            }
            return fileStream;
        } catch (IOException e) {
            throw new FTPControllerException(e.getMessage());
        }
    }

}
