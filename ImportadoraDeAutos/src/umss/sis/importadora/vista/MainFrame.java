/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umss.sis.importadora.vista;

import javax.swing.JFrame;

/**
 *
 * @author rodrigo
 */
public class MainFrame extends JFrame {

    private PanelEstadoAsistencia contentPane;

    public MainFrame() {
        contentPane = new PanelEstadoAsistencia();
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
    }
}
