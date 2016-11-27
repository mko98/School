/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoeventmanager;
/**
 * Klasse voor gegevenstranspoort 
 * @author eleutbec
 */
public class Band_1 {

    private int bandID;
    private String naam;
    private String beschrijving;

    public Band_1() {
        bandID = 0; 
        naam = "";
        beschrijving = "";
    }

    public Band_1(int id, String na, String beschr) {
        bandID = id;
        naam = na;
        beschrijving = beschr;
    }

    public void setBandID(int bandID) {
        this.bandID = bandID;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getBandID() {
        return bandID;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }
    
    
    public String toString() {
        String str = ""; 
        str = "BandNaam: " + naam + "  ID: " + bandID + "\n";
        return str; 
    }
    
    public boolean equals(Object anObject) {
        Band_1 aBand = (Band_1) anObject;
        return (bandID == aBand.getBandID());        
    }
}
