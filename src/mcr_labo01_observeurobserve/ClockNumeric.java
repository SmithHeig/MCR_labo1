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

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;

public class ClockNumeric extends Clock{
    JLabel time;
    public ClockNumeric(Time t){
        super(t);
        time = new JLabel(t.toString());
        this.add(time);
    }
        
    public void update(){
        time.setText(t.toString());
    }
    
}
