/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoeventmanager;
import java.util.ArrayList;
/**
 *
 * @author Mko98
 */
public class testBandDAO_1 {
     private static int laatsteID;
    private static ArrayList<Band> bandLijst;

    private int indexOfBand;
    public testBandDAO_1() {

        if (bandLijst == null) {
            bandLijst = new ArrayList();
            laatsteID = -1;
        }
        if (bandLijst.isEmpty()) {
            this.bandLijstVullen();
        }

        indexOfBand = 0;
    }

    //in testmodus altijd met dezelfde basis beginnen ! 
    public testBandDAO_1(boolean test) {

        if (test) {
            laatsteID = -1;
            bandLijst = new ArrayList();
            this.bandLijstVullen();
        }
        indexOfBand = 0;
    }

    public boolean bandAanmaken(Band aBand) {
        boolean ret = true;
        aBand.setBandID(getNieuweID());
        bandLijst.add(aBand);
        indexOfBand = bandLijst.size() - 1;

        return ret;
    }

    //alleen via ID. De nieuwe gegevens staan in parameter aBand 
    public boolean bandWijzigen(Band aBand) {
        boolean ret = false;
        Band b;

        this.eenBandZoeken(aBand.getBandID());
        if (indexOfBand == 0) {
            return false;
        } else {
            b = bandLijst.get(indexOfBand);
            b.setNaam(aBand.getNaam());
            b.setBeschrijving(aBand.getBeschrijving());
        }

        return true;
    }

    //alleen via ID, die in de parameter aBand staat 
    public boolean bandVerwijderen(Band aBand) {
        boolean ret = false;
        int index = -1;
        index = bandLijst.indexOf(aBand);
        //als band niet gevonden, alleen false terug geven  
        if (index == -1) {
            return false;
        }

        bandLijst.remove(index);

        return true;
    }

    //een Band zoeken via ID (unique)
    public Band eenBandZoeken(int aID) {
        int index = -1;
        index = bandLijst.indexOf(new Band(aID, null, null));
        //als band niet gevonden, toon band met fout 
        if (index == -1) {
            index = 0;
        }
        indexOfBand = index;
        return bandLijst.get(index);
    }

    //een Band zoeken via naam. De eerste band met deze naam wordt getoont
    // !!! implementatie gemist !!!
    public Band eenBandZoeken(String naamDeel) {
        int index = 0;

        return bandLijst.get(index);
    }

    // toont de volgende Band in de lijst. 
    // Als de lijst op is wordt de laatste band getoond. 
    public Band volgendeBand() {
        if (indexOfBand < 0) {
            indexOfBand = 0;
        } else if (indexOfBand < (bandLijst.size() - 1)) {
            indexOfBand = indexOfBand + 1;
        }
        //anders blijft indexOfBand op de laatste band in de lijst

        return bandLijst.get(indexOfBand);
    }

    // toont de vorige Band in de lijst. 
    // Als de lijst aan het begin is wordt de eerste band getoond. 
    public Band vorigeBand() {
        if (indexOfBand <= 1) {
            indexOfBand = 1;
        } else {
            indexOfBand = indexOfBand - 1;
        }

        return bandLijst.get(indexOfBand);
    }

    private int getNieuweID() {
        laatsteID = laatsteID + 1;
        return laatsteID;
    }

    //de eerste band in de lijst wordt gebruikt om fouten te tonen 
    private void bandLijstVullen() {
        bandAanmaken(new Band(0, "Band niet gevonden", "Fout"));
        bandAanmaken(new Band(0, "Yellow Claw", "HipHop"));
        bandAanmaken(new Band(0, "Di-rect", ""));
        bandAanmaken(new Band(0, "Stream of Passion", "Metal"));
        bandAanmaken(new Band(0, "Dark Rosie", "Pop"));
        bandAanmaken(new Band(0, "Cold Water", "Prima"));
        bandAanmaken(new Band(4, "The Ocean", "Goed"));
        bandAanmaken(new Band(2, "Timeflies", "Top"));

    }

    public void printBandLijst() {
        System.out.println("*** Lijst met Bands ***");
        bandLijst.stream().forEach((b) -> {
            System.out.print(b.toString());
         });
        System.out.println("*** Eind ***");
    }

    void volgendeVorigeTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void zoekenViaIdTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void bandVerwijderenTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void bandWijzigenTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


