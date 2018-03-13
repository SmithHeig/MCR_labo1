/**
 * @author James Smith et Jeremie Chatillon
 * @file ClockMechanic.java
 * @date 13.03.2018
 */

package mcr_labo01_observeurobserve;

import java.awt.*;
import java.awt.geom.*;

/**
 * @class ClockMechanic
 * Class abstrait represantant les horloges mechaniques (à aiguille)
 */
public abstract class ClockMechanic extends Clock{
    private Image clock;
    private final static int PREFERED_SIZE = 300;
    private final static float SECONDE_NEEDLE_THICKNESS = 2;
    private final static float MINUTE_NEEDLE_THICKNESS = 3;
    private final static float HOUR_NEEDLE_THICKNESS = 5;
    private final static double SECONDE_NEEDLE_SIZE_RATIO = 0.4;
    private final static double MINUTE_NEEDLE_SIZE_RATIO = 0.3;
    private final static double HOUR_NEEDLE_SIZE_RATIO = 0.2;
    
    /**
     * Constructeur
     * @param t timer sur lequel l'heure va se baser
     * @param img image de fond
     */
    public ClockMechanic(Time t, String img){
        super(t);
        clock = Toolkit.getDefaultToolkit().getImage(img);
        clock = clock.getScaledInstance(PREFERED_SIZE, PREFERED_SIZE, 0);
        this.setPreferredSize(new Dimension(PREFERED_SIZE, PREFERED_SIZE));
    }
    
    /**
     * Permet l'affichage du composant
     * @param g Graphics sur lequel dessiner
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(clock, 0, 0,this.getWidth(), this.getHeight(), null);
        drawNeedles(g);
        repaint();
    }
    
    /**
     * Dessine les aiguilles de l'horloge
     * @param g Graphics sur lequel dessiner
     */
    private void drawNeedles(Graphics g){
        drawNeedle(g, t.getSeconds(), SECONDE_NEEDLE_THICKNESS, SECONDE_NEEDLE_SIZE_RATIO, Color.RED);
        drawNeedle(g, t.getMinutes(), MINUTE_NEEDLE_THICKNESS, MINUTE_NEEDLE_SIZE_RATIO, Color.BLUE);
        drawNeedle(g, t.getHours() * 5, HOUR_NEEDLE_THICKNESS, HOUR_NEEDLE_SIZE_RATIO, Color.BLACK);
    }
    
    /**
     * Dessine une aiguille
     * @param g Graphics sur lequel dessiner
     * @param time temp permettant de calculé l'angle de l'aiguille. L'heure doit être multiplier par 5 pour être en format de 60
     * @param thickness épaisseur de l'aiguille
     * @param size longueur de l'aiguille
     * @param color couleur de l'aiguille
     */
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
    
    /**
     * Mise à jour de l'horloge
     */
    public void update(){
        repaint();
    }
}
