package controller.validation;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImageFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        } else {
            return f.getName().toLowerCase().endsWith(".jpg")
                    || f.getName().toLowerCase().endsWith(".jpeg")
                    || f.getName().toLowerCase().endsWith(".png");
        }
    }

    @Override
    public String getDescription() {
        return "Imagenes (.jpg, .jpeg, .png)";
    }
}
