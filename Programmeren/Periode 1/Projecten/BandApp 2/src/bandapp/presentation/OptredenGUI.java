/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandapp.presentation;
import javax.swing.*;
/**
 *
 * @author quocsyluong
 */
public class OptredenGUI extends JFrame{
    
    public OptredenGUI(){
        setSize( 400, 400 );
        setTitle( "Band informatie");
        setLocationRelativeTo( null );
        setContentPane( new OptredenPaneel() );
        setVisible( true );
    }
}
