/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.Backup;
import controladores.CantidadJpaController;
import controladores.IngredienteJpaController;
import controladores.Miscelanea;
import controladores.RecetaJpaController;
import controladores.UsuarioJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Cantidad;
import entidades.Ingrediente;
import entidades.Receta;
import entidades.Usuario;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import recetario.Recetario;

/**
 *
 * @author venganzaalchocolate
 */
public class Portada extends javax.swing.JFrame {

    RecetaJpaController controladorReceta = new RecetaJpaController(Miscelanea.getEntityManager());
    UsuarioJpaController controladorUsuario = new UsuarioJpaController(Miscelanea.getEntityManager());
    CantidadJpaController controladorCantidad = new CantidadJpaController(Miscelanea.getEntityManager());
    IngredienteJpaController controladorIngrediente = new IngredienteJpaController(Miscelanea.getEntityManager());

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

        if (Recetario.usuario.getCodUsuario() != null) {
            PaginaLista recetas = new PaginaLista();
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
        String[] nombres = {"usuario", "ingrediente", "receta", "cantidad"};
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:^.*[0-9]{4}-[0-9]{2}-[0-9]{2}[^.csv]?$");
        Object[] listaPath = Backup.listarTodo("." + File.separator + "backup").filter((t) -> matcher.matches(t)).toList().toArray();
        Object opcion = JOptionPane.showInputDialog(null, "Seleccione una copia de seguridad", "Elegir", JOptionPane.QUESTION_MESSAGE, null, listaPath, listaPath[0]);
       Miscelanea.borrarBBDD();
       
        for (int i = 0; i < nombres.length; i++) {
            List<String[]> lista = Backup.LeerFicherosTexto(opcion.toString() + File.separator + "%s.csv".formatted(nombres[i]));
            
            for (String[] strings : lista) {
                switch (nombres[i]) {
                    case "ingrediente":
                        Ingrediente ingrediente = Miscelanea.convertirListingrediente(strings);
                        controladorIngrediente.create(ingrediente);
                        break;
                    case "usuario":
                        Usuario usuario=Miscelanea.convertirListusuario(strings);
                        controladorUsuario.create(usuario);
                        break;
                    case "receta":
                        Receta receta = Miscelanea.convertirListreceta(strings);
                        controladorReceta.create(receta);
                        break;
                     case "cantidad":
                        Cantidad cantidad = Miscelanea.convertirListcantidad(strings);
                         try {
                             controladorCantidad.create(cantidad);
                         } catch (Exception e) {
                             System.out.println(e);
                         }
                        

                        break;
                    default:
                        System.out.println("nada");
                        ;
                }
            }
        }

    }//GEN-LAST:event_botonLista3ActionPerformed

    private void botonLista4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLista4ActionPerformed

        String fecha = LocalDate.now().toString();
        boolean existeDirectorio = Backup.listarTodo("." + File.separator).anyMatch((t) -> t.startsWith("." + File.separator + "backup"));

        List<Ingrediente> listaIngredientes = controladorIngrediente.findIngredienteEntities();
        List<Receta> listaRecetas = controladorReceta.findRecetaEntities();
        List<Usuario> listaUsuarios = controladorUsuario.findUsuarioEntities();
        List<Cantidad> listaCantidades = controladorCantidad.findCantidadEntities();
        
        for (int i = 0; i < listaIngredientes.size(); i++) {
            Ingrediente get = listaIngredientes.get(i);
            System.out.println(get.toString());
        }
        /*
        La clase java.io.File contiene cuatro variables de separador estático.
        separator: Un String del separador dependiendo de la plataforma. Para Windows, es \ y para Unix es /
        separatorChar: Igual que separator pero nos da un Char
        pathSeparator: Variable dependiente de la plataforma para separadores de ruta. Por ejemplo PATH o CLASSPATH Para Unix es : y para Windows es ; .
        pathSeparatorChar: Igual que pathSeparator pero del tipo char
         */
        // ();
        if (existeDirectorio) {
            boolean creado = Backup.crearDirectorio(".%sbackup.%s%s".formatted(File.separator, File.separator, fecha));
            if (creado) {
                String[] nombres = {"cantidad", "ingrediente", "receta", "usuario"};
                List[] listas = {
                    Backup.tranformarCantidad(listaCantidades),
                    Backup.tranformarListaIngrediente(listaIngredientes),
                    Backup.tranformarListaReceta(listaRecetas),
                    Backup.tranformarListaUsuario(listaUsuarios)};
                for (int i = 0; i < listas.length; i++) {
                    Backup.escribirListaString(listas[i], "%s%s/%s%s".formatted("./backup/", fecha, nombres[i], ".csv"));
                }
            }
        } else {
            Backup.crearDirectorio("./backup");
        }

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
