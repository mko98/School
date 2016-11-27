/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vb0402ui;

/**
 *
 * @author Mko98
 */
public class BTWCalc {
    private double percentageBTW;
    
    public BTWCalc(){
        percentageBTW = 21.0;
    }
    
    public double berekenBTW(double prijsZonderBTW) {
        double prijsMetBTW = (1 + percentageBTW / 100) * prijsZonderBTW;
        return prijsMetBTW;
    }
}
