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
    final double SECONDE_NEEDLE_THICKNESS = 2;
    final double MINUTE_NEEDLE_THICKNESS = 3;
    final double HOUR_NEEDLE_THICKNESS = 5;
    final double SECONDE_NEEDLE_SIZE = ((double)PREFERED_SIZE/2) * 0.7;
    final double MINUTE_NEEDLE_SIZE = ((double)PREFERED_SIZE/2) * 0.5;
    final double HOUR_NEEDLE_SIZE = ((double)PREFERED_SIZE/2) *0.3;
    
    public ClockMechanic(Time t, String img){
        super(t);
        clock = Toolkit.getDefaultToolkit().getImage(img);
        clock = clock.getScaledInstance(PREFERED_SIZE, PREFERED_SIZE, 0);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setPreferredSize(new Dimension(300, 300));
        g.drawImage(clock, 0, 0, this);
        drawNeedles(g);
    }
    
    private void drawNeedles(Graphics g){
        System.out.println(SECONDE_NEEDLE_SIZE + " " + MINUTE_NEEDLE_SIZE + " " + HOUR_NEEDLE_SIZE);
        drawNeedle(g, t.getSeconds(), SECONDE_NEEDLE_THICKNESS, SECONDE_NEEDLE_SIZE, Color.RED);
        drawNeedle(g, t.getMinutes(), MINUTE_NEEDLE_THICKNESS, MINUTE_NEEDLE_SIZE, Color.BLUE);
        drawNeedle(g, t.getHours(), HOUR_NEEDLE_THICKNESS, HOUR_NEEDLE_SIZE, Color.BLACK);
    }
    
    /** time give in 60 quarter (for hours: hours * 6) **/
    private void drawNeedle(Graphics g, double time, double thickness, double size, Color color){
        Graphics2D g2 = (Graphics2D) g;
        double startX = this.getWidth()/2;
        double startY = this.getHeight()/ 2;
        double angle = Math.toRadians(time * 6);
        double endX = startX + (size * Math.sin(angle));
        double endY = startY - (size * Math.cos(angle));
        
        Line2D lin = new Line2D.Double(startX, startY, endX, endY);
        g2.setColor(color);
        g2.setStroke(new BasicStroke((float)thickness));
        g2.draw(lin);
    }
    
    public void update(){
        repaint();
    }
}
