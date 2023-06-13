package view;

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
        
        return instance;
    }

    private NewRelacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
