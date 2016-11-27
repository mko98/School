/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import datastorage.BandDAO;
import domain.Band;
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
public class BandPaneel extends JPanel {

    // Declareren van label, tekstvakken, knoppen en andere klasses
    private JPanel paneelVV, paneelInfo, paneelKnop;
    private JLabel bandID, bandNaam, bandBeschrijving;
    private JTextField bandIDVak, bandNaamVak, bandBeschrijvingVak;
    private JButton vorigeKnop, volgendeKnop, toevoegenKnop, wijzigenKnop, verwijderKnop;
    BandDAO bandDAO;    // Declareren van de BandDAO klasse
    Band aBand;         // Declareren van de Band klasse

    public BandPaneel() {
        // Initialiseren van de BandDAO klasse
        bandDAO = new BandDAO();

        // BoxLayout om de panel in drie verschillende vakken in te delen
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Border border = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        setBorder(border);

        // Paneel voor volgende en vorige knop
        vorigeKnop = new JButton("\u2190");
        vorigeKnop.addActionListener(new vorigeBand());
        volgendeKnop = new JButton("\u2192");
        volgendeKnop.addActionListener(new volgendeBand());
        
        // Paneel voor vorige en volgende knop
        paneelVV = new JPanel();
        paneelVV.setLayout(new BoxLayout(paneelVV, BoxLayout.X_AXIS));
        paneelVV.add(vorigeKnop);
        paneelVV.add(volgendeKnop);

        // Paneel voor de label en tekstvelden voor BandID, BandNaam en beschrijving
        // De labels
        bandID = new JLabel("Band ID");
        bandNaam = new JLabel("Band naam");
        bandBeschrijving = new JLabel("Beschrijving");

        // De tekstvakken
        bandIDVak = new JTextField(10);
        bandIDVak.setEditable( false );
        bandNaamVak = new JTextField(20);
        bandBeschrijvingVak = new JTextField(20);

        // Band klasse initialiseren  

        // Band info paneel
        paneelInfo = new JPanel();
        paneelInfo.setLayout(new GridLayout(3, 2));
        paneelInfo.add(bandID);
        paneelInfo.add(bandIDVak);
        paneelInfo.add(bandNaam);
        paneelInfo.add(bandNaamVak);
        paneelInfo.add(bandBeschrijving);
        paneelInfo.add(bandBeschrijvingVak);

        // Paneel om toe te voegen, wijzigen of verwijderen
        toevoegenKnop = new JButton("Toevoegen");
        toevoegenKnop.addActionListener( new BandToevoegen() );
        wijzigenKnop = new JButton("Wijzigen");
        wijzigenKnop.addActionListener( new BandWijzigen() );
        verwijderKnop = new JButton("Verwijderen");
        verwijderKnop.addActionListener( new BandVerwijderen() );
        
        // Paneel voor knoppen
        paneelKnop = new JPanel();
        paneelKnop.setLayout(new BoxLayout(paneelKnop, BoxLayout.X_AXIS));
        paneelKnop.add(toevoegenKnop);
        paneelKnop.add(wijzigenKnop);
        paneelKnop.add(verwijderKnop);

        // Toevoegen aan de (Hoofd) Band paneel
        add(paneelVV);
        add(paneelInfo);
        add(paneelKnop);
    }
    // Gegevens tonen bij het openen van het band venster
    private void setValuesToFields(Band aBand) {
        bandIDVak.setText("" + aBand.getBandID());
        bandNaamVak.setText(aBand.getNaam());
        bandBeschrijvingVak.setText(aBand.getBeschrijving());
    }
    // De band op de volgende index laten zien
    class volgendeBand implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Band aBand = bandDAO.volgendeBand();
            setValuesToFields(aBand);
        }
    }
    // De band op de vorige index laten zien
    class vorigeBand implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Band aBand = bandDAO.vorigeBand();
            setValuesToFields(aBand);
        }
    }
    // Een nieuwe band toevoegen
    class BandToevoegen implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Band aBand = new Band();  
            String str = bandIDVak.getText();
                if (!str.equals("")) {
                    aBand.setBandID(Integer.parseInt(str));
                } 
                else {
                    aBand.setBandID(bandDAO.setNieuweID());
                }
            String noBand = bandNaamVak.getText();
            String noDesc = bandBeschrijvingVak.getText();
                if ((noBand.equals("")) || (noDesc.equals(""))){
                JOptionPane.showMessageDialog(null, "Vul lege veld in");
                }
                else{
                aBand.setNaam(bandNaamVak.getText());
                aBand.setBeschrijving(bandBeschrijvingVak.getText());
                bandDAO.bandAanmaken(aBand);
                
                JOptionPane.showMessageDialog(null,"De gegevens zijn toegevoegd" );
                
                bandIDVak.setText("" + aBand.getBandID());  //int
                bandNaamVak.setText(aBand.getNaam());
                bandBeschrijvingVak.setText(aBand.getBeschrijving());
                }
        }
    }
    // Gegevens van een band wijzigen met waarschuwing schermen
    class BandWijzigen implements ActionListener{
        public void actionPerformed( ActionEvent e ){
            Band aBand = new Band();
            
            // Gebruik gemaakt van JOptionPane om de gebruiker te waarschuwen voor het wijzigen van gegevens
            int bevestigKnop = JOptionPane.showConfirmDialog(null, "Wil je het wijzigen?", "Waarschuwing!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (bevestigKnop == JOptionPane.YES_OPTION) {
                    String huidigID = bandIDVak.getText();
                    aBand.setBandID(Integer.parseInt(huidigID));
                    String wijzigNaam = bandNaamVak.getText();
                    aBand.setNaam(wijzigNaam);
                    String wijzigDesc = bandBeschrijvingVak.getText();
                    aBand.setBeschrijving(wijzigDesc);
                    bandDAO.bandWijzigen(aBand);
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
            Band aBand = new Band();
            int bevestigKnop = JOptionPane.showConfirmDialog(null, "Wil je het verwijderen?", "Waarschuwing!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (bevestigKnop == JOptionPane.YES_OPTION) {
                    String verwijderID = bandIDVak.getText();
                    aBand.setBandID(Integer.parseInt(verwijderID));
                    String verwijderNaam = bandNaamVak.getText();
                    aBand.setNaam(verwijderNaam);
                    String verwijderDesc = bandBeschrijvingVak.getText();
                    aBand.setBeschrijving(verwijderDesc);
                    bandDAO.bandVerwijderen(aBand);
                    JOptionPane.showMessageDialog(null, "Band is verwijderd");     
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Geen items verwijderd");     
                }
        }
    }
}
