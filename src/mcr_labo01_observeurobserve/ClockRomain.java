/**
 * @author James Smith et Jeremie Chatillon
 * @file ClockRomain.java
 * @date 13.03.2018
 */

package mcr_labo01_observeurobserve;

/**
 * @class ClockRomain
 * Horloge à aiguille avec les chiffres romains
 */
public class ClockRomain extends ClockMechanic{
    private static final String PATH_IMG = "./Images/clock2.jpg";
    public ClockRomain(Time t){
        super(t, PATH_IMG); 
    }    
}
