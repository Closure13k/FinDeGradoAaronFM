package controller.ftp;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImagePickerController {

    public static JFileChooser pickImage() {
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.addChoosableFileFilter(
                new FileNameExtensionFilter("Archivos de imagen.", "jpg", "png")
        );
        return jfc;
    }
}
