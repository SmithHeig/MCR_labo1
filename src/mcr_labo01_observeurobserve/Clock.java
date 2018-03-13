
package mcr_labo01_observeurobserve;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author James Jeremie
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
    
    public void finalize(){
        t.detach(this);
    }
    
    @Override
    public abstract void update();
}
