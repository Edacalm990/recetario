/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import vistas.PaginaLista;

/**
 *
 * @author eli
 */
public class ChildWindow extends  javax.swing.JFrame  {
    private PaginaLista mainWindow;
    private String windowName;

    public ChildWindow(PaginaLista mainWindow, String windowName) {

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.mainWindow = mainWindow;
        this.windowName = windowName;

        this.addWindowListener(new WindowListener() {

            public void windowClosed(WindowEvent e) {

                // Cuando la ventana se cierra, notifica a mainWindow
                mainWindow.childClosed(windowName, e);
            }

            @Override
            public void windowOpened(WindowEvent e) {
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                mainWindow.childClosed(windowName, e);
            }

            @Override
            public void windowIconified(WindowEvent e) {
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                
            }

            @Override
            public void windowActivated(WindowEvent e) {
                
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }

        });
    }
}