/**
 * @author James Smith et Jeremie Chatillon
 * @file Time.java
 * @date 13.03.2018
 */

package mcr_labo01_observeurobserve;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class representant le chronomètre (temps des horloges)
 */
public class Time implements Subject{
    /** Constante **/
    private final int SECOND = 1000; // une seconde est 1000 millisecondes
    
    /* Variable */
    private Timer t;
    private boolean run;
    private TimerTask tt;
    /** Data du timer */
    private int seconds;
    private int minutes;
    private int hours;
    /* observer */
    private LinkedList<Observer> observers;
    
    /**
     * Constructeur
     */
    public Time(){
        t = new Timer();
        observers = new LinkedList<Observer>();
        reset();
        run = false;
    }
    
    /**
     * Mise en route du timer (chronomètre)
     */
    public void start(){
        if(!run){
            run = true;
            tt = new TimerTask() {
                @Override
                public void run(){
                    increments();
                };
            };
            t.scheduleAtFixedRate(tt, SECOND,SECOND);
        }
    }
    
    /**
     * Arrêt du timer (chronomètre)
     */
    public void stop(){
        if(run){
            run = false;
            tt.cancel();
        }
    }
    
    /** 
     * Remise à 0 du timer (chronomètre)
     */
    public void reset(){
        this.stop();
        seconds = 0;
        minutes = 0;
        hours = 0;
        
        notifyObserver();;
    }
    
    /**
     * Permet d'attacher un observeur au sujet
     * @param o Observer à attacher
     */
    public void attach(Observer o){
        observers.add(o);
    }
    /*
     * Detache un observer du sujet
     * @param o Observer à détacher
     */
    public void detach(Observer o){
        observers.remove(o);
    }
    
    /**
     * Notifie tous les observers de s'updater vers lui
     */
    public void notifyObserver(){
        for(Observer o: observers){
            o.update();
        }
    }
    
    /**
     * Affichage du temps
     * @return le temps en format string
     */
    public String toString(){
        return getHours() + "h " + getMinutes() + "m " + getSeconds() + "s";
    }
    
    /**
     * @return nombre de secondes actueles du timer (chronomètre)
     */
    public int getSeconds(){
        return seconds;
    }
    
    /**
     * @return nombre de minutes du timer (chronomètre)
     */
    public int getMinutes(){
        return minutes;
    }
    
    /**
     * @return nombre d'heure du timer (chronomètre
     */
    public int getHours(){
        return hours;
    }
    
    /**
     * Incrémentation du temps de une seconde
     */
    private void increments(){
        if(++seconds >= 60){
            if(++minutes >= 60){
                ++hours;
                minutes = 0;
            }
            seconds = 0;
        }
        notifyObserver();
    }
    
    /**
     * @return true si le timer est en route
     */
    public boolean isRunning(){
        return run;
    }
}
