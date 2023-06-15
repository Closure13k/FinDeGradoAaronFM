package controller.validation;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Verificador para campos de texto.
 * @author AaronFM
 */
public class RestrictedLengthVerifier extends InputVerifier {

    private final boolean isNullable;
    private final int maxLength;
    private final String label;
    private final JButton[] buttons;

    /**
     * Prepara el verificador de input.
     *
     * @param nullable si el valor puede ir vacío.
     * @param maxLength el número máximo de caracteres.
     * @param labelText la label para informar al usuario del campo que falla.
     * @param buttons los botones a deshabilitar si el input no es válido.
     */
    public RestrictedLengthVerifier(boolean nullable, int maxLength, String labelText, JButton... buttons) {
        isNullable = nullable;
        this.maxLength = maxLength;
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
        final String text = textTipo.getText().trim();
        boolean textIsBlank = text.isBlank();

        boolean flag = true;

        if (!isNullable && textIsBlank) {
            JOptionPane.showMessageDialog(null, label + " no puede estar en blanco.");
            flag = false;
        }
        if (text.length() > maxLength) {
            JOptionPane.showMessageDialog(null, label + " no puede superar los " + maxLength + " caracteres.");
            flag = false;
        }
        for (JButton button : buttons) {
            button.setEnabled(flag);
        }
        return flag;

    }
}
