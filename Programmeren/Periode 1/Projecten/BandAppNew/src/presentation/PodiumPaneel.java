/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import datastorage.PodiumDAO;
import domain.Podium;
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
public class PodiumPaneel extends JPanel{
    private JPanel paneelVV, paneelKnop, podiumPaneelInfo;
    private JLabel podiumIDLabel, podiumNaamLabel, podiumBeschrijvingLabel, podiumLocatieLabel;
    private JTextField podiumIDVak, podiumNaamVak, podiumBeschrijvingVak, podiumLocatieVak;
    private JButton podiumToevoegen, podiumVerwijderen, podiumWijzigen, vorigeKnop, volgendeKnop;
    PodiumDAO podiumDAO;
    Podium aPodium;
    
        public PodiumPaneel(){
            
            podiumDAO = new PodiumDAO();
            
            setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
            Border border = BorderFactory.createEmptyBorder( 5, 10, 5, 10 );
            setBorder( border ); 
            
            vorigeKnop = new JButton( "\u2190" );
            vorigeKnop.addActionListener( new vorigePodium() );
            volgendeKnop = new JButton( "\u2192" );
            volgendeKnop.addActionListener( new volgendePodium() );
            
            paneelVV = new JPanel();
            paneelVV.setLayout( new BoxLayout( paneelVV, BoxLayout.X_AXIS ) );

            paneelVV.add( vorigeKnop );
            paneelVV.add( volgendeKnop );
                       
            podiumIDLabel = new JLabel( "Podium ID" );
            podiumNaamLabel = new JLabel( "Podium naam" );
            podiumLocatieLabel = new JLabel( "Locatie" );
            podiumBeschrijvingLabel = new JLabel( "Beschrijving" );

            podiumIDVak = new JTextField( 10 );
            podiumIDVak.setEditable( false );
            podiumNaamVak = new JTextField( 10 );
            podiumLocatieVak = new JTextField( 20 );
            podiumBeschrijvingVak = new JTextField( 50 );
            
            podiumPaneelInfo = new JPanel();
            podiumPaneelInfo.setLayout( new GridLayout( 4,2 ) );
            
            podiumPaneelInfo.add( podiumIDLabel );
            podiumPaneelInfo.add( podiumIDVak );
            podiumPaneelInfo.add( podiumNaamLabel );
            podiumPaneelInfo.add( podiumNaamVak );
            podiumPaneelInfo.add( podiumLocatieLabel );
            podiumPaneelInfo.add( podiumLocatieVak );
            podiumPaneelInfo.add( podiumBeschrijvingLabel );
            podiumPaneelInfo.add( podiumBeschrijvingVak );
            
            podiumToevoegen = new JButton( "Toevoegen" );
            podiumToevoegen.addActionListener( new BandToevoegen() );
            
            podiumWijzigen = new JButton( "Wijzigen" );
            podiumWijzigen.addActionListener( new BandWijzigen() );
            
            podiumVerwijderen = new JButton( "Verwijderen" );
            podiumVerwijderen.addActionListener( new BandVerwijderen() );
            
            paneelKnop = new JPanel();          
            paneelKnop.setLayout( new BoxLayout( paneelKnop, BoxLayout.X_AXIS ) );
            
            paneelKnop.add( podiumToevoegen );
            paneelKnop.add( podiumWijzigen );
            paneelKnop.add( podiumVerwijderen );
            
            add( paneelVV );
            add( podiumPaneelInfo );
            add( paneelKnop );
        }
        private void setValuesToFields(Podium aPodium) {
            podiumIDVak.setText("" + (aPodium.getPodiumID()));
            podiumNaamVak.setText(aPodium.getPodiumNaam());
            podiumLocatieVak.setText(aPodium.getPodiumLocatie());
            podiumBeschrijvingVak.setText(aPodium.getPodiumBeschrijving());
    }
    
    class volgendePodium implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Podium aPodium = podiumDAO.volgendePodium();
            setValuesToFields(aPodium);
        }
    }
    
    class vorigePodium implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Podium aPodium = podiumDAO.vorigePodium();
            setValuesToFields(aPodium);
        }
    }
    class BandToevoegen implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Podium aPodium = new Podium();  
            String str = podiumIDVak.getText();
                if (!str.equals("")) {
                    aPodium.setPodiumID(Integer.parseInt(str));
                } 
                else {
                    aPodium.setPodiumID(podiumDAO.setNieuweID());
                }
            String noPodNa = podiumNaamVak.getText();
            String noPodLo = podiumLocatieVak.getText();
            String noPodBs = podiumBeschrijvingVak.getText();
                if ((noPodNa.equals("")) || (noPodLo.equals("")) || (noPodBs.equals(""))){
                JOptionPane.showMessageDialog(null, "Vul lege veld in");
                }
                else{
                aPodium.setPodiumNaam(podiumNaamVak.getText());
                aPodium.setPodiumLocatie(podiumLocatieVak.getText());
                aPodium.setPodiumBeschrijving(podiumBeschrijvingVak.getText());
                podiumDAO.podiumAanmaken(aPodium);
                
                JOptionPane.showMessageDialog(null,"De gegevens zijn toegevoegd" );
                
                podiumIDVak.setText("" + aPodium.getPodiumID());  //int
                podiumNaamVak.setText(aPodium.getPodiumNaam());
                podiumLocatieVak.setText(aPodium.getPodiumLocatie());
                podiumBeschrijvingVak.setText(aPodium.getPodiumBeschrijving());
                }
        }
    }
    // Gegevens van een band wijzigen met waarschuwing schermen
    class BandWijzigen implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Podium aPodium = new Podium();  
            
            // Gebruik gemaakt van JOptionPane om de gebruiker te waarschuwen voor het wijzigen van gegevens
            int bevestigKnop = JOptionPane.showConfirmDialog(null, "Wil je het wijzigen?", "Waarschuwing!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (bevestigKnop == JOptionPane.YES_OPTION) {
                    String huidigPodiumID = podiumIDVak.getText();
                    aPodium.setPodiumID(Integer.parseInt(huidigPodiumID));
                    String wijzigPodiumNaam = podiumNaamVak.getText();
                    aPodium.setPodiumNaam(wijzigPodiumNaam);
                    String wijzigPodiumLoc = podiumLocatieVak.getText();
                    aPodium.setPodiumLocatie(wijzigPodiumLoc);
                    String wijzigPodiumDesc = podiumBeschrijvingVak.getText();
                    aPodium.setPodiumBeschrijving(wijzigPodiumDesc);
                    podiumDAO.podiumWijzigen(aPodium);
                    JOptionPane.showMessageDialog(null, "Wijzigingen zijn toegepast");
                } 
                
                else {
                    JOptionPane.showMessageDialog(null, "Geen wijzigingen toegepast");
                }    
        }
    }
    // Bands verwijderen met waarschuwing schermen
    class BandVerwijderen implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Podium aPodium = new Podium();  
            int bevestigKnop = JOptionPane.showConfirmDialog(null, "Wil je het verwijderen?", "Waarschuwing!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (bevestigKnop == JOptionPane.YES_OPTION) {
                    String huidigPodiumID = podiumIDVak.getText();
                    aPodium.setPodiumID(Integer.parseInt(huidigPodiumID));
                    String verwijderPodiumNaam = podiumNaamVak.getText();
                    aPodium.setPodiumNaam(verwijderPodiumNaam);
                    String verwijderPodiumLoc = podiumLocatieVak.getText();
                    aPodium.setPodiumLocatie(verwijderPodiumLoc);
                    String verwijderPodiumDesc = podiumBeschrijvingVak.getText();
                    aPodium.setPodiumBeschrijving(verwijderPodiumDesc);
                    podiumDAO.podiumVerwijderen(aPodium);
                    JOptionPane.showMessageDialog(null, "Podium is verwijderd");     
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Geen items verwijderd");     
                }
        }
    }
}