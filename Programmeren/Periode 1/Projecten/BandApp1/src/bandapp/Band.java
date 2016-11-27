/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandapp;
/**
 * Klasse voor gegevenstranspoort 
 * @author eleutbec
 */
public class Band {

    private int bandID;
    private String naam;
    private String beschrijving;

    public Band() {
        bandID = 0; 
        naam = "";
        beschrijving = "";
    }

    public Band(int id, String na, String beschr) {
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
        Band aBand = (Band) anObject;
        return (bandID == aBand.getBandID());        
    }
}
