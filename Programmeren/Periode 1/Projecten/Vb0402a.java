// Voorbeeld 0402  Tekstvak-event
// Invoer van bedrag exclusief BTW
// Uitvoer van bedrag inclusief BTW 
// Bron: Broncode voor boek: 27573_ADSMJava4BroncodeVoorbeelden
// knop met handler toegevoed 

package vb0402a;

// Venster met knop 

import javax.swing.*;
import java.awt.event.*;  
   
public class Vb0402a extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Vb0402a();
    frame.setSize( 400, 200 );
    frame.setLocation(600, 400);    //added 
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Voorbeeld 0402a" );
    frame.setContentPane( new BTWPaneel() );
    frame.setVisible( true );
  }
}

// Het paneel 
class BTWPaneel extends JPanel {
  private JTextField invoerVak, uitvoerVak;
  private JLabel invoerLabel, uitvoerLabel;
  private JButton knopBTW;

  private double percentageBTW = 21.0;

  public BTWPaneel() {
    // Maak de tekstvakken
    invoerVak = new JTextField( 10 );
    // de volgende regel komt later
    // invoerVak.addActionListener( new InvoerVakHandler() );

    uitvoerVak = new JTextField( 10 );
    
    // Maak de labels
    invoerLabel = new JLabel( "Prijs zonder btw" );
    uitvoerLabel = new JLabel( "Prijs met btw" );
    
    //maak knop 
    knopBTW = new JButton( "Plus " + percentageBTW + "% btw" );
    knopBTW.addActionListener( new KnopBTWHandler() );

    // Voeg alles toe aan het paneel
    add( invoerLabel);
    add( invoerVak );
    add(knopBTW); 
    add( uitvoerLabel );
    add( uitvoerVak );
  }

  class KnopBTWHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = invoerVak.getText();
      double invoerGetal = Double.parseDouble( invoer );

      double uitvoerGetal = (1 + percentageBTW/100 ) * invoerGetal;
      uitvoerVak.setText( "" + uitvoerGetal );
    }
  }

  // voorbereiding voor later 
  class InvoerVakHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = invoerVak.getText();
      double invoerGetal = Double.parseDouble( invoer );

      double uitvoerGetal = (1 + percentageBTW/100 ) * invoerGetal;
      uitvoerVak.setText( "" + uitvoerGetal );
    }
  }
}
