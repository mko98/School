/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoeventmanager;
import javax.swing.*;
/**
 *
 * @author quocsyluong
 */
public class OptredenGUI_1 extends JFrame{
    
    public OptredenGUI_1(){
        setSize( 400, 400 );
        setTitle( "Band informatie");
        setLocationRelativeTo( null );
        setContentPane( new OptredenPaneel() );
        setVisible( true );
    }
}
