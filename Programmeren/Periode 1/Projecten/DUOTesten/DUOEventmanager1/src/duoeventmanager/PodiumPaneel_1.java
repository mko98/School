/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoeventmanager;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.Border;
/**
 *
 * @author quocsyluong
 */
public class PodiumPaneel_1 extends JPanel{
    private JPanel paneelVV, paneelKnop, podiumPaneelInfo;
    private JLabel podiumIdLabel, podiumNaamLabel, podiumBeschrijvingLabel, podiumLocatieLabel;
    private JTextField podiumIdVak, podiumNaamVak, podiumBeschrijvingVak, podiumLocatieVak;
    private JButton podiumToevoegen, podiumVerwijderen, podiumWijzigen, vorigeKnop, volgendeKnop;
        public PodiumPaneel_1(){
            setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
            Border border = BorderFactory.createEmptyBorder( 5, 10, 5, 10 );
            setBorder( border ); 
            
            vorigeKnop = new JButton( "\u2190" );
            volgendeKnop = new JButton( "\u2192" );
            
            paneelVV = new JPanel();
            paneelVV.setLayout( new BoxLayout( paneelVV, BoxLayout.X_AXIS ) );

            paneelVV.add( vorigeKnop );
            paneelVV.add( volgendeKnop );
                       
            podiumIdLabel = new JLabel( "Podium ID" );
            podiumNaamLabel = new JLabel( "Podium naam" );
            podiumLocatieLabel = new JLabel( "Locatie" );
            podiumBeschrijvingLabel = new JLabel( "Beschrijving" );

            podiumIdVak = new JTextField( 10 );
            podiumNaamVak = new JTextField( 10 );
            podiumLocatieVak = new JTextField( 20 );
            podiumBeschrijvingVak = new JTextField( 50 );
            
            podiumPaneelInfo = new JPanel();
            podiumPaneelInfo.setLayout( new GridLayout( 4,2 ) );

            podiumPaneelInfo.add( podiumIdLabel );
            podiumPaneelInfo.add( podiumIdVak );
            podiumPaneelInfo.add( podiumNaamLabel );
            podiumPaneelInfo.add( podiumNaamVak );
            podiumPaneelInfo.add( podiumLocatieLabel );
            podiumPaneelInfo.add( podiumLocatieVak );
            podiumPaneelInfo.add( podiumBeschrijvingLabel );
            podiumPaneelInfo.add( podiumBeschrijvingVak );
            
            podiumToevoegen = new JButton( "Toevoegen" );
            // toevoegenKnop.addActionListener( new BandPaneelTest.ItemToevoegen() );
            
            podiumWijzigen = new JButton( "Wijzigen" );
            // wijzigenKnop.addActionListener( new BandPaneelTest.ItemWijzigen() );
            
            podiumVerwijderen = new JButton( "Verwijderen" );
            // verwijderKnop.addActionListener( new BandPaneelTest.ItemVerwijderen() );
            
            paneelKnop = new JPanel();          
            paneelKnop.setLayout( new BoxLayout( paneelKnop, BoxLayout.X_AXIS ) );
            
            paneelKnop.add( podiumToevoegen );
            paneelKnop.add( podiumWijzigen );
            paneelKnop.add( podiumVerwijderen );
            
            add( paneelVV );
            add( podiumPaneelInfo );
            add( paneelKnop );
        }
}
