/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author Rafael
 */
public class Semaforo {
    
    private Integer h;
    private Integer[] cont;
    private Integer min;
    private Integer max;
    
    public Semaforo(Integer hilos){
        this.h = hilos;
        this.cont = new Integer[hilos];
        this.min = 0;
        this.max = 10;
        for(int i=0; i<hilos;i++){
            cont[i] = 0;
        }
    }
    
    public void ajustarLimites(){
        int aux = 0;
        for(int j=0; j<h; j++){
            if(this.cont[j] == this.max){
                aux++;
            }
        }
        if(aux==h){
            this.min=this.max;
            this.max=this.min+10;
        }
    }
    
    public synchronized boolean permisoAvanzar(Integer i, Integer contador){
        this.ajustarLimites();
        if((contador+1)<=this.max){
            this.cont[i] = contador+1;
            return true;
        }else{
            return false;
        }
        
    }
    
    
}
