/*
 * Avans Hogeschool Breda, AE&I,Opleiding Informatica 
 */
package duoeventmanager;

/**
 * Klasse voor gegevenstranspoort 
 * @author eleutbec
 */
public class Podium {

    private int podiumID;
    private String naam;
    private String beschrijving;

    public Podium() {
        naam = "";
        beschrijving = "";
    }

    public Podium(int id, String na, String beschr) {
        podiumID = id;
        naam = na;
        beschrijving = beschr;
    }

    public void setPodiumID(int podiumID) {
        this.podiumID = podiumID;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getPodiumID() {
        return podiumID;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }
    
    public String toString() {
        String str = "";
        str = "PodiumNaam: " + naam + "  ID: " + podiumID + "\n";
        return str;
    }

    public boolean equals(Object anObject) {
        Podium aPodium = (Podium) anObject;
        return (podiumID == aPodium.getPodiumID());
    }
        
}
