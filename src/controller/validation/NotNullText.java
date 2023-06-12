package controller.validation;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NotNullText extends InputVerifier {

    private final String label;
    private JButton[] buttons;

    public NotNullText(String labelText, JButton... buttons) {
        label = labelText;
        this.buttons = buttons;
    }

    /**
     * Verificación del valor recibido.
     * <br>
     * Este método se activa cuando vamos a salir del campo que se está
     * verificando. En base al booleano, permite cambiar de campo o mantiene el
     * cursor del teclado en el mismo sitio.
     *
     * @param input el componente a leer.
     * @return la validación.
     */
    @Override
    public boolean verify(JComponent input) {
        JTextField textTipo = (JTextField) input;
        boolean textIsBlank = textTipo.getText().trim().isBlank();
        for (JButton button : buttons) {
            button.setEnabled(!textIsBlank);
        }
        if (textIsBlank) {

            JOptionPane.showMessageDialog(null, label + " no puede estar en blanco.");
            return false;
        } else {
            return true;
        }

    }
}
