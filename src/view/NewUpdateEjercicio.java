package view;

import controller.data.EjercicioController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import controller.exception.FTPControllerException;
import controller.ftp.FTPController;
import controller.ftp.ImagePickerController;
import controller.validation.NotNullText;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Ejercicio;

public class NewUpdateEjercicio extends javax.swing.JDialog {

    private static NewUpdateEjercicio instance;

    private Principal principal;
    private Ejercicio ejercicio;

    /**
     * Recupera la instancia del JDialog.
     * <br>
     * Inicializa las validaciones. En cada llamada, actualiza el objeto que
     * gestiona y refresca los campos.
     *
     * @param parent
     * @param ejercicio
     * @return
     */
    public static NewUpdateEjercicio getInstance(Principal parent, Ejercicio ejercicio) {
        if (instance == null) {
            instance = new NewUpdateEjercicio(parent, true);
            instance.addInputVerifiers();
            instance.addDocumentListeners();
        }
        instance.principal = parent;
        instance.ejercicio = ejercicio;
        instance.prepareFields();

        return instance;
    }

    private NewUpdateEjercicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlEjercicioDetails = new javax.swing.JPanel();
        lblEjercicioTipo = new javax.swing.JLabel();
        txtEjercicioTipo = new javax.swing.JTextField();
        lblEjercicioId = new javax.swing.JLabel();
        txtEjercicioId = new javax.swing.JTextField();
        lblEjercicioInstrucciones = new javax.swing.JLabel();
        txtEjercicioInstrucciones = new javax.swing.JTextField();
        lblEjercicioRecord = new javax.swing.JLabel();
        txtEjercicioRecord = new javax.swing.JTextField();
        lblEjercicioPromedio = new javax.swing.JLabel();
        txtEjercicioPromedio = new javax.swing.JTextField();
        pnlEjercicioFoto = new javax.swing.JPanel();
        lblEjercicioFoto = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlEjercicioDetails.setLayout(new java.awt.GridBagLayout());

        lblEjercicioTipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEjercicioTipo.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(lblEjercicioTipo, gridBagConstraints);

        txtEjercicioTipo.setBackground(new java.awt.Color(255, 255, 255));
        txtEjercicioTipo.setText("Tipo");
        txtEjercicioTipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 203;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(txtEjercicioTipo, gridBagConstraints);

        lblEjercicioId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEjercicioId.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(lblEjercicioId, gridBagConstraints);

        txtEjercicioId.setEditable(false);
        txtEjercicioId.setBackground(new java.awt.Color(255, 255, 255));
        txtEjercicioId.setText("ID");
        txtEjercicioId.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(txtEjercicioId, gridBagConstraints);

        lblEjercicioInstrucciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEjercicioInstrucciones.setText("Instrucciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(lblEjercicioInstrucciones, gridBagConstraints);

        txtEjercicioInstrucciones.setBackground(new java.awt.Color(255, 255, 255));
        txtEjercicioInstrucciones.setText("Instrucciones");
        txtEjercicioInstrucciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 231;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(txtEjercicioInstrucciones, gridBagConstraints);

        lblEjercicioRecord.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEjercicioRecord.setText("Record");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(lblEjercicioRecord, gridBagConstraints);

        txtEjercicioRecord.setEditable(false);
        txtEjercicioRecord.setBackground(new java.awt.Color(255, 255, 255));
        txtEjercicioRecord.setText("Record");
        txtEjercicioRecord.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(txtEjercicioRecord, gridBagConstraints);

        lblEjercicioPromedio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEjercicioPromedio.setText("Promedio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(lblEjercicioPromedio, gridBagConstraints);

        txtEjercicioPromedio.setEditable(false);
        txtEjercicioPromedio.setBackground(new java.awt.Color(255, 255, 255));
        txtEjercicioPromedio.setText("Promedio");
        txtEjercicioPromedio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 188;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(txtEjercicioPromedio, gridBagConstraints);

        pnlEjercicioFoto.setLayout(new java.awt.BorderLayout());

        lblEjercicioFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEjercicioFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/exercise.png"))); // NOI18N
        lblEjercicioFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlEjercicioFoto.add(lblEjercicioFoto, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(pnlEjercicioFoto, gridBagConstraints);

        btnCancel.setText("Cancelar");
        btnCancel.setMaximumSize(new java.awt.Dimension(100, 25));
        btnCancel.setMinimumSize(new java.awt.Dimension(100, 25));
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 25));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(btnCancel, gridBagConstraints);

        btnSave.setText("Guardar");
        btnSave.setMaximumSize(new java.awt.Dimension(100, 25));
        btnSave.setMinimumSize(new java.awt.Dimension(100, 25));
        btnSave.setPreferredSize(new java.awt.Dimension(100, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(btnSave, gridBagConstraints);

        btnFoto.setText("Cambiar Foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(btnFoto, gridBagConstraints);

        getContentPane().add(pnlEjercicioDetails, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(700, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        principal.runTask(insertUpdateTask());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        principal.runTask(imageUploadTask());
    }//GEN-LAST:event_btnFotoActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Variables de UI">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblEjercicioFoto;
    private javax.swing.JLabel lblEjercicioId;
    private javax.swing.JLabel lblEjercicioInstrucciones;
    private javax.swing.JLabel lblEjercicioPromedio;
    private javax.swing.JLabel lblEjercicioRecord;
    private javax.swing.JLabel lblEjercicioTipo;
    private javax.swing.JPanel pnlEjercicioDetails;
    private javax.swing.JPanel pnlEjercicioFoto;
    private javax.swing.JTextField txtEjercicioId;
    private javax.swing.JTextField txtEjercicioInstrucciones;
    private javax.swing.JTextField txtEjercicioPromedio;
    private javax.swing.JTextField txtEjercicioRecord;
    private javax.swing.JTextField txtEjercicioTipo;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    /*-------------------------------------------------------------------------
     * Tareas.
     * Accesos a la base de datos y al FTP.
     */
    /**
     * Realiza la operación de inserción o actualización.
     *
     * @return
     */
    private Runnable insertUpdateTask() {
        return () -> {
            try {
                //Deshabilitamos los botones hasta que termine la operación.
                actionButtonsEnabledState(false);
                StringBuilder operationType = new StringBuilder();
                EjercicioController ec = EjercicioController.getInstance();
                //Distinguimos si es un objeto nuevo o existente.
                if (ejercicio.getIdEjercicio() == 0) {
                    operationType.append("Insertar: ");
                    ec.addEjercicio(ejercicio);
                } else {
                    operationType.append("Actualizar: ");
                    ec.updateEjercicio(ejercicio);
                }
                //Recogemos el estado.
                operationType.append(ejercicio.getIdEjercicio())
                        .append(" - ")
                        .append(ejercicio.getTipo())
                        .append("\n\nEstado: Realizado correctamente.");
                //Rehabilitamos botones.
                actionButtonsEnabledState(true);
                principal.runTask(principal.loadJListTask("ejercicio"));
                JOptionPane.showMessageDialog(rootPane, operationType.toString());
                dispose();
            } catch (EntityControllersException | ConfigurationControllerException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                actionButtonsEnabledState(true);
            }

        };
    }

    /**
     * Sube imagen al FTP y actualiza la información del ejercicio.
     *
     * @return
     */
    private Runnable imageUploadTask() {
        return () -> {
            JFileChooser chooser = ImagePickerController.pickImage();
            int result = chooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File chosenFile = chooser.getSelectedFile();
                    FTPController ftp = FTPController.getInstance();
                    String uploadedImageName = ftp.uploadImage("ejercicios", chosenFile, chosenFile.getName());
                    ejercicio.setFotoEjercicio(uploadedImageName);

                } catch (FTPControllerException | ConfigurationControllerException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
        };
    }

    /*-------------------------------------------------------------------------
     * Sección de UI.
     * Actualización de campos, estados y validación de datos.
     */
    /**
     * Llena los campos con la información recibida.
     */
    private void prepareFields() {
        txtEjercicioId.setText(ejercicio.getIdEjercicio() + "");
        txtEjercicioTipo.setText(ejercicio.getTipo() == null ? "" : ejercicio.getTipo());
        txtEjercicioInstrucciones.setText(ejercicio.getInstrucciones() == null ? "" : ejercicio.getInstrucciones());
        txtEjercicioRecord.setText(ejercicio.getRecord() + "");
        txtEjercicioPromedio.setText(ejercicio.getPromedio() + "");
        lblEjercicioFoto.setIcon(principal.sendIcon(ejercicio));
    }

    /**
     * Validación de datos. En el caso de esta entidad, éste es más que
     * suficiente.
     * <br>
     * Extraido a clase para reutilizar en Cliente.
     */
    private void addInputVerifiers() {
        txtEjercicioTipo.setInputVerifier(new NotNullText(lblEjercicioTipo.getText(), btnSave));
    }

    //<editor-fold defaultstate="collapsed" desc="Document Listeners para manejar los cambios en el texto. Mucho código.">
    private void addDocumentListeners() {
        txtEjercicioTipo.getDocument()
                .addDocumentListener(
                        new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        applyChange();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        applyChange();
                    }

                    /**
                     * Solo gestiona cambios en el estilo.
                     */
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        //Ignoramos.
                    }

                    private void applyChange() {
                        String text = txtEjercicioTipo.getText();
                        ejercicio.setTipo(text);
                    }
                }
                );
        txtEjercicioInstrucciones.getDocument()
                .addDocumentListener(
                        new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        applyChange();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        applyChange();
                    }

                    /**
                     * Solo gestiona cambios en el estilo.
                     */
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        //Ignoramos.
                    }

                    private void applyChange() {
                        String text = txtEjercicioInstrucciones.getText();
                        ejercicio.setInstrucciones(text);
                    }
                }
                );
    }
    //</editor-fold>

    private void actionButtonsEnabledState(boolean b) {
        btnCancel.setEnabled(b);
        btnSave.setEnabled(b);
    }

}
