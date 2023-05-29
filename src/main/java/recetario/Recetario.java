/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package recetario;

import entidades.Usuario;
import javax.swing.JOptionPane;
import vistas.Portada;
import vistas.SeleccionarUsuario;

/**
 *
 * @author venganzaalchocolate
 */
public class Recetario {
    public static Usuario usuario=new Usuario();
    public static void main(String[] args) {
        Portada portada= new Portada();
        portada.pack();
        portada.setLocationRelativeTo(null);
        portada.setVisible(true);

    }
}
