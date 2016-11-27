/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author quocsyluong
 */
public class BandPaneel extends JPanel{
    
    // Declareren van label, tekstvakken, knoppen en andere klasses
    private JPanel paneelVV, paneelInfo, paneelKnop;
    private JLabel bandID, bandNaam, bandBeschrijving;
    private JTextField bandIDVak, bandNaamVak, bandBeschrijvingVak;
    private JButton vorigeKnop, volgendeKnop, toevoegenKnop, wijzigenKnop, verwijderKnop;
    BandDAO bandDAO;    // Declareren van de BandDAO klasse
    Band aBand;         // Declareren van de Band klasse
    
        public BandPaneel(){
            // Initialiseren van de BandDAO klasse
            bandDAO = new BandDAO();
       
            // BoxLayout om de panel in drie verschillende vakken in te delen
            setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
            Border border = BorderFactory.createEmptyBorder( 5, 10, 5, 10 );
            setBorder( border );
                        
            // Paneel voor volgende en vorige knop
            vorigeKnop = new JButton( "\u2190" );
            volgendeKnop = new JButton( "\u2192" );
            volgendeKnop.addActionListener( new volgendeBand() );
            paneelVV = new JPanel();
            paneelVV.setLayout( new BoxLayout( paneelVV, BoxLayout.X_AXIS ) );
            paneelVV.add( vorigeKnop );
            paneelVV.add( volgendeKnop );
            
            // Paneel voor de label en tekstvelden voor BandID, BandNaam en beschrijving
            
            // De labels
            bandID = new JLabel( "Band ID" );
            bandNaam = new JLabel( "Band naam" );
            bandBeschrijving = new JLabel( "Beschrijving" );
            
            // De tekstvakken
            bandIDVak = new JTextField( 10 );
            bandNaamVak = new JTextField( 20 );
            bandBeschrijvingVak = new JTextField( 20 );
            
            // Band klasse initialiseren  
            aBand = new Band();
            
            bandIDVak.setText("" + aBand.getBandID());
            bandNaamVak.setText(aBand.getNaam());
            bandBeschrijvingVak.setText(aBand.getBeschrijving());
            
            // Band info paneel
            paneelInfo = new JPanel();
            paneelInfo.setLayout( new GridLayout( 3,2 ) );
            paneelInfo.add( bandID );
            paneelInfo.add( bandIDVak);
            paneelInfo.add( bandNaam );
            paneelInfo.add( bandNaamVak );
            paneelInfo.add( bandBeschrijving );
            paneelInfo.add( bandBeschrijvingVak );  

            // Paneel om toe te voegen, wijzigen of verwijderen
            toevoegenKnop = new JButton( "Toevoegen" );
            // toevoegenKnop.addActionListener( new ItemToevoegen() );
            wijzigenKnop = new JButton( "Wijzigen" );
            // wijzigenKnop.addActionListener( new ItemWijzigen() );
            verwijderKnop = new JButton( "Verwijderen" );
            // verwijderKnop.addActionListener( new ItemVerwijderen() );
           
            bandDAO.bandAanmaken(aBand);
            bandDAO.bandWijzigen(aBand);
            bandDAO.bandVerwijderen(aBand);
            
            paneelKnop = new JPanel();          
            paneelKnop.setLayout( new BoxLayout( paneelKnop, BoxLayout.X_AXIS ) );
            paneelKnop.add( toevoegenKnop );
            paneelKnop.add( wijzigenKnop );
            paneelKnop.add( verwijderKnop );
            
            // Toevoegen aan de Band paneel
            add( paneelVV );
            add( paneelInfo );
            add( paneelKnop );
        }
        class volgendeBand implements ActionListener{
            public void actionPerformed( ActionEvent e ){
                Band aBand = bandDAO.volgendeBand();                
            }
        }
}