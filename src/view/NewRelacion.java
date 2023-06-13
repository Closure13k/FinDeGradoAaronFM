package view;

import controller.data.ClienteController;
import controller.data.ClienteEjercicioController;
import controller.data.EjercicioController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import controller.renderer.CustomListRenderers;
import controller.validation.NumericInputVerifier;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Cliente;
import model.ClienteEjercicio;
import model.Ejercicio;

public class NewRelacion extends javax.swing.JDialog {

    private static NewRelacion instance;

    private Principal principal;
    private Cliente cliente;
    private Ejercicio ejercicio;
    private ClienteEjercicio clienteEjercicio;

    public static NewRelacion getInstance(Principal p, Cliente c, Ejercicio e) {
        if (instance == null) {
            instance = new NewRelacion(p, true);
            instance.addInputVerifiers();
            instance.addDocumentListeners();
        }
        instance.principal = p;
        instance.cliente = c;
        instance.ejercicio = e;
        instance.clienteEjercicio = new ClienteEjercicio();
        instance.loadCombos();
        instance.prepareFields();

        return instance;
    }

    private NewRelacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cmbCliente.setRenderer(CustomListRenderers.INSTANCE);
        cmbEjercicio.setRenderer(CustomListRenderers.INSTANCE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCombos = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        lblCliente = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        cmbCliente = new javax.swing.JComboBox<>();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(40, 20), new java.awt.Dimension(40, 20), new java.awt.Dimension(40, 20));
        lblEjercicio = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        cmbEjercicio = new javax.swing.JComboBox<>();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        pnlDetallesTodo = new javax.swing.JPanel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        pnlDetalles = new javax.swing.JPanel();
        lblSeries = new javax.swing.JLabel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        txtSeries = new javax.swing.JTextField();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(40, 20), new java.awt.Dimension(40, 20), new java.awt.Dimension(40, 20));
        lblPeso = new javax.swing.JLabel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20), new java.awt.Dimension(20, 20));
        txtPeso = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblComentario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArComentario = new javax.swing.JTextArea();
        pnlButtons = new javax.swing.JPanel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnCancel = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnSave = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlCombos.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        pnlCombos.setLayout(new javax.swing.BoxLayout(pnlCombos, javax.swing.BoxLayout.LINE_AXIS));
        pnlCombos.add(filler5);

        lblCliente.setText("Cliente");
        pnlCombos.add(lblCliente);
        pnlCombos.add(filler1);

        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });
        pnlCombos.add(cmbCliente);
        pnlCombos.add(filler8);

        lblEjercicio.setText("Ejercicio");
        pnlCombos.add(lblEjercicio);
        pnlCombos.add(filler2);

        cmbEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEjercicioActionPerformed(evt);
            }
        });
        pnlCombos.add(cmbEjercicio);
        pnlCombos.add(filler4);

        getContentPane().add(pnlCombos, java.awt.BorderLayout.PAGE_START);

        pnlDetallesTodo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlDetallesTodo.setLayout(new java.awt.BorderLayout());

        dateChooser.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dateChooser.setDateFormatString("dd MMMM yyyy");
        pnlDetallesTodo.add(dateChooser, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnlDetalles.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        pnlDetalles.setLayout(new javax.swing.BoxLayout(pnlDetalles, javax.swing.BoxLayout.LINE_AXIS));

        lblSeries.setText("Series");
        pnlDetalles.add(lblSeries);
        pnlDetalles.add(filler7);
        pnlDetalles.add(txtSeries);
        pnlDetalles.add(filler12);

        lblPeso.setText("Peso");
        pnlDetalles.add(lblPeso);
        pnlDetalles.add(filler9);
        pnlDetalles.add(txtPeso);

        jPanel2.add(pnlDetalles, java.awt.BorderLayout.NORTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setLayout(new java.awt.BorderLayout());

        lblComentario.setText("Comentarios");
        jPanel3.add(lblComentario, java.awt.BorderLayout.PAGE_START);

        txtArComentario.setColumns(20);
        txtArComentario.setRows(5);
        jScrollPane1.setViewportView(txtArComentario);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        pnlDetallesTodo.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlDetallesTodo, java.awt.BorderLayout.CENTER);

        pnlButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 10, 10));
        pnlButtons.setLayout(new javax.swing.BoxLayout(pnlButtons, javax.swing.BoxLayout.LINE_AXIS));
        pnlButtons.add(filler10);

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlButtons.add(btnCancel);
        pnlButtons.add(filler11);

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlButtons.add(btnSave);
        pnlButtons.add(filler6);

        getContentPane().add(pnlButtons, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(622, 337));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Date date = dateChooser.getDate();
        if (date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            clienteEjercicio.setFecha(sqlDate);
            principal.runTask(() -> {
                try {
                    ClienteEjercicioController.getInstance().addClienteEjercicio(clienteEjercicio);
                    JOptionPane.showMessageDialog(rootPane, "Insertado con éxito.");
                    dispose();
                } catch (EntityControllersException | ConfigurationControllerException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            });
        } else {
            JOptionPane.showMessageDialog(rootPane, "Asigna una fecha desplegando el calendario.");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        Object item = cmbCliente.getSelectedItem();
        if (item != null) {
            clienteEjercicio.setCliente((Cliente) item);
        }
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEjercicioActionPerformed
        Object item = cmbEjercicio.getSelectedItem();
        if (item != null) {
            clienteEjercicio.setEjercicio((Ejercicio) item);
        }
    }//GEN-LAST:event_cmbEjercicioActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JComboBox<Ejercicio> cmbEjercicio;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblEjercicio;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblSeries;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCombos;
    private javax.swing.JPanel pnlDetalles;
    private javax.swing.JPanel pnlDetallesTodo;
    private javax.swing.JTextArea txtArComentario;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtSeries;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    /**
     * Carga los combos con los clientes y ejercicios.
     * <br>
     * En base a quien abrió el dialog, se pondrá al cliente o ejercicio pasado
     * como primera opción.
     */
    private void loadCombos() {
        try {
            //Cargamos los combos.
            cmbCliente.removeAllItems();
            List<Cliente> allClientes = ClienteController.getInstance().getAllClientes();
            allClientes.forEach(cmbCliente::addItem);
            cmbEjercicio.removeAllItems();
            List<Ejercicio> allEjercicios = EjercicioController.getInstance().getAllEjercicios();
            allEjercicios.forEach(cmbEjercicio::addItem);

            //Ponemos como primero elegido el parámetro pasado por getInstance()
            if (cliente != null) {
                allClientes.stream()
                        .filter((c) -> cliente.getIdCliente() == c.getIdCliente())
                        .findFirst()
                        .ifPresent(cmbCliente::setSelectedItem);
            }
            if (ejercicio != null) {
                allEjercicios.stream()
                        .filter((e) -> ejercicio.getIdEjercicio() == e.getIdEjercicio())
                        .findFirst()
                        .ifPresent(cmbEjercicio::setSelectedItem);
            }
            clienteEjercicio.setCliente((Cliente) cmbCliente.getSelectedItem());
            clienteEjercicio.setEjercicio((Ejercicio) cmbEjercicio.getSelectedItem());
        } catch (EntityControllersException | ConfigurationControllerException ex) {
            Logger.getLogger(NewRelacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Verifiers para asegurar datos.
     */
    private void addInputVerifiers() {
        txtSeries.setInputVerifier(
                new NumericInputVerifier(false, 255, lblSeries.getText(), btnSave)
        );
        txtPeso.setInputVerifier(
                new NumericInputVerifier(true, 0, lblPeso.getText(), btnSave)
        );
    }

    //<editor-fold defaultstate="collapsed" desc="Document Listeners">
    /**
     * Listeners para actualizar el objeto.
     */
    private void addDocumentListeners() {
        txtPeso.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                applyChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                applyChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //Ignoramos.
            }

            private void applyChange() {
                try {
                    float peso = Float.parseFloat(txtPeso.getText().trim());
                    clienteEjercicio.setPeso(peso);
                } catch (NumberFormatException nfex) {
                    //Ignoramos. Gestionado en la validación.
                }
            }
        });
        txtSeries.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                applyChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                applyChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //Ignoramos.
            }

            private void applyChange() {
                try {
                    int series = Integer.parseInt(txtSeries.getText().trim());
                    clienteEjercicio.setSeries(series);
                } catch (NumberFormatException nfex) {
                    //Ignoramos. Gestionado en la validación.
                }
            }
        });
        txtArComentario.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                applyChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                applyChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //Ignoramos.
            }

            private void applyChange() {
                clienteEjercicio.setComentario(txtArComentario.getText());
            }
        });
    }
    //</editor-fold>

    /**
     * Carga los datos.
     */
    private void prepareFields() {
        txtSeries.setText(clienteEjercicio.getSeries() + "");
        txtPeso.setText(clienteEjercicio.getPeso() + "");
        txtArComentario.setText(clienteEjercicio.getComentario());
        dateChooser.setDate(new Date());
    }
}
