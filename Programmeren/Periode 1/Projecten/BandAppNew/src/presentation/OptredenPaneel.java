/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import datastorage.OptredenDAO;
import domain.Optreden;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author quocsyluong
 */
public class OptredenPaneel extends JPanel{
    
    private JPanel optredenPaneelInfo, paneelVV, paneelKnop;
    private JLabel optredenIDLabel, optredenBandLabel, optredenPodiumLabel, optredenDatumLabel, optredenBeginLabel, optredenEindLabel;
    private JTextField optredenIDVak, optredenBandVak, optredenPodiumVak, optredenDatumVak, optredenBeginVak, optredenEindVak;
    private JButton optredenToevoegen, optredenVerwijderen, optredenWijzigen, vorigeKnop, volgendeKnop;
    OptredenDAO optredenDAO;
    Optreden aOptreden;
    
    public OptredenPaneel(){
            
            optredenDAO = new OptredenDAO();
            
            // Boxlayout voor panelen
            setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
            Border border = BorderFactory.createEmptyBorder( 5, 10, 5, 10 );
            setBorder( border );        
            
            vorigeKnop = new JButton( "\u2190" );
            vorigeKnop.addActionListener( new vorigeOptreden() );
            volgendeKnop = new JButton( "\u2192" );
            volgendeKnop.addActionListener( new volgendeOptreden() );

            // Paneel vorige- & volgendeknop
            paneelVV = new JPanel();
            paneelVV.setLayout( new BoxLayout( paneelVV, BoxLayout.X_AXIS ) );

            paneelVV.add( vorigeKnop );
            paneelVV.add( volgendeKnop );
            
            // Paneel optreden tekstvakken en labels
            optredenPaneelInfo = new JPanel();
            optredenPaneelInfo.setLayout( new GridLayout( 6,2 ) );
            
            optredenIDLabel = new JLabel( "Optreden ID" );
            optredenBandLabel = new JLabel( "Band" );
            optredenPodiumLabel = new JLabel( "Podium" );
            optredenDatumLabel = new JLabel( "Datum" );
            optredenBeginLabel = new JLabel( "Begintijd" );
            optredenEindLabel = new JLabel( "Eindtijd" );
            
            optredenIDVak = new JTextField( 10 );
            optredenIDVak.setEditable( false );
            optredenBandVak = new JTextField( 20 );
            optredenPodiumVak = new JTextField( 20 );
            optredenDatumVak = new JTextField( 10 );
            optredenBeginVak = new JTextField( 10 );
            optredenEindVak = new JTextField( 10 );
            
            // Toevoegen aan info paneel van optreden
            optredenPaneelInfo.add( optredenIDLabel );
            optredenPaneelInfo.add( optredenIDVak );
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
            
            // Initialiseren van knoppen
            JButton toevoegenKnop = new JButton( "Toevoegen" );
            toevoegenKnop.addActionListener( new OptredenToevoegen() );
            
            JButton wijzigenKnop = new JButton( "Wijzigen" );
            wijzigenKnop.addActionListener( new OptredenWijzigen() );
            
            JButton verwijderKnop = new JButton( "Verwijderen" );
            verwijderKnop.addActionListener( new OptredenVerwijderen() );
            
            // Paneel voor knoppen
            paneelKnop = new JPanel();          
            paneelKnop.setLayout( new BoxLayout( paneelKnop, BoxLayout.X_AXIS ) );
            
            paneelKnop.add( toevoegenKnop );
            paneelKnop.add( wijzigenKnop );
            paneelKnop.add( verwijderKnop );
            
            add( paneelVV );
            add( optredenPaneelInfo );
            add( paneelKnop );
    }
    
    private void setValuesToFields(Optreden aOptreden) {
            optredenIDVak.setText("" + (aOptreden.getOptredenID()));
            optredenBandVak.setText(aOptreden.getOptredenBand());
            optredenPodiumVak.setText(aOptreden.getOptredenPodium());
            optredenDatumVak.setText("" + (aOptreden.getOptredenDatum()));
            optredenBeginVak.setText("" + (aOptreden.getOptredenBeginTijd()));
            optredenEindVak.setText("" + (aOptreden.getOptredenEindTijd()));
    } 
    
    class volgendeOptreden implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Optreden aOptreden = optredenDAO.volgendeOptreden();
            setValuesToFields(aOptreden);
        }
    }
    
    class vorigeOptreden implements ActionListener{
        
        public void actionPerformed( ActionEvent e ){
            Optreden aOptreden = optredenDAO.vorigeOptreden();
            setValuesToFields(aOptreden);
        }
    }

    class OptredenToevoegen implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Optreden aOptreden = new Optreden();  
            String str = optredenIDVak.getText();
                if (!str.equals("")) {
                    aOptreden.setOptredenID(Integer.parseInt(str));
                } 
                else {
                    aOptreden.setOptredenID(optredenDAO.setNieuweID());
                }
                
            String noOBV = optredenBandVak.getText();
            String noOPV = optredenPodiumVak.getText();
            String noODV = optredenDatumVak.getText();
            String noOBT = optredenBeginVak.getText();
            String noOET = optredenEindVak.getText();

                if ((noOBV.equals("")) || (noOPV.equals("")) || (noODV.equals("")) || (noOBT.equals("")) || (noOET.equals(""))){
                    JOptionPane.showMessageDialog(null, "Vul lege veld in");
                }
                else{
                    aOptreden.setOptredenBand(optredenBandVak.getText());
                    aOptreden.setOptredenPodium(optredenPodiumVak.getText());
                    aOptreden.setOptredenDatum(Integer.parseInt(noODV));
                    aOptreden.setOptredenBeginTijd(Integer.parseInt(noOBT));
                    aOptreden.setOptredenEindTijd(Integer.parseInt(noOET));
                    optredenDAO.optredenAanmaken(aOptreden);
                
                    JOptionPane.showMessageDialog(null,"De gegevens zijn toegevoegd" );

                    optredenIDVak.setText("" + aOptreden.getOptredenID());  //int
                    optredenBandVak.setText(aOptreden.getOptredenBand());
                    optredenPodiumVak.setText(aOptreden.getOptredenPodium());
                    optredenDatumVak.setText("" + aOptreden.getOptredenDatum());
                    optredenBeginVak.setText("" + aOptreden.getOptredenBeginTijd());
                    optredenEindVak.setText("" + aOptreden.getOptredenEindTijd());

                }
        }
    }
    // Gegevens van een band wijzigen met waarschuwing schermen
    class OptredenWijzigen implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Optreden aOptreden = new Optreden();  
            
            // Gebruik gemaakt van JOptionPane om de gebruiker te waarschuwen voor het wijzigen van gegevens
            int bevestigKnop = JOptionPane.showConfirmDialog(null, "Wil je het wijzigen?", "Waarschuwing!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (bevestigKnop == JOptionPane.YES_OPTION) {
                    String huidigOptredenID = optredenIDVak.getText();
                    aOptreden.setOptredenID(Integer.parseInt(huidigOptredenID));
                    String wijzigOptredenBand = optredenBandVak.getText();
                    aOptreden.setOptredenBand(wijzigOptredenBand);
                    String wijzigOptredenPodium = optredenPodiumVak.getText();
                    aOptreden.setOptredenPodium(wijzigOptredenPodium);
                    String wijzigOptredenDatum = optredenDatumVak.getText();
                    aOptreden.setOptredenDatum(Integer.parseInt(wijzigOptredenDatum));
                    String wijzigOptredenBeginTijd = optredenBeginVak.getText();
                    aOptreden.setOptredenBeginTijd(Integer.parseInt(wijzigOptredenBeginTijd));
                    String wijzigOptredenEindTijd = optredenEindVak.getText();
                    aOptreden.setOptredenEindTijd(Integer.parseInt(wijzigOptredenEindTijd));
                    optredenDAO.optredenWijzigen(aOptreden);
                    JOptionPane.showMessageDialog(null, "Wijzigingen zijn toegepast");
                } 
                
                else {
                    JOptionPane.showMessageDialog(null, "Geen wijzigingen toegepast");
                }    
        }
    }
    // Bands verwijderen met waarschuwing schermen
    class OptredenVerwijderen implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Optreden aOptreden = new Optreden(); 
            
            int bevestigKnop = JOptionPane.showConfirmDialog(null, "Wil je het verwijderen?", "Waarschuwing!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (bevestigKnop == JOptionPane.YES_OPTION) {
                        String huidigOptredenID = optredenIDVak.getText();
                        aOptreden.setOptredenID(Integer.parseInt(huidigOptredenID));
                        String wijzigOptredenBand = optredenBandVak.getText();
                        aOptreden.setOptredenBand(wijzigOptredenBand);
                        String wijzigOptredenPodium = optredenPodiumVak.getText();
                        aOptreden.setOptredenPodium(wijzigOptredenPodium);
                        String wijzigOptredenDatum = optredenDatumVak.getText();
                        aOptreden.setOptredenDatum(Integer.parseInt(wijzigOptredenDatum));
                        String wijzigOptredenBeginTijd = optredenBeginVak.getText();
                        aOptreden.setOptredenBeginTijd(Integer.parseInt(wijzigOptredenBeginTijd));
                        String wijzigOptredenEindTijd = optredenEindVak.getText();
                        aOptreden.setOptredenEindTijd(Integer.parseInt(wijzigOptredenEindTijd));
                        optredenDAO.optredenVerwijderen(aOptreden);
                        JOptionPane.showMessageDialog(null, "Optreden is verwijderd");
                    }
                
                else{
                    JOptionPane.showMessageDialog(null, "Geen items verwijderd");     
                }
        }
    }
}
