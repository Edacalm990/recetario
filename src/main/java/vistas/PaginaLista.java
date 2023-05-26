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
import entidades.CantidadPK;
import entidades.Ingrediente;
import entidades.Receta;
import entidades.Usuario;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import recetario.Recetario;

/**
 *
 * @author venganzaalchocolate
 */
public class PaginaLista extends javax.swing.JFrame {

    private List<Receta> listaRecetas;
    RecetaJpaController controladorReceta = new RecetaJpaController(Miscelanea.getEntityManager());
    UsuarioJpaController controladorUsuario = new UsuarioJpaController(Miscelanea.getEntityManager());
    CantidadJpaController controladorCantidad = new CantidadJpaController(Miscelanea.getEntityManager());
    IngredienteJpaController controladorIngrediente = new IngredienteJpaController(Miscelanea.getEntityManager());
    public static List<Ingrediente> listaIngredientes = new ArrayList<>();
    public static List<Integer> listaCantidades = new ArrayList<>();

    /**
     * Creates new form PaginaLista
     */
    public PaginaLista() {

        listaRecetas = new ArrayList<>();
        initComponents();
        panelVerReceta.setVisible(false);
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
        panelIndice = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        botonAtras = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonCrear1 = new javax.swing.JButton();
        botonLEditar1 = new javax.swing.JButton();
        ver = new javax.swing.JButton();
        panelVerReceta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        botonDeleteI = new javax.swing.JButton();
        botonAddI = new javax.swing.JButton();
        botonCrear2 = new javax.swing.JButton();
        botonLEditar2 = new javax.swing.JButton();
        jLabelReceta = new javax.swing.JLabel();
        jLabelCreaReceta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelEditaReceta = new javax.swing.JLabel();
        indiceLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelIndice.setBackground(new java.awt.Color(255, 254, 233));
        panelIndice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));

        jList1.setBackground(new java.awt.Color(238, 244, 238));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jList1.setFont(new java.awt.Font("Victorian Parlor Vintage Italic", 0, 36)); // NOI18N
        jList1.setForeground(new java.awt.Color(48, 23, 81));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionBackground(new java.awt.Color(252, 167, 46));
        jList1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        panelIndice.setViewportView(jList1);

        jPanel1.add(panelIndice, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 480, 580));

        botonAtras.setBackground(new java.awt.Color(238, 244, 238));
        botonAtras.setForeground(new java.awt.Color(238, 244, 238));
        botonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FLECHA.png"))); // NOI18N
        botonAtras.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonAtras.setBorderPainted(false);
        botonAtras.setContentAreaFilled(false);
        botonAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 880, -1, -1));

        botonBorrar.setBackground(new java.awt.Color(252, 167, 46));
        botonBorrar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonBorrar.setForeground(new java.awt.Color(255, 255, 255));
        botonBorrar.setText("-");
        botonBorrar.setBorderPainted(false);
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(botonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 880, 60, 50));

        botonCrear1.setBackground(new java.awt.Color(179, 57, 170));
        botonCrear1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonCrear1.setForeground(new java.awt.Color(255, 255, 255));
        botonCrear1.setText("+");
        botonCrear1.setBorderPainted(false);
        botonCrear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrear1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonCrear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 880, 60, 50));

        botonLEditar1.setBackground(new java.awt.Color(252, 167, 46));
        botonLEditar1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLEditar1.setForeground(new java.awt.Color(255, 255, 255));
        botonLEditar1.setText("Editar");
        botonLEditar1.setBorderPainted(false);
        botonLEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLEditar1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonLEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 880, 110, 50));

        ver.setBackground(new java.awt.Color(252, 167, 46));
        ver.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        ver.setForeground(new java.awt.Color(255, 255, 255));
        ver.setText("Ver");
        ver.setBorderPainted(false);
        ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verActionPerformed(evt);
            }
        });
        jPanel1.add(ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 880, 70, 50));

        panelVerReceta.setOpaque(false);
        panelVerReceta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jScrollPane2.setForeground(new java.awt.Color(0, 102, 153));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(238, 244, 238));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 102, 153));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        panelVerReceta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, 490, 350));

        jScrollPane3.setBackground(new java.awt.Color(238, 244, 238));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jScrollPane3.setForeground(new java.awt.Color(0, 102, 153));

        jList3.setBackground(new java.awt.Color(238, 244, 238));
        jList3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jList3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jList3.setForeground(new java.awt.Color(0, 102, 153));
        jList3.setSelectionForeground(new java.awt.Color(238, 244, 238));
        jScrollPane3.setViewportView(jList3);

        panelVerReceta.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 50, 160));

        jScrollPane1.setBackground(new java.awt.Color(238, 244, 238));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jScrollPane1.setForeground(new java.awt.Color(0, 102, 153));

        jList2.setBackground(new java.awt.Color(238, 244, 238));
        jList2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jList2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jList2.setForeground(new java.awt.Color(0, 102, 153));
        jList2.setSelectionForeground(new java.awt.Color(238, 244, 238));
        jScrollPane1.setViewportView(jList2);

        panelVerReceta.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 400, 170));

        jTextField1.setBackground(new java.awt.Color(238, 244, 238));
        jTextField1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 102, 153));
        jTextField1.setText("jTextField1");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 244, 238)));
        jTextField1.setCaretColor(new java.awt.Color(238, 244, 238));
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 102, 153));
        jTextField1.setFocusable(false);
        jTextField1.setOpaque(true);
        jTextField1.setSelectedTextColor(new java.awt.Color(238, 244, 238));
        jTextField1.setVerifyInputWhenFocusTarget(false);
        panelVerReceta.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 137, 490, 30));

        botonDeleteI.setBackground(new java.awt.Color(252, 167, 46));
        botonDeleteI.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonDeleteI.setForeground(new java.awt.Color(255, 255, 255));
        botonDeleteI.setText("-");
        botonDeleteI.setBorderPainted(false);
        botonDeleteI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeleteIActionPerformed(evt);
            }
        });
        panelVerReceta.add(botonDeleteI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 210, 50, 50));

        botonAddI.setBackground(new java.awt.Color(179, 57, 170));
        botonAddI.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonAddI.setForeground(new java.awt.Color(255, 255, 255));
        botonAddI.setText("+");
        botonAddI.setBorderPainted(false);
        botonAddI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAddIActionPerformed(evt);
            }
        });
        panelVerReceta.add(botonAddI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 210, 50, 50));

        botonCrear2.setBackground(new java.awt.Color(179, 57, 170));
        botonCrear2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonCrear2.setForeground(new java.awt.Color(255, 255, 255));
        botonCrear2.setText("Crear Receta");
        botonCrear2.setBorderPainted(false);
        botonCrear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrear2ActionPerformed(evt);
            }
        });
        panelVerReceta.add(botonCrear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 880, 180, 50));

        botonLEditar2.setBackground(new java.awt.Color(252, 167, 46));
        botonLEditar2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonLEditar2.setForeground(new java.awt.Color(255, 255, 255));
        botonLEditar2.setText("Guardar");
        botonLEditar2.setBorderPainted(false);
        botonLEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLEditar2ActionPerformed(evt);
            }
        });
        panelVerReceta.add(botonLEditar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 880, 130, 50));

        jLabelReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/receta.png"))); // NOI18N
        panelVerReceta.add(jLabelReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 480, 90));

        jLabelCreaReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/creaReceta.png"))); // NOI18N
        panelVerReceta.add(jLabelCreaReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 480, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verReceta2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        panelVerReceta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, -20, 630, 1000));

        jLabelEditaReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editaReceta.png"))); // NOI18N
        panelVerReceta.add(jLabelEditaReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 480, 90));

        jPanel1.add(panelVerReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 980));

        indiceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/indice.png"))); // NOI18N
        jPanel1.add(indiceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 980));

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

    private void verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verActionPerformed
        int index = jList1.getAnchorSelectionIndex();

        botonAddI.setVisible(false);
        botonDeleteI.setVisible(false);
        cargarReceta(index);
    }//GEN-LAST:event_verActionPerformed

    private void cargarReceta(int index) {
        listaCantidades.clear();
        listaIngredientes.clear();
        if (index != -1) {
            Receta receta = listaRecetas.get(index);
            String nombre = receta.getNombreReceta();
            String elaboracion = receta.getElaboracion();
            List<String> ingredientes = receta.getCantidadList().stream().map((t) -> t.getIngrediente().getNombreIngrediente()).toList();
            String[] tmpIngredientes = ingredientes.toArray(new String[ingredientes.size()]);
            List<String> cantidad = receta.getCantidadList().stream().map((t) -> String.valueOf(t.getCantidad())).toList();
            String[] tmpCantidad = cantidad.toArray(new String[cantidad.size()]);

            List<Ingrediente> listaIngreTmp = receta.getCantidadList().stream().map((t) -> t.getIngrediente()).toList();

            for (Ingrediente listaReceta : listaIngreTmp) {
                listaIngredientes.add(listaReceta);
            }

            List<Integer> cantidadTmp = receta.getCantidadList().stream().map((t) -> t.getCantidad()).toList();
            for (int i = 0; i < cantidadTmp.size(); i++) {
                int cantidadI = cantidadTmp.get(i);
                listaCantidades.add(cantidadI);
            }

            jTextField1.setText(nombre);
            jTextArea1.setText(elaboracion);
            actualizarIngredientePanel();

            panelVerReceta.setVisible(true);
            jLabelReceta.setVisible(true);
            botonAddI.setVisible(false);
            botonDeleteI.setVisible(false);
            jTextField1.setFocusable(false);
            jTextArea1.setEditable(false);
            jLabelCreaReceta.setVisible(false);
            jLabelEditaReceta.setVisible(false);
            botonCrear2.setVisible(false);
            botonLEditar2.setVisible(false);
        }
    }

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed

        int index = jList1.getAnchorSelectionIndex();
        if (index != -1
                && JOptionPane.showConfirmDialog(null, "Seguro que deseas borrar la receta %s".formatted(listaRecetas.get(index).getNombreReceta())) == 0) {
            try {
                for (int i = 0; i < listaRecetas.get(index).getCantidadList().size(); i++) {
                    Cantidad get = listaRecetas.get(index).getCantidadList().get(i);
                    controladorCantidad.destroy(get.getCantidadPK());
                }
                controladorReceta.destroy(listaRecetas.get(index).getCodReceta());
                cargarRecetas();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ha podido borrar la receta, %s".formatted(e));
            }
        }
        panelVerReceta.setVisible(false);
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonLEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLEditar1ActionPerformed
        listaCantidades.clear();
        listaIngredientes.clear();
        int index = jList1.getAnchorSelectionIndex();
        if (index != -1) {

            cargarReceta(index);
            botonAddI.setVisible(true);
            botonDeleteI.setVisible(true);
            jTextField1.setFocusable(true);
            jTextArea1.setEditable(true);
            jLabelReceta.setVisible(false);
            jLabelCreaReceta.setVisible(false);
            jLabelEditaReceta.setVisible(true);
            botonLEditar2.setVisible(true);
        }
    }//GEN-LAST:event_botonLEditar1ActionPerformed


    private void botonCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrear1ActionPerformed
        listaCantidades.clear();
        listaIngredientes.clear();
        actualizarIngredientePanel();
        panelVerReceta.setVisible(true);
        jTextField1.setText("Nombre de la receta....");
        jTextArea1.setText("Como se elabora.....");
        jList2.setListData(new String[0]);
        jTextField1.setFocusable(true);
        jTextArea1.setEditable(true);
        botonAddI.setVisible(true);
        botonDeleteI.setVisible(true);
        jLabelReceta.setVisible(false);
        jLabelCreaReceta.setVisible(true);
        jLabelEditaReceta.setVisible(false);
        botonCrear2.setVisible(true);
        botonLEditar2.setVisible(false);

    }//GEN-LAST:event_botonCrear1ActionPerformed

    private void botonDeleteIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDeleteIActionPerformed
        int index = jList2.getAnchorSelectionIndex();
        jList2.setSelectedIndex(-1);
        if (index != -1) {

            listaIngredientes.remove(index);
            listaCantidades.remove(index);

        }
        actualizarIngredientePanel();

    }//GEN-LAST:event_botonDeleteIActionPerformed


    private void botonAddIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAddIActionPerformed
        BuscarIngrediente buscarIngrediente = new BuscarIngrediente(this, "buscaIngrediente");
        buscarIngrediente.pack();
        buscarIngrediente.setLocationRelativeTo(null);
        buscarIngrediente.setVisible(true);
        
    }//GEN-LAST:event_botonAddIActionPerformed

    private void botonCrear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrear2ActionPerformed
        String nombreReceta = jTextField1.getText();
        String elaboracion = jTextArea1.getText();

        if (controladorReceta.findByNombreReceta(nombreReceta) == null && !listaIngredientes.isEmpty()) {
            if (JOptionPane.showConfirmDialog(null, "Seguro que deseas crear la receta %s".formatted(nombreReceta)) == 0) {
                try {
                    Receta receta = new Receta();
                    receta.setNombreReceta(nombreReceta);
                    receta.setElaboracion(elaboracion);
                    // ------------------
                    receta.setCreador(Recetario.usuario);
                    // ------------------
                    controladorReceta.create(receta);

                    crearCantidad(receta);
                    cargarRecetas();
                    cargarReceta(listaRecetas.size() - 1);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se ha podido crear la receta %s".formatted(nombreReceta));
                    System.out.println(e);
                }
            }

        } else if (listaIngredientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede crear una receta sin ingredientes");
        } else {
            JOptionPane.showMessageDialog(null, "El nombre de la receta ya existe, debes poner otro nombre");
        }


    }//GEN-LAST:event_botonCrear2ActionPerformed

    private void crearCantidad(Receta receta) {
        for (int i = 0; i < listaIngredientes.size(); i++) {
            Ingrediente get = listaIngredientes.get(i);
            int cantidad = listaCantidades.get(i);
            try {
                controladorCantidad.create(new Cantidad(get, receta, cantidad));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ha podido crear la lista de Ingredientes");
                System.out.println(e);
            }

        }
        listaCantidades.clear();
        listaIngredientes.clear();
    }

    

    private Ingrediente ingredienteAux(Receta receta) {
        controladorIngrediente.create(new Ingrediente("auxiliar"));
        Ingrediente aux = controladorIngrediente.findByNombreIngrediente("auxiliar");
        try {
            controladorCantidad.create(new Cantidad(aux, receta, 0));
        } catch (Exception e) {
            System.out.println("No se ha podido crear el ingrediente auxiliar");
        }
        return aux;
    }


    private void botonLEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLEditar2ActionPerformed
        int index = jList1.getAnchorSelectionIndex();
        if (index != -1 && !listaIngredientes.isEmpty()) {
            Receta receta = listaRecetas.get(index);
            Receta recetaModificada = new Receta(receta.getCodReceta());
            recetaModificada.setCreador(receta.getCreador());
            recetaModificada.setNombreReceta(jTextField1.getText());
            recetaModificada.setElaboracion(jTextArea1.getText());
            try {
                for (int i = 0; i <receta.getCantidadList().size(); i++) {
                    Cantidad get = receta.getCantidadList().get(i);
                    controladorCantidad.destroy(get.getCantidadPK());
                }
                controladorReceta.destroy(receta.getCodReceta());
            } catch (Exception e) {
                System.out.println("no se ha podido eliminar la receta");
                System.out.println(e);
            }

            try {
                controladorReceta.create(recetaModificada);
                crearCantidad(recetaModificada);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ha podido editar la receta");
                System.out.println(e);
            }
            
            
            cargarRecetas();
            cargarReceta(listaRecetas.size() - 1);
            
      
        } else if (listaIngredientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se puede crear una receta sin ingredientes");
        }
    }//GEN-LAST:event_botonLEditar2ActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        Portada portada = new Portada();
        portada.pack();
        portada.setLocationRelativeTo(null);
        portada.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void cargarRecetas() {
        listaRecetas = controladorReceta.findRecetaEntities();
        String[] listaNombresRecetas = listaRecetas.stream().map((t) -> t.getNombreReceta()).toList().toArray(new String[listaRecetas.size()]);
        jList1.setListData(listaNombresRecetas);
        
    }

    public void childClosed(String windowName, WindowEvent e) {
        actualizarIngredientePanel();
    }

    private void actualizarIngredientePanel() {
        if (!listaIngredientes.isEmpty()) {
            jList2.setListData(listaIngredientes.stream().map((t) -> t.getNombreIngrediente()).toList().toArray(new String[listaIngredientes.size()]));
            jList3.setListData(listaCantidades.stream().map((t) -> String.valueOf(t.intValue())).toList().toArray(new String[listaCantidades.size()]));
        } else {
            jList2.setListData(new String[0]);
            jList3.setListData(new String[0]);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAddI;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCrear1;
    private javax.swing.JButton botonCrear2;
    private javax.swing.JButton botonDeleteI;
    private javax.swing.JButton botonLEditar1;
    private javax.swing.JButton botonLEditar2;
    private javax.swing.JLabel indiceLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCreaReceta;
    private javax.swing.JLabel jLabelEditaReceta;
    private javax.swing.JLabel jLabelReceta;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane panelIndice;
    private javax.swing.JPanel panelVerReceta;
    private javax.swing.JButton ver;
    // End of variables declaration//GEN-END:variables
}
