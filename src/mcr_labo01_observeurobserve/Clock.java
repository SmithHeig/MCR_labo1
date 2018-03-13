/**
 * @author James Smith et Jeremie Chatillon
 * @file Clock.java
 * @date 13.03.2018
 */
package mcr_labo01_observeurobserve;

import javax.swing.*;
import java.awt.event.*;

/**
 * @class Clock
 * Class abstrait represantant une horloge
 */
public abstract class Clock  extends JPanel implements Observer{
    //private final GridBagConstraints constraints = new GridBagConstraints();
    protected Time t;
    
    public Clock(Time t){
        super();
        this.t = t;
        this.t.attach(this);
        
        addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if(t.isRunning()){
                        t.stop();
                    } else {
                        t.start();
                    }
                }
            });
    }
    
    /**
     * Destructeur d'une horloge
     * Se détache du timer
     */
    public void finalize(){
        t.detach(this);
    }
    
    /**
     * Fonction pour s'update vers le sujet
     */
    @Override
    public abstract void update();
}
