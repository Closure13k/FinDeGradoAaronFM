/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.data.ClienteController;
import controller.data.ClienteEjercicioController;
import controller.data.EjercicioController;
import controller.exception.ConfigurationControllerException;
import controller.exception.EntityControllersException;
import controller.exception.FTPControllerException;
import controller.ftp.FTPController;
import controller.renderer.CustomListRenderers;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ClienteEjercicio;
import model.Ejercicio;

/**
 *
 * @author AaronFM
 */
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
        jScrollPane3 = new javax.swing.JScrollPane();
        lstClienteRelacion = new javax.swing.JList<>();
        pnlClienteFoto = new javax.swing.JPanel();
        lblClienteFoto = new javax.swing.JLabel();
        btnEditCliente = new javax.swing.JButton();
        btnRemoveCliente = new javax.swing.JButton();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        lstEjercicioRelacion = new javax.swing.JList<>();
        pnlEjercicioFoto = new javax.swing.JPanel();
        lblEjercicioFoto = new javax.swing.JLabel();
        btnEditEjercicio = new javax.swing.JButton();
        btnRemoveEjercicio = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuItemConfig = new javax.swing.JMenu();
        menuItemHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 460));
        setPreferredSize(new java.awt.Dimension(920, 460));

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
        pnlDataList.setLayout(new javax.swing.BoxLayout(pnlDataList, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(100, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(50, 50));

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

        lstClienteRelacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstClienteRelacion.setSelectionBackground(new java.awt.Color(255, 255, 255));
        lstClienteRelacion.setSelectionForeground(new java.awt.Color(255, 153, 0));
        jScrollPane3.setViewportView(lstClienteRelacion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 484;
        gridBagConstraints.ipady = 147;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(jScrollPane3, gridBagConstraints);

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
        gridBagConstraints.gridx = 5;
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
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlClienteDetails.add(btnRemoveCliente, gridBagConstraints);

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

        lstEjercicioRelacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEjercicioRelacion.setSelectionForeground(new java.awt.Color(255, 153, 0));
        jScrollPane4.setViewportView(lstEjercicioRelacion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 484;
        gridBagConstraints.ipady = 147;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(jScrollPane4, gridBagConstraints);

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
        gridBagConstraints.gridx = 5;
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
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        pnlEjercicioDetails.add(btnRemoveEjercicio, gridBagConstraints);

        pnlDataDetails.add(pnlEjercicioDetails, "ejercicio");

        pnlData.setRightComponent(pnlDataDetails);

        getContentPane().add(pnlData, java.awt.BorderLayout.CENTER);

        menuItemConfig.setText("Ajustes");
        menu.add(menuItemConfig);

        menuItemHelp.setText("Ayuda");
        menu.add(menuItemHelp);

        setJMenuBar(menu);

        setSize(new java.awt.Dimension(814, 497));
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

    }//GEN-LAST:event_btnEditClienteActionPerformed

    private void btnRemoveClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveClienteActionPerformed

    }//GEN-LAST:event_btnRemoveClienteActionPerformed

    private void btnEditEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditEjercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditEjercicioActionPerformed

    private void btnRemoveEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveEjercicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveEjercicioActionPerformed

    private void pnlClienteDetailsComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlClienteDetailsComponentHidden
        clearClienteFields();
    }//GEN-LAST:event_pnlClienteDetailsComponentHidden

    private void pnlEjercicioDetailsComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlEjercicioDetailsComponentHidden
        clearEjercicioFields();
    }//GEN-LAST:event_pnlEjercicioDetailsComponentHidden
    
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
    private javax.swing.JButton btnEditCliente;
    private javax.swing.JButton btnEditEjercicio;
    private javax.swing.JButton btnRemoveCliente;
    private javax.swing.JButton btnRemoveEjercicio;
    private javax.swing.JButton btnTableClientes;
    private javax.swing.JButton btnTableEjercicios;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JMenu menuItemHelp;
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

    public void runTask(Runnable task) {
        new Thread(task).start();
    }
    
    public Runnable loadJListTask(String cardTarget) {
        boolean isClienteTable = cardTarget.equals("cliente");
        return (Runnable) () -> {
            try {
                tablesButtonsEnabledState(false);
                listModel.removeAllElements();
                listModel.addAll(
                        isClienteTable
                                ? ClienteController.getInstance().getListadoClientes()
                                : EjercicioController.getInstance().getListadoEjercicios()
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
     * Alterna el estado de los botones mientras se procesa una tarea.
     *
     * @param enabled si se activan o no.
     */
    private void tablesButtonsEnabledState(boolean enabled) {
        btnTableClientes.setEnabled(enabled);
        btnTableEjercicios.setEnabled(enabled);
    }

    /**
     * Carga los campos de un cliente. La lista de relación se carga en
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

    private void resetImageIcon(String label) {
        String imageResourceName;
        JLabel targetLabel;
        if(label.equals("ejercicios")){
            imageResourceName = "exercise.png";
            targetLabel = lblEjercicioFoto;
        } else {
            imageResourceName = "profile.png";
            targetLabel = lblClienteFoto;
        }
        ImageIcon image = new ImageIcon(this.getClass().getResource("/resources/images/"+imageResourceName));
        Image scaledInstance = image.getImage().getScaledInstance(targetLabel.getWidth(), targetLabel.getHeight(), Image.SCALE_SMOOTH);
        targetLabel.setIcon(new ImageIcon(scaledInstance));
    }
    
    private Runnable downloadIconTask(String entity, String imgUrl) {
        return (Runnable) () -> {
            try {
                final FTPController instance = FTPController.getInstance();
                File imageFile = instance.downloadImage(entity, imgUrl);
                BufferedImage imagePreview = ImageIO.read(imageFile);
                if (entity.equals("clientes")) {
                    lblClienteFoto.setIcon(new ImageIcon(imagePreview.getScaledInstance(lblClienteFoto.getWidth(), lblClienteFoto.getHeight(), Image.SCALE_SMOOTH)));
                } else {
                    lblEjercicioFoto.setIcon(new ImageIcon(imagePreview.getScaledInstance(lblEjercicioFoto.getWidth(), lblEjercicioFoto.getHeight(), Image.SCALE_SMOOTH)));
                }
                
            } catch (IOException | ConfigurationControllerException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        };
    }
    
    private void clearEjercicioFields() {
        txtEjercicioId.setText("");
        txtEjercicioTipo.setText("");
        txtEjercicioInstrucciones.setText("");
        txtEjercicioPromedio.setText("");
        txtEjercicioRecord.setText("");
        listModelRelacion.removeAllElements();
        lstClienteRelacion.setModel(listModelRelacion);
    }
    
    private void clearClienteFields() {
        txtClienteId.setText("");
        txtClienteNickname.setText("");
        txtClienteNombre.setText("");
        txtClienteAltura.setText("");
        txtClientePeso.setText("");
        listModelRelacion.removeAllElements();
        lstClienteRelacion.setModel(listModelRelacion);
    }
    
}
