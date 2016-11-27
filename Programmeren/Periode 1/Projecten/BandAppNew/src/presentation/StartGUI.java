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
public class StartGUI extends JFrame{
        
    public StartGUI(){
        setSize( 500, 300 );
        setTitle( "Band Applicatie");
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setContentPane( new StartPaneel() );
        setResizable( false );
        setVisible( true );
    }    
}