package controller.validation;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Administrador
 */
public class NumericInputVerifier extends InputVerifier {

    private static final String NUMBERS_ONLY = "Sólo se permiten valores numéricos.\n(p.ej. 1, 3.23)";
    private static final String POSITIVES = "Sólo números mayores a cero";

    private final boolean isFloat;
    private final int maxLength;
    private final String label;
    private final JButton[] buttons;

    public NumericInputVerifier(boolean isFloat, int maxLength, String label, JButton... buttons) {
        this.isFloat = isFloat;
        this.maxLength = maxLength;
        this.label = label;
        this.buttons = buttons;
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField textTipo = (JTextField) input;
        final String text = textTipo.getText().trim();
        boolean flag = true;
        try {
            if (isFloat) {
                float f = Float.parseFloat(text);
                if (!(f > 0)) {
                    JOptionPane.showMessageDialog(null, label + ": " + POSITIVES);
                    flag = false;
                }

            } else {
                int i = Integer.parseInt(text);
                if (!(i > 0 && i <= maxLength)) {
                    JOptionPane.showMessageDialog(null, label + ": " + POSITIVES + " y menores a " + maxLength);
                    flag = false;
                }

            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, label + ": " + NUMBERS_ONLY);
            flag = false;
        }

        for (JButton button : buttons) {
            button.setEnabled(flag);
        }
        return flag;
    }

}
