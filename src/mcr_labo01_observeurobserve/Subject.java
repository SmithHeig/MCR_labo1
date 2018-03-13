/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcr_labo01_observeurobserve;

/**
 *
 * @author James Jérémie
 */
public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObserver();
}
