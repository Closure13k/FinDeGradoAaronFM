package view;

import controller.data.ClienteController;
import controller.data.ClienteEjercicioController;
import controller.data.EjercicioController;
import controller.database.DatabaseController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import controller.exception.FTPControllerException;
import controller.renderer.CustomListRenderers;
import controller.ftp.FTPController;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ClienteEjercicio;
import model.Ejercicio;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        cardLayout = (CardLayout) pnlDataDetails.getLayout();
        listModel = new DefaultListModel<>();
        listModelRelacion = new DefaultListModel<>();
        lstData.setCellRenderer(CustomListRenderers.INSTANCE);
        lstClienteRelacion.setCellRenderer(CustomListRenderers.INSTANCE);
        lstEjercicioRelacion.setCellRenderer(CustomListRenderers.INSTANCE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlTableButtons = new javax.swing.JPanel();
        pnlTablesFillLeft = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnTableClientes = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 35), new java.awt.Dimension(0, 35), new java.awt.Dimension(32767, 35));
        btnTableEjercicios = new javax.swing.JButton();
        pnlTablesFillRight = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        pnlData = new javax.swing.JSplitPane();
        pnlDataList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstData = new javax.swing.JList<>();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        btnNew = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        pnlDataDetails = new javax.swing.JPanel();
        pnlSearchLogo = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        lblSearchIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
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
        btnEditCliente = new javax.swing.JButton();
        btnRemoveCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstClienteRelacion = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnAddRelacionCliente = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnRemoveRelacionCliente = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        btnEditEjercicio = new javax.swing.JButton();
        btnRemoveEjercicio = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstEjercicioRelacion = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnAddRelacionEjercicio = new javax.swing.JButton();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnRemoveRelacionEjercicio = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        menu = new javax.swing.JMenuBar();
        menuItemConfig = new javax.swing.JMenu();
        mnItAjustes = new javax.swing.JMenuItem();
        mnItAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 460));
        setPreferredSize(new java.awt.Dimension(920, 460));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlTableButtons.setLayout(new javax.swing.BoxLayout(pnlTableButtons, javax.swing.BoxLayout.LINE_AXIS));
        pnlTableButtons.add(pnlTablesFillLeft);

        btnTableClientes.setText("Clientes");
        btnTableClientes.setMaximumSize(new java.awt.Dimension(100, 25));
        btnTableClientes.setMinimumSize(new java.awt.Dimension(100, 25));
        btnTableClientes.setPreferredSize(new java.awt.Dimension(100, 25));
        btnTableClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableClientesActionPerformed(evt);
            }
        });
        pnlTableButtons.add(btnTableClientes);
        pnlTableButtons.add(filler1);

        btnTableEjercicios.setText("Ejercicios");
        btnTableEjercicios.setMaximumSize(new java.awt.Dimension(100, 25));
        btnTableEjercicios.setMinimumSize(new java.awt.Dimension(100, 25));
        btnTableEjercicios.setPreferredSize(new java.awt.Dimension(100, 25));
        btnTableEjercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableEjerciciosActionPerformed(evt);
            }
        });
        pnlTableButtons.add(btnTableEjercicios);
        pnlTableButtons.add(pnlTablesFillRight);

        getContentPane().add(pnlTableButtons, java.awt.BorderLayout.NORTH);

        pnlData.setDividerLocation(120);

        pnlDataList.setMinimumSize(new java.awt.Dimension(100, 100));
        pnlDataList.setLayout(new javax.swing.BoxLayout(pnlDataList, javax.swing.BoxLayout.PAGE_AXIS));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(50, 50));

        lstData.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lstData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstData.setSelectionBackground(new java.awt.Color(255, 255, 255));
        lstData.setSelectionForeground(new java.awt.Color(255, 153, 0));
        lstData.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDataValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstData);

        pnlDataList.add(jScrollPane1);
        pnlDataList.add(filler4);

        btnNew.setText("Nuevo");
        btnNew.setAlignmentX(0.5F);
        btnNew.setAlignmentY(0.0F);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        pnlDataList.add(btnNew);
        pnlDataList.add(filler5);

        pnlData.setLeftComponent(pnlDataList);

        pnlDataDetails.setLayout(new java.awt.CardLayout());

        pnlSearchLogo.setLayout(new java.awt.GridLayout(0, 1));
        pnlSearchLogo.add(filler2);

        lblSearchIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/search_icon.png"))); // NOI18N
        pnlSearchLogo.add(lblSearchIcon);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pulsa sobre la lista para visualizar detalles.");
        pnlSearchLogo.add(jLabel1);
        pnlSearchLogo.add(filler3);

        pnlDataDetails.add(pnlSearchLogo, "logo");
        pnlSearchLogo.getAccessibleContext().setAccessibleName("pnlSearchLogo");

        pnlClienteDetails.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                pnlClienteDetailsComponentHidden(evt);
            }
        });
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

        txtClienteNickname.setEditable(false);
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

        txtClienteNombre.setEditable(false);
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

        txtClienteAltura.setEditable(false);
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

        txtClientePeso.setEditable(false);
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

        pnlClienteFoto.setMinimumSize(new java.awt.Dimension(128, 128));
        pnlClienteFoto.setPreferredSize(new java.awt.Dimension(128, 128));
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

        btnEditCliente.setText("Editar");
        btnEditCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(btnEditCliente, gridBagConstraints);

        btnRemoveCliente.setText("Borrar");
        btnRemoveCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(btnRemoveCliente, gridBagConstraints);

        jPanel1.setLayout(new java.awt.BorderLayout());

        lstClienteRelacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lstClienteRelacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstClienteRelacion.setSelectionBackground(new java.awt.Color(255, 255, 255));
        lstClienteRelacion.setSelectionForeground(new java.awt.Color(255, 153, 0));
        jScrollPane3.setViewportView(lstClienteRelacion);

        jPanel1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler6);

        btnAddRelacionCliente.setText("Nuevo");
        btnAddRelacionCliente.setMaximumSize(new java.awt.Dimension(100, 25));
        btnAddRelacionCliente.setMinimumSize(new java.awt.Dimension(100, 25));
        btnAddRelacionCliente.setPreferredSize(new java.awt.Dimension(100, 25));
        btnAddRelacionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRelacionClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddRelacionCliente);
        jPanel2.add(filler7);

        btnRemoveRelacionCliente.setText("Borrar");
        btnRemoveRelacionCliente.setMaximumSize(new java.awt.Dimension(100, 25));
        btnRemoveRelacionCliente.setMinimumSize(new java.awt.Dimension(100, 25));
        btnRemoveRelacionCliente.setPreferredSize(new java.awt.Dimension(100, 25));
        btnRemoveRelacionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveRelacionClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnRemoveRelacionCliente);
        jPanel2.add(filler8);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);
        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_END);
        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlClienteDetails.add(jPanel1, gridBagConstraints);

        pnlDataDetails.add(pnlClienteDetails, "cliente");

        pnlEjercicioDetails.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                pnlEjercicioDetailsComponentHidden(evt);
            }
        });
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

        txtEjercicioTipo.setEditable(false);
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

        txtEjercicioInstrucciones.setEditable(false);
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

        btnEditEjercicio.setText("Editar");
        btnEditEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditEjercicioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(btnEditEjercicio, gridBagConstraints);

        btnRemoveEjercicio.setText("Borrar");
        btnRemoveEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveEjercicioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(btnRemoveEjercicio, gridBagConstraints);

        jPanel5.setLayout(new java.awt.BorderLayout());

        lstEjercicioRelacion.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lstEjercicioRelacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEjercicioRelacion.setSelectionForeground(new java.awt.Color(255, 153, 0));
        jScrollPane4.setViewportView(lstEjercicioRelacion);

        jPanel5.add(jScrollPane4, java.awt.BorderLayout.CENTER);
        jPanel5.add(jPanel6, java.awt.BorderLayout.LINE_END);
        jPanel5.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));
        jPanel7.add(filler9);

        btnAddRelacionEjercicio.setText("Nuevo");
        btnAddRelacionEjercicio.setMaximumSize(new java.awt.Dimension(100, 25));
        btnAddRelacionEjercicio.setMinimumSize(new java.awt.Dimension(100, 25));
        btnAddRelacionEjercicio.setPreferredSize(new java.awt.Dimension(100, 25));
        btnAddRelacionEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRelacionEjercicioActionPerformed(evt);
            }
        });
        jPanel7.add(btnAddRelacionEjercicio);
        jPanel7.add(filler10);

        btnRemoveRelacionEjercicio.setText("Borrar");
        btnRemoveRelacionEjercicio.setMaximumSize(new java.awt.Dimension(100, 25));
        btnRemoveRelacionEjercicio.setMinimumSize(new java.awt.Dimension(100, 25));
        btnRemoveRelacionEjercicio.setPreferredSize(new java.awt.Dimension(100, 25));
        btnRemoveRelacionEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveRelacionEjercicioActionPerformed(evt);
            }
        });
        jPanel7.add(btnRemoveRelacionEjercicio);
        jPanel7.add(filler11);

        jPanel5.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlEjercicioDetails.add(jPanel5, gridBagConstraints);

        pnlDataDetails.add(pnlEjercicioDetails, "ejercicio");

        pnlData.setRightComponent(pnlDataDetails);

        getContentPane().add(pnlData, java.awt.BorderLayout.CENTER);

        menuItemConfig.setText("Ajustes");

        mnItAjustes.setText("Ajustes");
        mnItAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItAjustesActionPerformed(evt);
            }
        });
        menuItemConfig.add(mnItAjustes);

        mnItAyuda.setText("Ayuda");
        mnItAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItAyudaActionPerformed(evt);
            }
        });
        menuItemConfig.add(mnItAyuda);

        menu.add(menuItemConfig);

        setJMenuBar(menu);

        setSize(new java.awt.Dimension(787, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTableClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableClientesActionPerformed
        runTask(loadJListTask("cliente"));
    }//GEN-LAST:event_btnTableClientesActionPerformed

    private void btnTableEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableEjerciciosActionPerformed
        runTask(loadJListTask("ejercicio"));
    }//GEN-LAST:event_btnTableEjerciciosActionPerformed

    private void lstDataValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDataValueChanged
        if (!evt.getValueIsAdjusting()) {
            Object selectedValue = lstData.getSelectedValue();
            refreshDetailsPanel(selectedValue);
        }
    }//GEN-LAST:event_lstDataValueChanged

    private void btnEditClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClienteActionPerformed
        openUpdateDialog(lstData.getSelectedValue());
    }//GEN-LAST:event_btnEditClienteActionPerformed

    private void btnRemoveClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveClienteActionPerformed
        Object selectedValue = lstData.getSelectedValue();
        if (selectedValue != null) {
            runTask(deleteEntity(selectedValue));
        }
    }//GEN-LAST:event_btnRemoveClienteActionPerformed

    private void btnEditEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditEjercicioActionPerformed
        openUpdateDialog(lstData.getSelectedValue());
    }//GEN-LAST:event_btnEditEjercicioActionPerformed

    private void btnRemoveEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveEjercicioActionPerformed
        Object selectedValue = lstData.getSelectedValue();
        if (selectedValue != null) {
            runTask(deleteEntity(selectedValue));
        }
    }//GEN-LAST:event_btnRemoveEjercicioActionPerformed

    private void pnlClienteDetailsComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlClienteDetailsComponentHidden
        clearClienteFields();
    }//GEN-LAST:event_pnlClienteDetailsComponentHidden

    private void pnlEjercicioDetailsComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlEjercicioDetailsComponentHidden
        clearEjercicioFields();
    }//GEN-LAST:event_pnlEjercicioDetailsComponentHidden

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        runTask(() -> {
            try {
                DatabaseController.getInstance().disconnect();
                FTPController.getInstance().disconnect();
                dispose();
                System.exit(0);
            } catch (EntityControllersException | ConfigurationControllerException | FTPControllerException ex) {
                System.exit(1);
            }
        }
        );
    }//GEN-LAST:event_formWindowClosing

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        openInsertDialog();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddRelacionEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRelacionEjercicioActionPerformed
        openRelacionDialog(lstData.getSelectedValue());
    }//GEN-LAST:event_btnAddRelacionEjercicioActionPerformed

    private void btnRemoveRelacionEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveRelacionEjercicioActionPerformed
        Object selectedValue = lstEjercicioRelacion.getSelectedValue();
        if (selectedValue != null) {
            runTask(deleteRelacion(selectedValue));
        }
    }//GEN-LAST:event_btnRemoveRelacionEjercicioActionPerformed

    private void btnAddRelacionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRelacionClienteActionPerformed
        openRelacionDialog(lstData.getSelectedValue());
    }//GEN-LAST:event_btnAddRelacionClienteActionPerformed

    private void btnRemoveRelacionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveRelacionClienteActionPerformed
        Object selectedValue = lstClienteRelacion.getSelectedValue();
        if (selectedValue != null) {
            runTask(deleteRelacion(selectedValue));
        }
    }//GEN-LAST:event_btnRemoveRelacionClienteActionPerformed

    private void mnItAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItAjustesActionPerformed
        AppSettings.getInstance(this).setVisible(true);
    }//GEN-LAST:event_mnItAjustesActionPerformed

    private void mnItAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnItAyudaActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    DefaultListModel<Object> listModelRelacion;
    DefaultListModel<Object> listModel;
    CardLayout cardLayout;

    //<editor-fold defaultstate="collapsed" desc="Generated variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRelacionCliente;
    private javax.swing.JButton btnAddRelacionEjercicio;
    private javax.swing.JButton btnEditCliente;
    private javax.swing.JButton btnEditEjercicio;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemoveCliente;
    private javax.swing.JButton btnRemoveEjercicio;
    private javax.swing.JButton btnRemoveRelacionCliente;
    private javax.swing.JButton btnRemoveRelacionEjercicio;
    private javax.swing.JButton btnTableClientes;
    private javax.swing.JButton btnTableEjercicios;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblClienteAltura;
    private javax.swing.JLabel lblClienteFoto;
    private javax.swing.JLabel lblClienteId;
    private javax.swing.JLabel lblClienteNickname;
    private javax.swing.JLabel lblClienteNombre;
    private javax.swing.JLabel lblClientePeso;
    private javax.swing.JLabel lblEjercicioFoto;
    private javax.swing.JLabel lblEjercicioId;
    private javax.swing.JLabel lblEjercicioInstrucciones;
    private javax.swing.JLabel lblEjercicioPromedio;
    private javax.swing.JLabel lblEjercicioRecord;
    private javax.swing.JLabel lblEjercicioTipo;
    private javax.swing.JLabel lblSearchIcon;
    private javax.swing.JList<Object> lstClienteRelacion;
    private javax.swing.JList<Object> lstData;
    private javax.swing.JList<Object> lstEjercicioRelacion;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuItemConfig;
    private javax.swing.JMenuItem mnItAjustes;
    private javax.swing.JMenuItem mnItAyuda;
    private javax.swing.JPanel pnlClienteDetails;
    private javax.swing.JPanel pnlClienteFoto;
    private javax.swing.JSplitPane pnlData;
    private javax.swing.JPanel pnlDataDetails;
    private javax.swing.JPanel pnlDataList;
    private javax.swing.JPanel pnlEjercicioDetails;
    private javax.swing.JPanel pnlEjercicioFoto;
    private javax.swing.JPanel pnlSearchLogo;
    private javax.swing.JPanel pnlTableButtons;
    private javax.swing.Box.Filler pnlTablesFillLeft;
    private javax.swing.Box.Filler pnlTablesFillRight;
    private javax.swing.JTextField txtClienteAltura;
    private javax.swing.JTextField txtClienteId;
    private javax.swing.JTextField txtClienteNickname;
    private javax.swing.JTextField txtClienteNombre;
    private javax.swing.JTextField txtClientePeso;
    private javax.swing.JTextField txtEjercicioId;
    private javax.swing.JTextField txtEjercicioInstrucciones;
    private javax.swing.JTextField txtEjercicioPromedio;
    private javax.swing.JTextField txtEjercicioRecord;
    private javax.swing.JTextField txtEjercicioTipo;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    /**
     * Ejecuta una acción en un hilo separado.
     *
     * @param task la acción pesada a ejecutar.
     */
    public void runTask(Runnable task) {
        new Thread(task).start();
    }

    /**
     * Carga la lista en base a lo recibido de la base de datos.
     *
     * @param cardTarget La entidad que recibirá.
     * @return la tarea a lanzar por
     * @see #runTask(java.lang.Runnable)
     */
    public Runnable loadJListTask(String cardTarget) {
        boolean isClienteTable = cardTarget.equals("cliente");
        return (Runnable) () -> {
            try {
                tablesButtonsEnabledState(false);
                listModel.removeAllElements();
                listModel.addAll(
                        isClienteTable
                                ? ClienteController.getInstance().getAllClientes()
                                : EjercicioController.getInstance().getAllEjercicios()
                );
                lstData.setModel(listModel);

                btnTableClientes.setEnabled(!isClienteTable);
                btnTableEjercicios.setEnabled(isClienteTable);

                cardLayout.show(pnlDataDetails, isClienteTable ? "cliente" : "ejercicio");
            } catch (EntityControllersException | ConfigurationControllerException ex) {
                tablesButtonsEnabledState(true);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        };
    }

    /**
     * Lanza la ventana de inserción en base al tipo de listado que se cargó.
     */
    private void openInsertDialog() {
        if (pnlClienteDetails.isShowing()) {
            NewUpdateCliente.getInstance(this, new Cliente()).setVisible(true);
        }
        if (pnlEjercicioDetails.isShowing()) {
            NewUpdateEjercicio.getInstance(this, new Ejercicio()).setVisible(true);
        }
    }

    /**
     * Lanza la ventana de actualización.
     * <br>
     * Inserción y actualización son el mismo Dialog, pero diferencian sus
     * acciones según lo recibido.
     *
     * @param selectedValue
     */
    private void openUpdateDialog(Object selectedValue) {
        if (selectedValue == null) {
            return;
        }
        if (selectedValue instanceof Ejercicio e) {
            NewUpdateEjercicio.getInstance(this, e).setVisible(true);
        }
        if (selectedValue instanceof Cliente c) {
            NewUpdateCliente.getInstance(this, c).setVisible(true);
        }
    }

    private void openRelacionDialog(Object selectedValue) {
        if (selectedValue == null) {
            return;
        }
        if (selectedValue instanceof Ejercicio e) {
            NewRelacion.getInstance(this, null, e).setVisible(true);
        }
        if (selectedValue instanceof Cliente c) {
            NewRelacion.getInstance(this, c, null).setVisible(true);
        }
    }

    /**
     * Prepara la entidad seleccionada en los detalles para su borrado.
     *
     * @param selectedValue
     */
    private Runnable deleteEntity(Object selectedValue) {
        return () -> {
            try {
                if (selectedValue instanceof Ejercicio e) {
                    int response = JOptionPane.showConfirmDialog(rootPane, "Procedes a borrar:\n" + e.getTipo() + "\nSe borrarán todas las entradas de los clientes con este ejercicio.\nConfirmas?");
                    if (response == 0) {
                        Ejercicio deleted = EjercicioController.getInstance().deleteEjercicioRecursively(e);
                        clearEjercicioFields();
                        runTask(loadJListTask("ejercicio"));
                        JOptionPane.showMessageDialog(rootPane, "Borrado: " + deleted.getTipo());
                    }
                }
                if (selectedValue instanceof Cliente c) {
                    int response = JOptionPane.showConfirmDialog(rootPane, "Procedes a borrar:\n" + c.getNickname() + "\nSe borrarán todas las entradas de los ejercicios con este cliente.\nConfirmas?");
                    if (response == 0) {
                        Cliente deleted = ClienteController.getInstance().deleteClienteRecursively(c);
                        clearClienteFields();
                        runTask(loadJListTask("cliente"));
                        JOptionPane.showMessageDialog(rootPane, "Borrado: " + deleted.getNickname());
                    }
                }

            } catch (EntityControllersException | ConfigurationControllerException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        };
    }

    /**
     * Tarea que borra una entrada de relación.
     *
     * @param selectedValue
     * @return
     */
    private Runnable deleteRelacion(Object selectedValue) {
        return () -> {
            ClienteEjercicio clienteEjercicio = (ClienteEjercicio) selectedValue;
            try {
                ClienteEjercicio deleted = ClienteEjercicioController.getInstance().deleteClienteEjercicio(clienteEjercicio);
                listModelRelacion.removeElement(clienteEjercicio);
                if(pnlClienteDetails.isShowing()){
                    lstClienteRelacion.setModel(listModelRelacion);
                } else {
                    lstEjercicioRelacion.setModel(listModelRelacion);
                }
                JOptionPane.showMessageDialog(rootPane, "Borrado ejercicio realizado por: " + deleted.getCliente().getNickname() + "\nque fue: " + deleted.getEjercicio().getTipo() + "\na fecha: " + deleted.getFecha());
            } catch (EntityControllersException | ConfigurationControllerException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }

        };
    }

    /**
     * Carga la relación según el objeto seleccionado.
     *
     * @param selectedValue
     */
    private void refreshDetailsPanel(Object selectedValue) {
        try {
            ClienteEjercicioController controller = ClienteEjercicioController.getInstance();
            List<ClienteEjercicio> ejercicios;
            if (selectedValue instanceof Cliente c) {
                updateClienteDetails(c);
                ejercicios = controller.getEjerciciosByClienteId(c.getIdCliente());

                listModelRelacion.removeAllElements();
                listModelRelacion.addAll(ejercicios);
                lstClienteRelacion.setModel(listModelRelacion);
            }

            if (selectedValue instanceof Ejercicio e) {
                updateEjercicioDetails(e);
                ejercicios = controller.getClientesByEjercicioId(e.getIdEjercicio());

                listModelRelacion.removeAllElements();
                listModelRelacion.addAll(ejercicios);
                lstEjercicioRelacion.setModel(listModelRelacion);
            }
        } catch (EntityControllersException | ConfigurationControllerException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    /**
     * Carga los campos de un cliente.
     * <br>
     * La lista de relación se carga en
     *
     * @see #refreshDetailsPanel(java.lang.Object)
     * @param c
     */
    private void updateClienteDetails(Cliente c) {
        txtClienteId.setText(c.getIdCliente() + "");
        txtClienteNickname.setText(c.getNickname());
        txtClienteNombre.setText(c.getNombreApellidos());
        txtClienteAltura.setText(c.getAltura() + "");
        txtClientePeso.setText(c.getPeso() + "");
        final String imageUrl = c.getFotoPerfil();
        if (imageUrl == null || imageUrl.isBlank()) {
            resetImageIcon("clientes");
        } else {
            runTask(downloadIconTask("clientes", imageUrl));
        }

    }

    /**
     * Carga los campos de un ejercicio.
     * <br>
     * La lista de relación se carga en
     *
     * @see #refreshDetailsPanel(java.lang.Object)
     * @param e
     */
    private void updateEjercicioDetails(Ejercicio e) {
        txtEjercicioId.setText(e.getIdEjercicio() + "");
        txtEjercicioTipo.setText(e.getTipo());
        txtEjercicioInstrucciones.setText(e.getInstrucciones());
        txtEjercicioPromedio.setText(e.getPromedio() + "");
        txtEjercicioRecord.setText(e.getRecord() + "");
        final String imageUrl = e.getFotoEjercicio();
        if (imageUrl == null || imageUrl.isBlank()) {
            resetImageIcon("ejercicios");
        } else {
            runTask(downloadIconTask("ejercicios", imageUrl));
        }
    }

    /**
     * Pone el icono por defecto.
     *
     * @param label
     */
    private void resetImageIcon(String label) {
        String imageResourceName;
        JLabel targetLabel;
        if (label.equals("ejercicios")) {
            imageResourceName = "exercise.png";
            targetLabel = lblEjercicioFoto;
        } else {
            imageResourceName = "profile.png";
            targetLabel = lblClienteFoto;
        }
        ImageIcon image = new ImageIcon(this.getClass().getResource("/resources/images/" + imageResourceName));
        Image scaledInstance = image.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
        targetLabel.setIcon(new ImageIcon(scaledInstance));
    }

    /**
     * Descarga la imagen según la entidad (cliente, ejercicio).
     *
     * @param entity
     * @param imgUrl
     * @return
     */
    private Runnable downloadIconTask(String entity, String imgUrl) {
        return (Runnable) () -> {
            final boolean isClientesEntity = entity.equals("clientes");
            try {
                final FTPController instance = FTPController.getInstance();
                File imageFile = instance.downloadImage(entity, imgUrl);

                Image imagePreview = ImageIO.read(imageFile);
                if (isClientesEntity) {
                    lblClienteFoto.setIcon(new ImageIcon(imagePreview.getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                } else {
                    lblEjercicioFoto.setIcon(new ImageIcon(imagePreview.getScaledInstance(128, 128, Image.SCALE_SMOOTH)));
                }
            } catch (IOException | ConfigurationControllerException ex) {
                resetImageIcon(isClientesEntity ? "clientes" : "ejercicios");
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            } catch (NullPointerException npe) {
                resetImageIcon(isClientesEntity ? "clientes" : "ejercicios");
                JOptionPane.showMessageDialog(rootPane, "Error leyendo la imagen descargada.");
            }
        };
    }

    /**
     * Vacía los campos del panel Ejercicio.
     */
    private void clearEjercicioFields() {
        txtEjercicioId.setText("");
        txtEjercicioTipo.setText("");
        txtEjercicioInstrucciones.setText("");
        txtEjercicioPromedio.setText("");
        txtEjercicioRecord.setText("");
        listModelRelacion.removeAllElements();
        lstClienteRelacion.setModel(listModelRelacion);
    }

    /**
     * Vacía los campos del pane Cliente.
     */
    private void clearClienteFields() {
        txtClienteId.setText("");
        txtClienteNickname.setText("");
        txtClienteNombre.setText("");
        txtClienteAltura.setText("");
        txtClientePeso.setText("");
        listModelRelacion.removeAllElements();
        lstClienteRelacion.setModel(listModelRelacion);
    }

    /**
     * Alterna el estado de los botones mientras se procesa una tarea.
     *
     * @param enabled si se activan o no.
     */
    private void tablesButtonsEnabledState(boolean enabled) {
        btnTableClientes.setEnabled(enabled);
        btnTableEjercicios.setEnabled(enabled);
    }

    /**
     * Manda la foto a una pantalla hija que la necesite.
     *
     * @param o
     * @return
     */
    public Icon sendIcon(Object o) {
        if (o instanceof Cliente) {
            return lblClienteFoto.getIcon();
        } else {
            return lblEjercicioFoto.getIcon();
        }
    }

}
