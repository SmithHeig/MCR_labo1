
package mcr_labo01_observeurobserve;

/**
 *
 * @author james Jérémie
 */

import javax.swing.JLabel;

public class ClockNumeric extends Clock{
    private JLabel time;
    
    
    public ClockNumeric(Time t){
        super(t);
        time = new JLabel(t.toString());
        this.add(time);
    }
    
    
    @Override
    public void update(){
        time.setText(t.toString());
    }
    
}
