/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Rafael
 */
public class Contador extends Thread{
    private Semaforo sem; 
    private JProgressBar progressBar;
    private Integer descanso;
    private Integer posicion;
    
    
    public Contador(Semaforo s, JProgressBar bar, Integer posicion, Integer descanso){        
        int i=0;
        this.sem = s;
        this.progressBar = bar;
        this.descanso = descanso;
        this.posicion = posicion;     
    }
   
    public void run(){
        Integer i=0;
        while(i<=100){    
            if(this.sem.permisoAvanzar(posicion, i)==true){
                i+=1;             
                progressBar.setValue(i);    
                progressBar.revalidate();
                progressBar.repaint();
                    
                try {
                    Thread.sleep(descanso*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                Thread.yield();
            }
        }   
    }
}
