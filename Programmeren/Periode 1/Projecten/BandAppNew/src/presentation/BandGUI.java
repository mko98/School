/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.swing.JFrame;

/**
 *
 * @author quocsyluong
 */
public class BandGUI extends JFrame{
        
    public BandGUI(){
        
        setSize( 400, 250 );
        setTitle( "Band informatie");
        setLocationRelativeTo( null );
        setContentPane( new BandPaneel() );
        setVisible( true );
        
    }
    
}
