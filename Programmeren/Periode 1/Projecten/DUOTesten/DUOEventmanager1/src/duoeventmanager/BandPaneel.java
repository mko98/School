/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoeventmanager;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author quocsyluong
 */
public class BandPaneel extends JPanel{
    private JPanel paneelVV, paneelInfo, paneelKnop;
    private JLabel bandID, bandNaam, bandBeschrijving;
    private JTextField bandIDVak, bandNaamVak, bandBeschrijvingVak;
    private JButton vorigeKnop, volgendeKnop, toevoegenKnop, wijzigenKnop, verwijderKnop;
        public BandPaneel(){            
            setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
            Border border = BorderFactory.createEmptyBorder( 5, 10, 5, 10 );
            setBorder( border );
            
            vorigeKnop = new JButton( "\u2190" );
            volgendeKnop = new JButton( "\u2192" );
            
            paneelVV = new JPanel();
            paneelVV.setLayout( new BoxLayout( paneelVV, BoxLayout.X_AXIS ) );
            
            paneelVV.add( vorigeKnop );
            paneelVV.add( volgendeKnop );

            bandID = new JLabel( "Band ID" );
            bandNaam = new JLabel( "Band naam" );
            bandBeschrijving = new JLabel( "Beschrijving" );
            
            bandIDVak = new JTextField( 10 );
            bandNaamVak = new JTextField( 20 );
            bandBeschrijvingVak = new JTextField( 20 );
            
            paneelInfo = new JPanel();
            paneelInfo.setLayout( new GridLayout( 3,2 ) );
            
            paneelInfo.add( bandID );
            paneelInfo.add( bandIDVak);
            paneelInfo.add( bandNaam );
            paneelInfo.add( bandNaamVak );
            paneelInfo.add( bandBeschrijving );
            paneelInfo.add( bandBeschrijvingVak );
            
            toevoegenKnop = new JButton( "Toevoegen" );
            // toevoegenKnop.addActionListener( new ItemToevoegen() );
            
            wijzigenKnop = new JButton( "Wijzigen" );
            // wijzigenKnop.addActionListener( new ItemWijzigen() );
            
            verwijderKnop = new JButton( "Verwijderen" );
            // verwijderKnop.addActionListener( new ItemVerwijderen() );
            
            paneelKnop = new JPanel();          
            paneelKnop.setLayout( new BoxLayout( paneelKnop, BoxLayout.X_AXIS ) );
            
            paneelKnop.add( toevoegenKnop );
            paneelKnop.add( wijzigenKnop );
            paneelKnop.add( verwijderKnop );

            add( paneelVV );
            add( paneelInfo );
            add( paneelKnop );                      
        }
}