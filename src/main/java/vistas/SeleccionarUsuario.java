/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.CantidadJpaController;
import controladores.IngredienteJpaController;
import controladores.Miscelanea;
import controladores.RecetaJpaController;
import controladores.UsuarioJpaController;
import entidades.Cantidad;
import entidades.ChildWindow;
import entidades.Ingrediente;
import entidades.Receta;
import entidades.Usuario;
import java.awt.event.WindowEvent;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import recetario.Recetario;

/**
 *
 * @author venganzaalchocolate
 */
public class SeleccionarUsuario extends javax.swing.JFrame {

    UsuarioJpaController controladorUsuario = new UsuarioJpaController(Miscelanea.getEntityManager());
    RecetaJpaController controladorReceta = new RecetaJpaController(Miscelanea.getEntityManager());
    CantidadJpaController controladorCantidad = new CantidadJpaController(Miscelanea.getEntityManager());
    IngredienteJpaController controladorIngrediente = new IngredienteJpaController(Miscelanea.getEntityManager());
    List<Usuario> listaBusqueda;
    List<Receta> listaRecetas;

    /**
     * Creates new form buscarIngrediente
     */
    public SeleccionarUsuario() {
        listaBusqueda = new ArrayList<>();
        listaRecetas = new ArrayList<>();
        initComponents();
        cargarUsuarios();
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
        botonLista1 = new javax.swing.JButton();
        botonLista4 = new javax.swing.JButton();
        botonLista3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(576, 499));
        setPreferredSize(new java.awt.Dimension(576, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(576, 499));

        jPanel1.setMinimumSize(new java.awt.Dimension(576, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(576, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jScrollPane1.setForeground(new java.awt.Color(0, 102, 153));

        jList1.setBackground(new java.awt.Color(238, 244, 238));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jList1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jList1.setForeground(new java.awt.Color(0, 102, 153));
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 230, 270));

        botonLista1.setBackground(new java.awt.Color(179, 57, 170));
        botonLista1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLista1.setForeground(new java.awt.Color(255, 255, 255));
        botonLista1.setText("+");
        botonLista1.setActionCommand("crear");
        botonLista1.setBorderPainted(false);
        botonLista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLista1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 60, 50));

        botonLista4.setBackground(new java.awt.Color(252, 167, 46));
        botonLista4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLista4.setForeground(new java.awt.Color(255, 255, 255));
        botonLista4.setText("-");
        botonLista4.setBorderPainted(false);
        botonLista4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLista4ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLista4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 60, 50));

        botonLista3.setBackground(new java.awt.Color(179, 57, 170));
        botonLista3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLista3.setForeground(new java.awt.Color(255, 255, 255));
        botonLista3.setText("Aceptar");
        botonLista3.setBorderPainted(false);
        botonLista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLista3ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLista3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 130, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seleccionarUsuario.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 510));

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

    private void cargarUsuarios() {
        jList1.setSelectedIndex(-1);
        listaBusqueda = controladorUsuario.findUsuarioEntities();
        String[] listaIngredientesString = listaBusqueda.stream().map((t) -> "%s %s %s".formatted(t.getNombre(), t.getApellido1(), (t.getApellido2() != null) ? t.getApellido2() : "")).toList().toArray(new String[listaBusqueda.size()]);
        jList1.setListData(listaIngredientesString);

    }

    private void botonLista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista3ActionPerformed
        int index = jList1.getAnchorSelectionIndex();
        jList1.setSelectedIndex(-1);
        if (index != -1) {
            try {
                Recetario.usuario = listaBusqueda.get(index);
            } catch ( ArrayIndexOutOfBoundsException e) {
                // TODO TERMINAR
                System.out.println(e);
            }
            
            System.out.println(Recetario.usuario.toString());
            Portada portada = new Portada();
            portada.pack();
            portada.setLocationRelativeTo(null);
            portada.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un usuario");
        }
    }//GEN-LAST:event_botonLista3ActionPerformed

    private void botonLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista1ActionPerformed
        CrearUsuario crearUsuario = new CrearUsuario();
        crearUsuario.pack();
        crearUsuario.setLocationRelativeTo(null);
        crearUsuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonLista1ActionPerformed


    private void botonLista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista4ActionPerformed
        int index = jList1.getAnchorSelectionIndex();
        jList1.setSelectedIndex(-1);
        jList1.clearSelection();
        if (index != -1
                && JOptionPane.showConfirmDialog(null, "Seguro que deseas borrar el usuario %s, esto eliminará todas sus recetas".formatted(listaBusqueda.get(index).getNombre())) == 0) {
            try {
                listaRecetas = controladorReceta.findRecetaEntities();
                List<Receta> recetasCreador = listaRecetas.stream().filter((t) -> t.getCreador().equals(listaBusqueda.get(index))).toList();
                for (Receta receta : recetasCreador) {
                    try {
                        for (int i = 0; i < receta.getCantidadList().size(); i++) {
                            Cantidad get = receta.getCantidadList().get(i);
                            controladorCantidad.destroy(get.getCantidadPK());
                        }
                        controladorReceta.destroy(receta.getCodReceta());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No se ha podido borrar la receta, %s".formatted(e));
                    }
                }
                controladorUsuario.destroy(listaBusqueda.get(index).getCodUsuario());
                cargarUsuarios();
                Recetario.usuario=new Usuario();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ha podido borrar el usuario %s".formatted(e));
            }
        }
    }//GEN-LAST:event_botonLista4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLista1;
    private javax.swing.JButton botonLista3;
    private javax.swing.JButton botonLista4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
