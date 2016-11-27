/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author quocsyluong
 */
public class Podium {
  
    private int podiumID;
    private String podiumNaam;
    private String podiumLocatie;
    private String podiumBeschrijving;

    public Podium() {
        podiumID = 0; 
        podiumNaam = "";
        podiumLocatie = "";
        podiumBeschrijving = "";
    }

    public Podium(int pid, String pna, String ploc, String pbschr) {
        podiumID = pid;
        podiumNaam = pna;
        podiumLocatie = ploc;
        podiumBeschrijving = pbschr;
    }

    public void setPodiumID(int podiumID) {
        this.podiumID = podiumID;
    }

    public void setPodiumNaam(String podiumNaam) {
        this.podiumNaam = podiumNaam;
    }

    public void setPodiumLocatie(String podiumLocatie) {
        this.podiumLocatie = podiumLocatie;
    }

    public void setPodiumBeschrijving(String podiumBeschrijving){
        this.podiumBeschrijving = podiumBeschrijving;
    }
    
    public int getPodiumID() {
        return podiumID;
    }

    public String getPodiumNaam() {
        return podiumNaam;
    }

    public String getPodiumLocatie(){
        return podiumLocatie;
    }
    
    public String getPodiumBeschrijving() {
        return podiumBeschrijving;
    }
    
    public String toString() {
        String str = ""; 
        str = "BandNaam: " + podiumNaam + "  ID: " + podiumID + "\n";
        return str; 
    }
    
    public boolean equals(Object anObject) {
        Podium aPodium = (Podium) anObject;
        return (podiumID == aPodium.getPodiumID());        
    }
}