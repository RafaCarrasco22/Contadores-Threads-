/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import hilos.Contador;
import hilos.Semaforo;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Rafael
 */
public class ProgressBar extends JPanel{
    
    private Semaforo oS;
    private JProgressBar pg;
    private Contador cont;
    private Integer posicion;
    
    public ProgressBar(Semaforo sem, Integer th, Integer posicion, Integer descanso){ 
        super.setLayout(new FlowLayout());
        this.posicion = posicion;
        Font fuente = new Font("Monospaced", Font.PLAIN, 15);
        
        oS = sem;
        
        pg = new JProgressBar(0,100);    
        pg.setPreferredSize(new Dimension(400,30));
        pg.setValue(0);    
        pg.setStringPainted(true);    
        
        String contenido = String.valueOf(descanso);
        contenido = contenido.concat("s");
        JLabel lblVelocidad = new JLabel(contenido);
        lblVelocidad.setFont(fuente);
        
        
        super.add(lblVelocidad);
        super.add(pg);
        
        cont = new Contador(sem, pg, posicion, descanso);
        cont.start();
    
    }    
    
    public void reset(){
        try {
            this.cont.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
