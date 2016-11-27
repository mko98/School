package oefening0501;

/*
*  Hier staat alle code in één bestand omdat het boek het ook doet! 
*  Maak het eerst de oefening af! 
*  Vrijwillig kun je de ombouw thuis oefenen. 
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;  

//maak een JFrame aan, bepaal de eigenschappen
//maak een JPanel aan en voeg het aan het JFrame toe 
public class Oefening0501basis extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Oefening0501basis();
    frame.setSize( 400, 150 );
    frame.setLocation(500, 500);
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening 0501basis" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

// Het paneel heeft 
// twee invoervakken en één uitvoerLabel
// Er is voorbeeldcode voor één invoervak zonder Event-Handler 

class Paneel extends JPanel {
  private JTextField invoerVakLinks;
  private JTextField invoerVakRechts;
  private JLabel label;
  private double cijferLinks;
  private double cijferRechts;

  
  //maak alle GUI componenten aan en voeg ze aan het JPanel toe
  //gebruik FlowLayout (dus geen nieuwe layout nodig). 
  public Paneel() {
    // Tekst bij de start van het programma
    label = new JLabel("Voer twee getallen in");
    
    // Maak de tekstvakken
    invoerVakLinks = new JTextField( 10 );
    invoerVakRechts = new JTextField(10);
    

    // Maak 1 handler voor beide tekstvakken
   invoerVakLinks.addActionListener(new InvoerVakHandler());
    // Als je in het tekstvak op Enter drukt wordt de handler geactiveerd

    //uitvoerLabel 
    
    // Voeg alles toe aan het paneel
    add( invoerVakLinks);
    add(invoerVakRechts);
    add(label);
    

  }     //eind constructor 

  //Event-Handler - inwendige klasse hier toevoegen 
  class InvoerVakHandler implements ActionListener{
      public void actionPerformed(ActionEvent e){
          String invoer = invoerVakLinks.getText();
          cijferLinks = Double.parseDouble(invoer);
          cijferRechts = Double.parseDouble(invoer);
          
              if (cijferLinks > cijferRechts) {
        System.out.println("Het linker getal is groter");
    } else {
        System.out.println("Het rechter getal is groter");
    } 
}
                      
                      }
  
  
          }
      
  

