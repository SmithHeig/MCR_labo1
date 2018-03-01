/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcr_labo01_observeurobserve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Jeremie
 */
public class Clock  extends JPanel implements Observer{
    //private final GridBagConstraints constraints = new GridBagConstraints();
    protected Time t;
    public Clock(Time t){
        super();
        this.t = t;
        this.t.attach(this);
    }
    
    public void update(){
        /* do nothing */
    }
}
