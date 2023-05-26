/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.Backup;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import recetario.Recetario;

/**
 *
 * @author venganzaalchocolate
 */
public class Portada extends javax.swing.JFrame {

    /**
     * Creates new form portada
     */
    public Portada() {
        initComponents();
        jLabel3.setText(Recetario.usuario.getNombre());
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
        jLabel3 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        botonLista4 = new javax.swing.JButton();
        botonLista3 = new javax.swing.JButton();
        botonLista2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 60, -1));

        botonAtras.setBackground(new java.awt.Color(238, 244, 238));
        botonAtras.setForeground(new java.awt.Color(238, 244, 238));
        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Etiqueta.png"))); // NOI18N
        botonAtras.setBorder(null);
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonAtras.setFocusPainted(false);
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, -18, -1, 160));

        botonLista4.setBackground(new java.awt.Color(179, 57, 170));
        botonLista4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLista4.setForeground(new java.awt.Color(255, 255, 255));
        botonLista4.setText("Crear Backup");
        botonLista4.setBorderPainted(false);
        botonLista4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLista4ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLista4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 710, 170, 50));

        botonLista3.setBackground(new java.awt.Color(252, 167, 46));
        botonLista3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLista3.setForeground(new java.awt.Color(255, 255, 255));
        botonLista3.setText("Cargar Backup");
        botonLista3.setBorderPainted(false);
        botonLista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLista3ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLista3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 650, 170, 50));

        botonLista2.setBackground(new java.awt.Color(252, 167, 46));
        botonLista2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLista2.setForeground(new java.awt.Color(255, 255, 255));
        botonLista2.setText("Ver recetas");
        botonLista2.setBorderPainted(false);
        botonLista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLista2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 590, 170, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/portada.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 980));

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 440, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonLista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista2ActionPerformed

        if(Recetario.usuario.getCodUsuario()!=null){
        PaginaLista recetas= new PaginaLista();
        recetas.pack();
        recetas.setLocationRelativeTo(null);
        recetas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un usuario");
        }
    }//GEN-LAST:event_botonLista2ActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        SeleccionarUsuario usuario = new SeleccionarUsuario();
        usuario.pack();
        usuario.setLocationRelativeTo(null);
        usuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonLista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLista3ActionPerformed

    private void botonLista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista4ActionPerformed
       String fecha= LocalDate.now().toString();
       
       Backup.crearDirectorio("./backup");
       Stream<Path> directorios=Backup.listarTodo("./");
     
       //Backup.crearDirectorios("./backup/%s".formatted(fecha));
       
    }//GEN-LAST:event_botonLista4ActionPerformed

      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonLista2;
    private javax.swing.JButton botonLista3;
    private javax.swing.JButton botonLista4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
