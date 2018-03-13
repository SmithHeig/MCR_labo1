/**
 * @author James Smith et Jeremie Chatillon
 * @file ClockArab.java
 * @date 13.03.2018
 */

package mcr_labo01_observeurobserve;

/**
 * @class ClockArab
 * Horloge mechanic (à aiguille) avec les chiffres arabes.
 */
public class ClockArab extends ClockMechanic{
    
    private static final String PATH_IMG = "./Images/clock1.jpg";
    public ClockArab(Time t){
        super(t, PATH_IMG); 
    }
}
