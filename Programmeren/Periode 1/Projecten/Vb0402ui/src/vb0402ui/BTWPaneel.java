
package vb0402ui;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

// Het paneel 
public class BTWPaneel extends JPanel {

    private JTextField invoerVak, uitvoerVak;
    private JLabel invoerLabel, uitvoerLabel;
    private JButton knopBTW;

    private double percentageBTW = 21.0;

    public BTWPaneel() {
        // Maak de tekstvakken
        invoerVak = new JTextField(10);
        uitvoerVak = new JTextField(10);

        // Maak de labels
        invoerLabel = new JLabel("Prijs zonder btw");
        uitvoerLabel = new JLabel("Prijs met btw");

        //maak knop met handler 
        knopBTW = new JButton("Plus " + percentageBTW + "% btw");
        knopBTW.addActionListener(new KnopBTWHandler());

        // set LayoutManager and border !! moet voor de eerste add() opdracht !!
        setLayout(new GridLayout(2, 3, 15, 15));
        Border border = BorderFactory.createEmptyBorder(15, 10, 10, 10);
        setBorder(border);

        // Voeg alles toe aan het paneel
        add(invoerLabel);
        add(invoerVak);
        add(knopBTW);
        add(uitvoerLabel);
        add(uitvoerVak);
    }

    //Event-Handler inwendige klasse 
    class KnopBTWHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String invoer = invoerVak.getText();
            double invoerGetal = Double.parseDouble(invoer);
            BTWCalc btwcalc = new BTWCalc();
            //double uitvoerGetal = (1 + percentageBTW / 100) * invoerGetal;
            double uitvoer = btwcalc.berekenBTW(invoerGetal);
            uitvoerVak.setText("" + uitvoer);
        }
    }

}
