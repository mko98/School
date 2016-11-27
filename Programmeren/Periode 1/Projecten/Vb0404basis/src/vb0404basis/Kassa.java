/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vb0404basis;

/**
 *
 * @author Mko98
 */
public class Kassa {
    private double subtotaal;
    public void telOp(double bedrag){
        subtotaal += bedrag;
        
        
    }
    public double getSubtotaal(){
        return subtotaal;
    }
    
   
}