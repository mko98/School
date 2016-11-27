/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandapp.presentation;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author quocsyluong
 */
public class OptredenPaneel extends JPanel{
    private JPanel optredenPaneelInfo, paneelVV, paneelKnop;
    private JLabel optredenIdLabel, optredenBandLabel, optredenPodiumLabel, optredenDatumLabel, optredenBeginLabel, optredenEindLabel;
    private JTextField optredenIdVak, optredenBandVak, optredenPodiumVak, optredenDatumVak, optredenBeginVak, optredenEindVak;
    private JButton optredenToevoegen, optredenVerwijderen, optredenWijzigen, vorigeKnop, volgendeKnop;
    public OptredenPaneel(){
            setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
            Border border = BorderFactory.createEmptyBorder( 5, 10, 5, 10 );
            setBorder( border );        
            
            vorigeKnop = new JButton( "\u2190" );
            volgendeKnop = new JButton( "\u2192" );
            
            paneelVV = new JPanel();
            paneelVV.setLayout( new BoxLayout( paneelVV, BoxLayout.X_AXIS ) );

            paneelVV.add( vorigeKnop );
            paneelVV.add( volgendeKnop );
            
            optredenPaneelInfo = new JPanel();
            optredenPaneelInfo.setLayout( new GridLayout( 6,2 ) );
            
            optredenIdLabel = new JLabel( "Optreden ID" );
            optredenBandLabel = new JLabel( "Band" );
            optredenPodiumLabel = new JLabel( "Podium" );
            optredenDatumLabel = new JLabel( "Datum" );
            optredenBeginLabel = new JLabel( "Begintijd" );
            optredenEindLabel = new JLabel( "Eindtijd" );
            
            optredenIdVak = new JTextField( 10 );
            optredenBandVak = new JTextField( 10 );
            optredenPodiumVak = new JTextField( 10 );
            optredenDatumVak = new JTextField( 10 );
            optredenBeginVak = new JTextField( 10 );
            optredenEindVak = new JTextField( 10 );
            
            optredenPaneelInfo.add( optredenIdLabel );
            optredenPaneelInfo.add( optredenIdVak );
            optredenPaneelInfo.add( optredenBandLabel );
            optredenPaneelInfo.add( optredenBandVak );
            optredenPaneelInfo.add( optredenPodiumLabel );
            optredenPaneelInfo.add( optredenPodiumVak );
            optredenPaneelInfo.add( optredenDatumLabel );
            optredenPaneelInfo.add( optredenDatumVak );
            optredenPaneelInfo.add( optredenBeginLabel );
            optredenPaneelInfo.add( optredenBeginVak );
            optredenPaneelInfo.add( optredenEindLabel );
            optredenPaneelInfo.add( optredenEindVak );
            
            JButton toevoegenKnop = new JButton( "Toevoegen" );
            // toevoegenKnop.addActionListener( new BandPaneelTest.ItemToevoegen() );
            
            JButton wijzigenKnop = new JButton( "Wijzigen" );
            // wijzigenKnop.addActionListener( new BandPaneelTest.ItemWijzigen() );
            
            JButton verwijderKnop = new JButton( "Verwijderen" );
            // verwijderKnop.addActionListener( new BandPaneelTest.ItemVerwijderen() );
            
            paneelKnop = new JPanel();          
            paneelKnop.setLayout( new BoxLayout( paneelKnop, BoxLayout.X_AXIS ) );
            
            paneelKnop.add( toevoegenKnop );
            paneelKnop.add( wijzigenKnop );
            paneelKnop.add( verwijderKnop );
            
            add( paneelVV );
            add( optredenPaneelInfo );
            add( paneelKnop );
    }
}
