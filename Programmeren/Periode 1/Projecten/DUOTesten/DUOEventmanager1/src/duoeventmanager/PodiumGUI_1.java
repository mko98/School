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
public class PodiumGUI_1 extends JFrame{
    
    public PodiumGUI_1(){
        setSize( 400, 300);
        setTitle( "Podium informatie");
        setLocationRelativeTo( null );
        setContentPane( new PodiumPaneel() );
        setVisible( true );
    }    
}