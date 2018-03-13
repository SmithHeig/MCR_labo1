/**
 * @author James Smith et Jeremie Chatillon
 * @file ClockNumeric.java
 * @date 13.03.2018
 */

package mcr_labo01_observeurobserve;

import javax.swing.JLabel;

/**
 * @Class ClockNumeric
 * @author james
 * Represente une Horloge numérique
 */
public class ClockNumeric extends Clock{
    private JLabel time;
    
    /**
     * Constructeur
     * @param t temps sur lequel l'horloge sera basé
     */
    public ClockNumeric(Time t){
        super(t);
        time = new JLabel(t.toString());
        this.add(time);
    }
    
    /**
     * Mise à jour du temps de l'horloge
     */
    @Override
    public void update(){
        time.setText(t.toString());
    }
    
}
