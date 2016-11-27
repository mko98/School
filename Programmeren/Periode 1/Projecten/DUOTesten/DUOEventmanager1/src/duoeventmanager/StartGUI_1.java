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
public class StartGUI_1 extends JFrame{
        
    public StartGUI_1(){
        setSize( 600, 300 );
        setTitle( "Band Applicatie");
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setContentPane( new StartPaneel() );
        setResizable( false );
        setVisible( true );
    }    
}