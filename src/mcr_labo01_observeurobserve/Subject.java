/**
 * @author James Smith et Jeremie Chatillon
 * @file Subject.java
 * @date 13.03.2018
 */

package mcr_labo01_observeurobserve;

/**
 * Interface correspondant au sujet dans le modèle sujet - observateur
 */
public interface Subject {
    /**
     * Permet d'attacher un observeur au sujet
     * @param o Observer à attacher
     */
    void attach(Observer o);
    
    /**
     * Detache un observer du sujet
     * @param o Observer à détacher
     */
    void detach(Observer o);
    
    /**
     * Notifie tous les observers de s'updater vers lui
     */
    void notifyObserver();
}
