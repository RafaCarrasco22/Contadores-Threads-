/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import hilos.Semaforo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Rafael
 */
public class PrincipalFrame extends JFrame{
    
    private ProgressBar[] pnlProgressBar;
    private Semaforo sem;
    private LblPnl pnl;
    private Integer wait;
    
    public PrincipalFrame(){
        super("Contador con Threads");
        super.setSize(new Dimension(450,400));
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBackground(Color.GRAY);
        
        pnl = new LblPnl();
        pnl.setListener(new ListenerLbl() {
            @Override
            public void onBtnClick() {
                try {
                    Integer n = Integer.valueOf(pnl.getTxtHilos().getText());
                    sem = new Semaforo(n);
                    pnlProgressBar = new ProgressBar[n];
                    Integer lim = Integer.valueOf(pnl.getTxtLimSup().getText());
                    Random random = new Random();
                            
                    for(int i=0; i<n;i++){
                        wait = random.nextInt(lim)+1;
                        pnlProgressBar[i] = new ProgressBar(sem, n, i, wait);
                        PrincipalFrame.this.add(pnlProgressBar[i]);
                    }
                    
                    Imagen desen = new Imagen("/img/reset.png");
                    desen.setPreferredSize(new Dimension(100,40));
                    desen.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            pnl.reset();
                            for(int i=0; i<n; i++){
                                pnlProgressBar[i].reset();
                                pnlProgressBar[i].setVisible(false);
                            }
                            desen.setVisible(false);
                        }
                    });
                    
                    PrincipalFrame.this.add(desen);
                    PrincipalFrame.this.setVisible(true);

                } catch (Exception e) {
                }
            }
        });
        
        
        pnl.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
                BorderFactory.createBevelBorder(BevelBorder.RAISED)));
        super.add(pnl,BorderLayout.EAST);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

}
