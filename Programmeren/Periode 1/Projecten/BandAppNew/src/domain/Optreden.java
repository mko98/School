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
public class Optreden {
      
    private int optredenID;
    private String optredenBand;
    private String optredenPodium;
    private int optredenDatum;
    private int optredenBeginTijd;
    private int optredenEindTijd;

    public Optreden() {
        optredenID = 0; 
        optredenBand = "";
        optredenPodium = "";
        optredenDatum = 0;
        optredenBeginTijd = 0;
        optredenEindTijd = 0;
    }

    public Optreden(int oid, String ona, String opod, int odatum, int obtijd, int oetijd) {
        optredenID = oid;
        optredenBand = ona;
        optredenPodium = opod;
        optredenDatum = odatum;
        optredenBeginTijd = obtijd;
        optredenEindTijd = oetijd;
    }

    public void setOptredenID(int optredenID) {
        this.optredenID = optredenID;
    }

    public void setOptredenBand(String optredenBand) {
        this.optredenBand = optredenBand;
    }

    public void setOptredenPodium(String optredenPodium) {
        this.optredenPodium = optredenPodium;
    }

    public void setOptredenDatum(int optredenDatum){
        this.optredenDatum = optredenDatum;
    }
    
    public void setOptredenBeginTijd(int optredenBegintTijd ){
        this.optredenBeginTijd = optredenBeginTijd;
    }
    
    public void setOptredenEindTijd(int optredenEindTijd ){
        this.optredenEindTijd = optredenEindTijd;
    }
    
    public int getOptredenID() {
        return optredenID;
    }

    public String getOptredenBand() {
        return optredenBand;
    }

    public String getOptredenPodium(){
        return optredenPodium;
    }
    
    public int getOptredenDatum() {
        return optredenDatum;
    }
    
     public int getOptredenBeginTijd() {
        return optredenBeginTijd;
    }
        
    public int getOptredenEindTijd() {
        return optredenEindTijd;
    }
    
    public String toString() {
        String str = ""; 
        str = "BandNaam: " + optredenBand + "  ID: " + optredenID + "\n";
        return str; 
    }
    
    public boolean equals(Object anObject) {
        Optreden aOptreden = (Optreden) anObject;
        return (optredenID == aOptreden.getOptredenID());        
    }
}
