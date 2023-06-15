package controller.renderer;

import java.awt.Component;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.Cliente;
import model.ClienteEjercicio;
import model.Ejercicio;
/**
 * Renderiza de forma personalizada los campos de lista/combo.
 * @author AaronFM
 */
public class CustomListRenderers extends JLabel implements ListCellRenderer<Object> {
    
    /**
     *
     */
    public static final CustomListRenderers INSTANCE = new CustomListRenderers();

    /**
     *
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {

        String data = value.toString();

        if (value instanceof Cliente c) {
            data = c.getNickname() + " (" + c.getNombreApellidos() + ")";
        }

        if (value instanceof Ejercicio e) {
            data = e.getTipo();
        }

        if (value instanceof ClienteEjercicio ce) {

            data = ce.getCliente().getNickname() + " - " + ce.getEjercicio().getTipo() + " @ " + ce.getFecha() + " ("
                    + ce.getPeso() + "kg x" + ce.getSeries() + ")";
        }
        setText(data);
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        return this;

    }

}
