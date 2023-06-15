package controller.ftp;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrador
 */
public class ImagePickerController {
    /**
     * Lanza el imagePicker para su uso.
     * @return 
     */
    public static JFileChooser pickImage() {
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.setFileFilter(
                new FileNameExtensionFilter("Archivos de imagen.", "jpg", "png")
        );
        return jfc;
    }
}
