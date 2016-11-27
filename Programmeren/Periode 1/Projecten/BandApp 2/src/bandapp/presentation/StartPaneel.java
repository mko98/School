/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandapp.presentation;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.GridLayout;
/**
 *
 * @author quocsyluong
 */
public class StartPaneel extends JPanel{
    private JLabel BandLabel, PodiumLabel, OptredenLabel, studentEenNaam, studentTweeNaam, studentEenNr, studentTweeNr, studentEenEmailAdres, studentTweeEmailAdres;
    private JButton BandKnop, PodiumKnop, OptredenKnop;
    private ActionListener bandHandler, podiumHandler, optredenHandler;
        public StartPaneel(){            
            BandLabel = new JLabel( "Band" );
            OptredenLabel = new JLabel( "Optreden" );
            PodiumLabel = new JLabel( "Podium" );
                       
            bandHandler = new BandHandler();
            podiumHandler = new PodiumHandler();
            optredenHandler = new OptredenHandler();
                    
            BandKnop = new JButton( "Bands bekijken" );
            BandKnop.addActionListener( bandHandler );
            PodiumKnop = new JButton( "Podium bekijken" );
            PodiumKnop.addActionListener( podiumHandler );

            OptredenKnop = new JButton( "Optreden bekijken" );
            OptredenKnop.addActionListener( optredenHandler );
            
            studentEenNaam = new JLabel( "QS" );
            studentTweeNaam = new JLabel( "Max");
            
            studentEenNr = new JLabel( "123456" );
            studentTweeNr = new JLabel( "654321" );
            
            studentEenEmailAdres = new JLabel( "emailadres@gmail.com" );
            studentTweeEmailAdres = new JLabel( "adres@gmail.com" );

            setLayout( new GridLayout( 6, 2) );
            Border border = BorderFactory.createEmptyBorder( 10, 10, 10, 10 );
            setBorder( border );
            
            add( BandLabel );
            add( BandKnop );

            add( PodiumLabel );
            add( PodiumKnop );

            add( OptredenLabel );
            add( OptredenKnop );
            
            add( studentEenNaam );
            add( studentTweeNaam );
            
            add( studentEenNr );
            add( studentTweeNr );
            
            add( studentEenEmailAdres );
            add( studentTweeEmailAdres );
            
        }
        class BandHandler implements ActionListener{
            public void actionPerformed( ActionEvent e ){
                new BandGUI();
            }
        }
        class PodiumHandler implements ActionListener{
            public void actionPerformed( ActionEvent e ){
                new PodiumGUI();
            }
        }
        class OptredenHandler implements ActionListener{
            public void actionPerformed( ActionEvent e ){
                new OptredenGUI();
            }
        }
}