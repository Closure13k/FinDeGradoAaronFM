package view;

import controller.data.ClienteController;
import controller.data.EjercicioController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import controller.renderer.CustomListRenderers;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import model.Cliente;
import model.Ejercicio;

public class NewRelacion extends javax.swing.JDialog {

    private static NewRelacion instance;

    private Principal principal;
    private Cliente cliente;
    private Ejercicio ejercicio;

    public static NewRelacion getInstance(Principal p, Cliente c, Ejercicio e) {
        if (instance == null) {
            instance = new NewRelacion(p, true);
        }
        instance.principal = p;
        instance.cliente = c;
        instance.ejercicio = e;
        instance.loadCombos();

        return instance;
    }

    private NewRelacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cmbCliente.setRenderer(CustomListRenderers.INSTANCE);
        cmbEjercicio.setRenderer(CustomListRenderers.INSTANCE);
        dateChooser.setDate(new Date());
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

        pnlCombos.add(cmbCliente);
        pnlCombos.add(filler8);

        lblEjercicio.setText("Ejercicio");
        pnlCombos.add(lblEjercicio);
        pnlCombos.add(filler2);

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
        System.out.println(dateChooser.getDate());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

    }//GEN-LAST:event_btnCancelActionPerformed

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

    private void loadCombos() {
        try {
            cmbCliente.removeAllItems();
            List<Cliente> allClientes = ClienteController.getInstance().getAllClientes();
            allClientes.forEach(cmbCliente::addItem);
            cmbEjercicio.removeAllItems();
            List<Ejercicio> allEjercicios = EjercicioController.getInstance().getAllEjercicios();
            allEjercicios.forEach(cmbEjercicio::addItem);

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

        } catch (EntityControllersException | ConfigurationControllerException ex) {
            Logger.getLogger(NewRelacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
