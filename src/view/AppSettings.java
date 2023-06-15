package view;

import controller.config.ConfigurationController;
import controller.database.DatabaseController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import controller.exception.FTPControllerException;
import controller.ftp.FTPController;
import javax.swing.JOptionPane;

/**
 * Pantalla de ajustes.
 * @author AaronFM
 */
public class AppSettings extends javax.swing.JDialog {

    private static AppSettings instance;

    private ConfigurationController configuration;
    private Principal principal;

    /**
     *
     * @param principal
     * @return
     */
    public static AppSettings getInstance(Principal principal) {
        if (instance == null) {
            instance = new AppSettings(principal, true);
            instance.principal = principal;
        }
        instance.configuration = ConfigurationController.getInstance();
        instance.loadFields();
        return instance;
    }

    private AppSettings(Principal parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlDatabase = new javax.swing.JPanel();
        lblDbIP = new javax.swing.JLabel();
        txtDbIP = new javax.swing.JTextField();
        lblDbPort = new javax.swing.JLabel();
        txtDbPort = new javax.swing.JTextField();
        lblDbUser = new javax.swing.JLabel();
        txtDbUser = new javax.swing.JTextField();
        lblDbPassword = new javax.swing.JLabel();
        txtDbPassword = new javax.swing.JTextField();
        pnlFTP = new javax.swing.JPanel();
        lblFtpIP = new javax.swing.JLabel();
        txtFtpIP = new javax.swing.JTextField();
        lblFtpPort = new javax.swing.JLabel();
        txtFtpPort = new javax.swing.JTextField();
        lblFtpUser = new javax.swing.JLabel();
        txtFtpUser = new javax.swing.JTextField();
        lblFtpPassword = new javax.swing.JLabel();
        txtFtpPassword = new javax.swing.JTextField();
        pnlButtons = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnCancel = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnSave = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlDatabase.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlDatabase.setLayout(new java.awt.GridLayout(2, 2, 20, 40));

        lblDbIP.setText("IP");
        pnlDatabase.add(lblDbIP);
        pnlDatabase.add(txtDbIP);

        lblDbPort.setText("Puerto");
        pnlDatabase.add(lblDbPort);
        pnlDatabase.add(txtDbPort);

        lblDbUser.setText("Usuario");
        pnlDatabase.add(lblDbUser);
        pnlDatabase.add(txtDbUser);

        lblDbPassword.setText("Clave");
        pnlDatabase.add(lblDbPassword);
        pnlDatabase.add(txtDbPassword);

        jTabbedPane1.addTab("Base de datos", pnlDatabase);

        pnlFTP.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlFTP.setLayout(new java.awt.GridLayout(2, 2, 20, 40));

        lblFtpIP.setText("IP");
        pnlFTP.add(lblFtpIP);
        pnlFTP.add(txtFtpIP);

        lblFtpPort.setText("Puerto");
        pnlFTP.add(lblFtpPort);
        pnlFTP.add(txtFtpPort);

        lblFtpUser.setText("Usuario");
        pnlFTP.add(lblFtpUser);
        pnlFTP.add(txtFtpUser);

        lblFtpPassword.setText("Clave");
        pnlFTP.add(lblFtpPassword);
        pnlFTP.add(txtFtpPassword);

        jTabbedPane1.addTab("FTP", pnlFTP);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pnlButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnlButtons.setLayout(new javax.swing.BoxLayout(pnlButtons, javax.swing.BoxLayout.LINE_AXIS));
        pnlButtons.add(filler1);

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlButtons.add(btnCancel);
        pnlButtons.add(filler3);

        btnSave.setText("Probar + Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlButtons.add(btnSave);
        pnlButtons.add(filler2);

        getContentPane().add(pnlButtons, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(500, 240));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        principal.runTask(() -> {
            try {
                btnSave.setEnabled(false);
                updateAppSettings();
                if (testConnectionSettings()) {
                    JOptionPane.showMessageDialog(rootPane, "Todo correcto!");
                }
                saveAppSettings();
                btnSave.setEnabled(true);
            } catch (EntityControllersException | ConfigurationControllerException | FTPControllerException ex) {
                btnSave.setEnabled(true);
                JOptionPane.showMessageDialog(rootPane, "Error probando conexión.\n" + ex.getMessage());
            }
        });
    }//GEN-LAST:event_btnSaveActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDbIP;
    private javax.swing.JLabel lblDbPassword;
    private javax.swing.JLabel lblDbPort;
    private javax.swing.JLabel lblDbUser;
    private javax.swing.JLabel lblFtpIP;
    private javax.swing.JLabel lblFtpPassword;
    private javax.swing.JLabel lblFtpPort;
    private javax.swing.JLabel lblFtpUser;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlDatabase;
    private javax.swing.JPanel pnlFTP;
    private javax.swing.JTextField txtDbIP;
    private javax.swing.JTextField txtDbPassword;
    private javax.swing.JTextField txtDbPort;
    private javax.swing.JTextField txtDbUser;
    private javax.swing.JTextField txtFtpIP;
    private javax.swing.JTextField txtFtpPassword;
    private javax.swing.JTextField txtFtpPort;
    private javax.swing.JTextField txtFtpUser;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    /**
     * Carga los campos con la información del controller.
     */
    private void loadFields() {
        try {
            //Db
            txtDbIP.setText(configuration.getDatabaseIP());
            txtDbPort.setText(configuration.getDatabasePort());
            txtDbUser.setText(configuration.getDatabaseUser());
            txtDbPassword.setText(configuration.getDatabasePassword());
            //Ftp
            txtFtpIP.setText(configuration.getFtpIP());
            txtFtpPort.setText(configuration.getFtpPort() + "");
            txtFtpUser.setText(configuration.getFtpUser());
            txtFtpPassword.setText(configuration.getFtpPassword());
        } catch (ConfigurationControllerException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private boolean testConnectionSettings() throws EntityControllersException, ConfigurationControllerException, FTPControllerException {
        try {
            DatabaseController.getInstance().disconnect();
            DatabaseController.getInstance();
            FTPController.getInstance().disconnect();
            FTPController.getInstance();
            return true;
        } catch (EntityControllersException | ConfigurationControllerException | FTPControllerException ex) {
            throw ex;
        }
    }

    private void saveAppSettings() {
        configuration.storeAppConfiguration();
    }

    private void updateAppSettings() {
        configuration.setDatabaseIP(txtDbIP.getText().trim());
        configuration.setDatabasePort(txtDbPort.getText().trim());
        configuration.setDatabaseUser(txtDbUser.getText().trim());
        configuration.setDatabasePassword(txtDbPassword.getText().trim());
        configuration.setFtpIP(txtFtpIP.getText().trim());
        configuration.setFtpPort(txtFtpPort.getText().trim());
        configuration.setFtpUser(txtFtpUser.getText().trim());
        configuration.setFtpPassword(txtFtpPassword.getText().trim());
    }

}
