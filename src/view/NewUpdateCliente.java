/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.data.ClienteController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import controller.exception.FTPControllerException;
import controller.ftp.FTPController;
import controller.ftp.ImagePickerController;
import controller.validation.NumericInputVerifier;
import controller.validation.RestrictedLengthVerifier;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Cliente;

/**
 *
 * @author Administrador
 */
public class NewUpdateCliente extends javax.swing.JDialog {

    private static NewUpdateCliente instance;

    private Principal principal;
    private Cliente cliente;

    /**
     * Recupera la instancia del JDialog.
     * <br>
     * Inicializa las validaciones. En cada llamada, actualiza el objeto que
     * gestiona y refresca los campos.
     *
     * @param parent
     * @param cliente
     * @return
     */
    public static NewUpdateCliente getInstance(Principal parent, Cliente cliente) {
        if (instance == null) {
            instance = new NewUpdateCliente(parent, true);
            instance.addInputVerifiers();
            instance.addDocumentListeners();

        }
        instance.principal = parent;
        instance.cliente = cliente.getIdCliente() == 0 ? cliente : Cliente.forUpdate(cliente);
        instance.prepareFields();

        return instance;
    }

    private NewUpdateCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlClienteDetails = new javax.swing.JPanel();
        lblClienteNickname = new javax.swing.JLabel();
        txtClienteNickname = new javax.swing.JTextField();
        lblClienteId = new javax.swing.JLabel();
        txtClienteId = new javax.swing.JTextField();
        lblClienteNombre = new javax.swing.JLabel();
        txtClienteNombre = new javax.swing.JTextField();
        lblClienteAltura = new javax.swing.JLabel();
        txtClienteAltura = new javax.swing.JTextField();
        lblClientePeso = new javax.swing.JLabel();
        txtClientePeso = new javax.swing.JTextField();
        pnlClienteFoto = new javax.swing.JPanel();
        lblClienteFoto = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnCancel = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnFoto = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnSave = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlClienteDetails.setLayout(new java.awt.GridBagLayout());

        lblClienteNickname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblClienteNickname.setText("Nickname");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(lblClienteNickname, gridBagConstraints);

        txtClienteNickname.setBackground(new java.awt.Color(255, 255, 255));
        txtClienteNickname.setText("Nickname");
        txtClienteNickname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 203;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(txtClienteNickname, gridBagConstraints);

        lblClienteId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblClienteId.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(lblClienteId, gridBagConstraints);

        txtClienteId.setEditable(false);
        txtClienteId.setBackground(new java.awt.Color(255, 255, 255));
        txtClienteId.setText("ID");
        txtClienteId.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(txtClienteId, gridBagConstraints);

        lblClienteNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblClienteNombre.setText("Nombre y apellidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(lblClienteNombre, gridBagConstraints);

        txtClienteNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtClienteNombre.setText("Nombre y apellidos");
        txtClienteNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 231;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(txtClienteNombre, gridBagConstraints);

        lblClienteAltura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblClienteAltura.setText("Altura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(lblClienteAltura, gridBagConstraints);

        txtClienteAltura.setBackground(new java.awt.Color(255, 255, 255));
        txtClienteAltura.setText("Altura");
        txtClienteAltura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(txtClienteAltura, gridBagConstraints);

        lblClientePeso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblClientePeso.setText("Peso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(lblClientePeso, gridBagConstraints);

        txtClientePeso.setBackground(new java.awt.Color(255, 255, 255));
        txtClientePeso.setText("Peso");
        txtClientePeso.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 188;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(txtClientePeso, gridBagConstraints);

        pnlClienteFoto.setLayout(new java.awt.BorderLayout());

        lblClienteFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClienteFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/profile.png"))); // NOI18N
        lblClienteFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlClienteFoto.add(lblClienteFoto, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(pnlClienteFoto, gridBagConstraints);

        getContentPane().add(pnlClienteDetails, java.awt.BorderLayout.CENTER);

        pnlButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlButtons.setLayout(new javax.swing.BoxLayout(pnlButtons, javax.swing.BoxLayout.LINE_AXIS));
        pnlButtons.add(filler1);

        btnCancel.setText("Cancelar");
        btnCancel.setMaximumSize(new java.awt.Dimension(110, 25));
        btnCancel.setMinimumSize(new java.awt.Dimension(110, 25));
        btnCancel.setPreferredSize(new java.awt.Dimension(110, 25));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlButtons.add(btnCancel);
        pnlButtons.add(filler4);

        btnFoto.setText("Cambiar Foto");
        btnFoto.setMaximumSize(new java.awt.Dimension(110, 25));
        btnFoto.setMinimumSize(new java.awt.Dimension(110, 25));
        btnFoto.setPreferredSize(new java.awt.Dimension(110, 25));
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });
        pnlButtons.add(btnFoto);
        pnlButtons.add(filler3);

        btnSave.setText("Guardar");
        btnSave.setMaximumSize(new java.awt.Dimension(110, 25));
        btnSave.setMinimumSize(new java.awt.Dimension(110, 25));
        btnSave.setPreferredSize(new java.awt.Dimension(110, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlButtons.add(btnSave);
        pnlButtons.add(filler2);

        getContentPane().add(pnlButtons, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(703, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        principal.runTask(imageUploadTask());
    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        principal.runTask(insertUpdateTask());
    }//GEN-LAST:event_btnSaveActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Variables de UI">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnSave;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel lblClienteAltura;
    private javax.swing.JLabel lblClienteFoto;
    private javax.swing.JLabel lblClienteId;
    private javax.swing.JLabel lblClienteNickname;
    private javax.swing.JLabel lblClienteNombre;
    private javax.swing.JLabel lblClientePeso;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlClienteDetails;
    private javax.swing.JPanel pnlClienteFoto;
    private javax.swing.JTextField txtClienteAltura;
    private javax.swing.JTextField txtClienteId;
    private javax.swing.JTextField txtClienteNickname;
    private javax.swing.JTextField txtClienteNombre;
    private javax.swing.JTextField txtClientePeso;
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
                ClienteController cc = ClienteController.getInstance();
                //Distinguimos si es un objeto nuevo o existente.
                if (cliente.getIdCliente() == 0) {
                    operationType.append("Insertar: ");
                    cc.addCliente(cliente);
                } else {
                    operationType.append("Actualizar: ");
                    cc.updateCliente(cliente);
                }
                //Recogemos el estado.
                operationType.append(cliente.getIdCliente())
                        .append(" - ")
                        .append(cliente.getNickname())
                        .append("\n\nEstado: Realizado correctamente.");
                //Rehabilitamos botones.
                actionButtonsEnabledState(true);
                principal.runTask(principal.loadJListTask("cliente"));
                
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
                    try {
                        displayImageIcon(chosenFile);
                    } catch (NullPointerException npe) {
                        JOptionPane.showMessageDialog(rootPane, "Error leyendo la imagen.");
                        return;
                    }
                    FTPController ftp = FTPController.getInstance();
                    String uploadedImageName = ftp.uploadImage("clientes", chosenFile, chosenFile.getName());
                    cliente.setFotoPerfil(uploadedImageName);

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
        txtClienteId.setText(cliente.getIdCliente() + "");
        txtClienteNickname.setText(cliente.getNickname());
        txtClienteNombre.setText(cliente.getNombreApellidos());
        txtClienteAltura.setText(cliente.getAltura() + "");
        txtClientePeso.setText(cliente.getPeso() + "");
        if (cliente.getFotoPerfil() != null) {
            lblClienteFoto.setIcon(principal.sendIcon(cliente));
        } else {
            ImageIcon image = new ImageIcon(this.getClass().getResource("/resources/images/profile.png"));
            Image scaledInstance = image.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
            lblClienteFoto.setIcon(new ImageIcon(scaledInstance));
        }
    }

    private void addInputVerifiers() {
        txtClienteNickname.setInputVerifier(
                new RestrictedLengthVerifier(false, 30, lblClienteNickname.getText(), btnSave
                )
        );
        txtClienteNombre.setInputVerifier(
                new RestrictedLengthVerifier(false, 150, lblClienteNombre.getText(), btnSave)
        );
        txtClienteAltura.setInputVerifier(
                new NumericInputVerifier(true, 0, lblClienteAltura.getText(), btnSave)
        );
        txtClientePeso.setInputVerifier(
                new NumericInputVerifier(true, 0, lblClientePeso.getText(), btnSave)
        );

    }

    //<editor-fold defaultstate="collapsed" desc="Document Listeners para los setters. Mucho código.">
    private void addDocumentListeners() {
        txtClienteNickname.getDocument().addDocumentListener(new DocumentListener() {
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
                String text = txtClienteNickname.getText().trim();
                cliente.setNickname(text);
            }
        });
        txtClienteNombre.getDocument().addDocumentListener(new DocumentListener() {
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
                String text = txtClienteNombre.getText().trim();
                cliente.setNombreApellidos(text);
            }
        });
        txtClienteAltura.getDocument().addDocumentListener(new DocumentListener() {
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
                    float altura = Float.parseFloat(txtClienteAltura.getText().trim());
                    cliente.setAltura(altura);
                } catch (NumberFormatException nfex) {
                    //Ignoramos. Gestionado en la validación.
                }
            }
        });
        txtClientePeso.getDocument().addDocumentListener(new DocumentListener() {
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
                    float peso = Float.parseFloat(txtClientePeso.getText().trim());
                    cliente.setPeso(peso);
                } catch (NumberFormatException nfex) {
                    //Ignoramos. Gestionado en la validación.
                }
            }
        });
    }
    //</editor-fold>

    private void actionButtonsEnabledState(boolean b) {
        btnCancel.setEnabled(b);
        btnFoto.setEnabled(b);
        btnSave.setEnabled(b);
    }

    private void displayImageIcon(File chosenFile) {
        try {
            BufferedImage image = ImageIO.read(chosenFile);
            lblClienteFoto.setIcon(new ImageIcon(image.getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error leyendo la imagen.");
        }
    }
}
