/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcr_labo01_observeurobserve;

/**
 *
 * @author james
 */

import java.util.Timer;

public class Time implements Subject{
    private Timer t;
    
    public Time(){
        t = new Timer();
    }
    
    public void start(){
        
    }
    
    public void stop(){
        
    }
    
    public void reset(){
        
    }
    
    public Timer getTime() {
        return t;
    }
    
    public void attach(Observer o){
        
    }
    
    public void detach(Observer o){
        
    }
    
    public void notifyObserver(){
        
    }
    
    public String toString(){
        return "hello";
    }
}
