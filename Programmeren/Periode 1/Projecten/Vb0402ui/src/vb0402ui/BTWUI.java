package vb0402ui;

import javax.swing.*;

/**
 * @author eleutbec
 */
public class BTWUI extends JFrame {

    public BTWUI() {
        setSize(450, 150);
        setLocation(500, 400);    //added 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Voorbeeld 0402 ui");
        setContentPane(new BTWPaneel());
        setVisible(true);
    }

}
