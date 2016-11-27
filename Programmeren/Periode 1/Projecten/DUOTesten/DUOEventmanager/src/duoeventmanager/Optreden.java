/*
 * Avans Hogeschool Breda, AE&I,Opleiding Informatica 
 */
package duoeventmanager;

/**
 * Klasse voor gegevenstranspoort 
 * @author eleutbec
 */
public class Optreden {

    private int optredenID;
    private Band band;
    private Podium podium;
    private String datum;
    private String beginTijd;
    private String eindTijd;

    public Optreden(int id, Band b, Podium p, String date, String begin, String eind) {
        optredenID = id;
        band = b;
        podium = p;
        datum = date;
        beginTijd = begin;
        eindTijd = eind;

    }

    //wordt voor zoeken en verwijderen gebruikt 
    public Optreden(int id) {
        optredenID = id;

    }

    public void setOptredenID(int optredenID) {
        this.optredenID = optredenID;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public void setPodium(Podium podium) {
        this.podium = podium;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setBeginTijd(String beginTijd) {
        this.beginTijd = beginTijd;
    }

    public void setEindTijd(String eindTijd) {
        this.eindTijd = eindTijd;
    }

    public int getOptredenID() {
        return optredenID;
    }

    public Band getBand() {
        return band;
    }

    public Podium getPodium() {
        return podium;
    }

    public String getDatum() {
        return datum;
    }

    public String getBeginTijd() {
        return beginTijd;
    }

    public String getEindTijd() {
        return eindTijd;
    }

    public String toString() {
        String str = "Optreden ID:     " + optredenID + "\n";
        str = str + band.toString();        //nieuwe regel met band.toString()
        str = str + podium.toString();      //nieuwe regel met podium.toString()
        str = str + "Tijd:   " + datum + ", " + beginTijd + "-" + eindTijd + "\n";
        return str;
    }

    public boolean equals(Object anObject) {
        Optreden aOptreden = (Optreden) anObject;
        return (optredenID == aOptreden.getOptredenID());
    }

}
