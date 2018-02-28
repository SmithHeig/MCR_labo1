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

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Math.*;

public class ClockMechanic extends Clock{
    Image clock;
    final int PREFERED_SIZE = 300;
    public ClockMechanic(Time t, String img){
        super(t);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        
        clock = Toolkit.getDefaultToolkit().getImage(img);
        
        clock = clock.getScaledInstance(PREFERED_SIZE, PREFERED_SIZE, 0);
        this.add(new JLabel(new ImageIcon(clock)));
        this.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cornerX = (this.getWidth() - PREFERED_SIZE) /2;
        int cornerY = (this.getHeight() - PREFERED_SIZE) /2;
        g.drawImage(clock, cornerX, cornerY, this);
        drawNeedles(g);
    }
    
    private void drawNeedles(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Line2D seconds = createNeedle(45, 10, PREFERED_SIZE, Color.RED);
        g2.draw(seconds);
    }
    
    /** time give in 60 quarter (for hours: hours * 6) **/
    private Line2D createNeedle(double time, int thickness, int size, Color color){
        
        double startX = this.getWidth()/2;
        double startY = this.getHeight()/ 2;
        double angle = Math.toRadians(time * 6);
        double endX = startX + (size * Math.sin(angle));
        double endY = startY - (size * Math.cos(angle));
        
        Line2D lin = new Line2D.Double(startX, startY, endX, endY);
        return lin;
    }
}
