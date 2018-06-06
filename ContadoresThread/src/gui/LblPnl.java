/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Rafael
 */
public class LblPnl extends JPanel{
    private JLabel lblHilos;
    private JLabel txt;
    private JTextField txtHilos;
    private JTextField time;
    private ListenerLbl listener;
    
    public LblPnl(){
        this.setLayout(new BoxLayout(LblPnl.this, BoxLayout.Y_AXIS));
         
        JPanel pnlDatos = new JPanel();
        lblHilos = new JLabel("Hilos: ");
        txtHilos = new JTextField();
        txtHilos.setPreferredSize(new Dimension(60,26));
        
        JPanel pnlEspecificaciones = new JPanel();
        pnlEspecificaciones.setLayout(new FlowLayout());
        txt = new JLabel("Tiempo 0 - ");
        time = new JTextField();
        time.setPreferredSize(new Dimension(40,26));
        
        
        pnlEspecificaciones.add(txt);
        pnlEspecificaciones.add(time);
        
       
        Imagen solve = new Imagen("/img/checked.png");
        solve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.onBtnClick();
            }
        });
        
        pnlDatos.add(lblHilos, BorderLayout.EAST);
        pnlDatos.add(txtHilos, BorderLayout.EAST);
        
        super.add(pnlDatos, BorderLayout.EAST);
        super.add(pnlEspecificaciones);
        super.add(solve);
    }
    
    public void setListener(ListenerLbl listener){
        this.listener = listener;
    }

    public JLabel getLblHilos() {
        return lblHilos;
    }

    public void setLblHilos(JLabel lblHilos) {
        this.lblHilos = lblHilos;
    }

    public JTextField getTxtHilos() {
        return txtHilos;
    }

    public void setTxtHilos(JTextField txtHilos) {
        this.txtHilos = txtHilos;
    }
    
    public JTextField getTxtLimSup() {
        return time;
    }

    public void setTxtLimSup(JTextField txtLimSup) {
        this.time = txtLimSup;
    }
    
    public void reset(){
        this.txtHilos.setText("");
        this.time.setText("");
    }
}
