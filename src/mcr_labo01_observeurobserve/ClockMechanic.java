/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcr_labo01_observeurobserve;

/**
 *
 * @author James, Jérémie
 */

import java.awt.*;
import java.awt.geom.*;


public abstract class ClockMechanic extends Clock{
    private Image clock;
    private final static int PREFERED_SIZE = 300;
    private final static float SECONDE_NEEDLE_THICKNESS = 2;
    private final static float MINUTE_NEEDLE_THICKNESS = 3;
    private final static float HOUR_NEEDLE_THICKNESS = 5;
    private final static double SECONDE_NEEDLE_SIZE_RATIO = 0.4;
    private final static double MINUTE_NEEDLE_SIZE_RATIO = 0.3;
    private final static double HOUR_NEEDLE_SIZE_RATIO = 0.2;
    
    public ClockMechanic(Time t, String img){
        super(t);
        clock = Toolkit.getDefaultToolkit().getImage(img);
        clock = clock.getScaledInstance(PREFERED_SIZE, PREFERED_SIZE, 0);
        this.setPreferredSize(new Dimension(PREFERED_SIZE, PREFERED_SIZE));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(clock, 0, 0,this.getWidth(), this.getHeight(), null);
        drawNeedles(g);
        repaint();
    }
    
    private void drawNeedles(Graphics g){
        drawNeedle(g, t.getSeconds(), SECONDE_NEEDLE_THICKNESS, SECONDE_NEEDLE_SIZE_RATIO, Color.RED);
        drawNeedle(g, t.getMinutes(), MINUTE_NEEDLE_THICKNESS, MINUTE_NEEDLE_SIZE_RATIO, Color.BLUE);
        drawNeedle(g, t.getHours() * 5, HOUR_NEEDLE_THICKNESS, HOUR_NEEDLE_SIZE_RATIO, Color.BLACK);
    }
    
    /** time give in 60 quarter (for hours: hours * 6) **/
    private void drawNeedle(Graphics g, double time, float thickness, double size, Color color){
        Graphics2D g2 = (Graphics2D) g;
        double startX = this.getWidth()/2;
        double startY = this.getHeight()/ 2;
        double angle = Math.toRadians(time * 6);
        double endX = startX + ((this.getWidth() *size) * Math.sin(angle));
        double endY = startY - ((this.getHeight() * size) * Math.cos(angle));
        
        Line2D lin = new Line2D.Double(startX, startY, endX, endY);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        g2.draw(lin);
    }
    
    public void update(){
        repaint();
    }
}
