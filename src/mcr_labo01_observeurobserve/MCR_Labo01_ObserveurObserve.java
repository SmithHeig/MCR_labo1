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
public class MCR_Labo01_ObserveurObserve extends JFrame {

    // Contraintes pour le placement des composants graphiques
    private final GridBagConstraints constraints = new GridBagConstraints();

    private void addButton(String name, int x, int y, Color color, final ActionListener actionListener) {
        JButton b = new JButton(name);
        b.setForeground(color);
        constraints.gridx = x;
        constraints.gridy = y;
        getContentPane().add(b, constraints);

        b.addActionListener(actionListener);
    }

    public MCR_Labo01_ObserveurObserve() {

        super("mcr_labo01_observeurobserve.MCR_Labo01_ObserveurObserve");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        // Contraintes des composants graphiques
        constraints.insets = new Insets(3, 3, 3, 3);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        Time t = new Time();
        
        addButton("Horloge romaine", 0, 0, Color.BLACK, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame fram = new JFrame("Horloge Romaine");
                FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
                fram.setLayout(layout);
                fram.setSize(300,330);

                fram.add(new ClockRomain(t));
                fram.setVisible(true);
            }
        });
        
        addButton("Horloge arabe", 1, 0, Color.BLACK, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame fram = new JFrame("Horloge Arabe");
                fram.setSize(300,330);

                fram.add(new ClockArab(t));
                fram.setVisible(true);
            }
        });
        
        addButton("Horloge numérique", 2, 0, Color.BLACK, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame fram = new JFrame("Horloge Numérique");
                FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
                fram.setLayout(layout);
                fram.setSize(300,330);

                fram.add(new ClockNumeric(t));
                fram.setVisible(true);
            }
        });
        
        addButton("Horloge mixte", 3, 0, Color.BLACK, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame fram = new JFrame("Horloge Mixte");
                FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
                fram.setLayout(layout);
                fram.setSize(300,990);
                
                ClockRomain cr = new ClockRomain(t);
                ClockArab ca = new ClockArab(t);
                ClockNumeric cn = new ClockNumeric(t);
                
                fram.add(cr);
                fram.add(ca);
                fram.add(cn);
                fram.setVisible(true);
            }
        });
        
        addButton("Démarrer", 0, 1, Color.BLACK, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.start();
            }
        });
        
        addButton("Arreter", 1, 1, Color.BLACK, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }
        });
        
        addButton("Réinitialiser", 2, 1, Color.BLACK, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.reset();
            }
        });
        
        addButton("Quitter", 3, 1, Color.BLACK, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        setResizable(false);
        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new MCR_Labo01_ObserveurObserve().setVisible(true);
    }

}
