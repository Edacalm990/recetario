/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.IngredienteJpaController;
import controladores.Miscelanea;
import entidades.Ingrediente;
import javax.swing.JOptionPane;

/**
 *
 * @author venganzaalchocolate
 */
public class CrearIngrediente extends javax.swing.JFrame {

    IngredienteJpaController controladorIngrediente = new IngredienteJpaController(Miscelanea.getEntityManager());

    /**
     * Creates new form buscarIngrediente
     */
    public CrearIngrediente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        botonLista3 = new javax.swing.JButton();
        botonLista4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(238, 244, 238));
        jTextField1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 102, 153));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jTextField1.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jTextField1.setSelectionColor(new java.awt.Color(0, 102, 153));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 490, 40));

        botonLista3.setBackground(new java.awt.Color(179, 57, 170));
        botonLista3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        botonLista3.setForeground(new java.awt.Color(255, 255, 255));
        botonLista3.setText("Añadir");
        botonLista3.setBorderPainted(false);
        botonLista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLista3ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLista3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 130, 50));

        botonLista4.setBackground(new java.awt.Color(252, 167, 46));
        botonLista4.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        botonLista4.setForeground(new java.awt.Color(255, 255, 255));
        botonLista4.setText("<-");
        botonLista4.setBorderPainted(false);
        botonLista4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLista4ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLista4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 70, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/crearIngrediente.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista3ActionPerformed
        String nombre = jTextField1.getText();
        try {
            controladorIngrediente.findByNombreIngrediente(nombre.toLowerCase());
            JOptionPane.showMessageDialog(null, "El ingrediente ya existe.");
        } catch (Exception e) {
            if (JOptionPane.showConfirmDialog(null, "Seguro que deseas crear el ingrediente %s".formatted(nombre.toLowerCase())) == 0) {
                controladorIngrediente.create(new Ingrediente(nombre.toLowerCase()));
            }
        }
    }//GEN-LAST:event_botonLista3ActionPerformed

    private void botonLista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista4ActionPerformed
        dispose();
    }//GEN-LAST:event_botonLista4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearIngrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearIngrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearIngrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearIngrediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearIngrediente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLista3;
    private javax.swing.JButton botonLista4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
