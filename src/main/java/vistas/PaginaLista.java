/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.Miscelanea;
import controladores.RecetaJpaController;
import entidades.Receta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author venganzaalchocolate
 */
public class PaginaLista extends javax.swing.JFrame {
    
    private List<Receta> listaRecetas;

    /**
     * Creates new form PaginaLista
     */
    public PaginaLista() {
        listaRecetas=new ArrayList<>();
        initComponents();
        cargarRecetas();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        botonLEditar = new javax.swing.JButton();
        botonVer = new javax.swing.JButton();
        botonAtras = new javax.swing.JButton();
        botonLEditar1 = new javax.swing.JButton();
        indiceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 254, 233));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jList1.setBackground(new java.awt.Color(255, 254, 223));
        jList1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jList1.setFont(new java.awt.Font("Victorian Parlor Vintage Italic", 0, 24)); // NOI18N
        jList1.setForeground(new java.awt.Color(48, 23, 81));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionBackground(new java.awt.Color(252, 167, 46));
        jList1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 520, 690));

        botonLEditar.setBackground(new java.awt.Color(252, 167, 46));
        botonLEditar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLEditar.setForeground(new java.awt.Color(255, 255, 255));
        botonLEditar.setText("Borrar");
        botonLEditar.setBorderPainted(false);
        jPanel1.add(botonLEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 990, 110, 50));

        botonVer.setBackground(new java.awt.Color(252, 167, 46));
        botonVer.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonVer.setForeground(new java.awt.Color(255, 255, 255));
        botonVer.setText("Ver");
        botonVer.setBorderPainted(false);
        botonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerActionPerformed(evt);
            }
        });
        jPanel1.add(botonVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 990, 120, 50));

        botonAtras.setBackground(new java.awt.Color(255, 254, 223));
        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FLECHA.png"))); // NOI18N
        botonAtras.setBorderPainted(false);
        botonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 990, -1, -1));

        botonLEditar1.setBackground(new java.awt.Color(252, 167, 46));
        botonLEditar1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLEditar1.setForeground(new java.awt.Color(255, 255, 255));
        botonLEditar1.setText("Editar");
        botonLEditar1.setBorderPainted(false);
        jPanel1.add(botonLEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 990, 110, 50));

        indiceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/indice.png"))); // NOI18N
        jPanel1.add(indiceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerActionPerformed
        
        
        cargarRecetas();
    }//GEN-LAST:event_botonVerActionPerformed

    private void cargarRecetas(){
        RecetaJpaController controladorReceta= new RecetaJpaController(Miscelanea.getEntityManager());
        listaRecetas=controladorReceta.findRecetaEntities();
        String [] listaNombresRecetas=listaRecetas.stream().map((t) -> t.getNombreReceta()).toList().toArray(new String [listaRecetas.size()]);
        jList1.setListData(listaNombresRecetas);
    }
    
    
    
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
            java.util.logging.Logger.getLogger(PaginaLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonLEditar;
    private javax.swing.JButton botonLEditar1;
    private javax.swing.JButton botonVer;
    private javax.swing.JLabel indiceLabel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}