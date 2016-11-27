/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastorage;

import domain.Optreden;
import java.util.ArrayList;

/**
 *
 * @author quocsyluong
 */
public class OptredenDAO {

    private static int laatsteID;
    private static ArrayList<Optreden> optredenLijst;

    private int indexOfOptreden;

    public OptredenDAO() {

        if (optredenLijst == null) {
            optredenLijst = new ArrayList();
            laatsteID = -1;
        }
        if (optredenLijst.size() == 0) {
            this.optredenLijstVullen();
        }

        indexOfOptreden = 0;
    }



    public boolean optredenAanmaken(Optreden aOptreden) {
        boolean ret = true;
        aOptreden.setOptredenID(getNieuweID());
        optredenLijst.add(aOptreden);
        return ret;
    }

    //alleen via ID. De nieuwe gegevens staan in parameter aBand 
    public boolean optredenWijzigen(Optreden aOptreden) {
        boolean ret = false;
        Optreden o;

        this.eenOptredenZoeken(aOptreden.getOptredenID());
        if (indexOfOptreden == 0) {
            return false;
        } else {
            o = optredenLijst.get(indexOfOptreden);
            o.setOptredenBand(aOptreden.getOptredenBand());
            o.setOptredenPodium(aOptreden.getOptredenPodium());
            o.setOptredenDatum(aOptreden.getOptredenDatum());
            o.setOptredenBeginTijd(aOptreden.getOptredenBeginTijd());
            o.setOptredenEindTijd(aOptreden.getOptredenEindTijd());
        }

        return true;
    }

    //alleen via ID, die in de parameter aBand staat 
    public boolean optredenVerwijderen(Optreden aOptreden) {
        boolean ret = false;
        int index = -1;
        index = optredenLijst.indexOf(aOptreden);
        //als band niet gevonden, alleen false terug geven  
        if (index == -1) {
            return false;
        }

        optredenLijst.remove(index);

        return true;
    }

    //een Band zoeken via ID (unique)
    public Optreden eenOptredenZoeken(int aID) {
        int index = -1;
        index = optredenLijst.indexOf(new Optreden( aID, null, null, 10, 10, 10 ));
        //als band niet gevonden, toon band met fout 
        if (index == -1) {
            index = 0;
        }
        indexOfOptreden = index;
        return optredenLijst.get(index);
    }

    //een Band zoeken via naam. De eerste band met deze naam wordt getoont
    // !!! implementatie gemist !!!
    public Optreden eenOptredenZoeken(String naamDeel) {
        int index = 0;

        return optredenLijst.get(index);
    }

    // toont de volgende Band in de lijst. 
    // Als de lijst op is wordt de laatste band getoond. 
    public Optreden volgendeOptreden() {
        if (indexOfOptreden < 0) {
            indexOfOptreden = 0;
        } else if (indexOfOptreden < (optredenLijst.size() - 1)) {
            indexOfOptreden = indexOfOptreden + 1;
        }
        //anders blijft indexOfBand op de laatste band in de lijst

        return optredenLijst.get(indexOfOptreden);
    }

    // toont de vorige Band in de lijst. 
    // Als de lijst aan het begin is wordt de eerste band getoond. 
    public Optreden vorigeOptreden() {
        if (indexOfOptreden <= 1) {
            indexOfOptreden = 1;
        } else {
            indexOfOptreden = indexOfOptreden - 1;
        }

        return optredenLijst.get(indexOfOptreden);
    }

    private int getNieuweID() {
        laatsteID = laatsteID + 1;
        return laatsteID;
    }
    
    public int setNieuweID(){
        laatsteID = laatsteID++;
        return laatsteID;
    }

    //de eerste band in de lijst wordt gebruikt om fouten te tonen 
    private void optredenLijstVullen() {
        optredenAanmaken(new Optreden(0, "Band niet gevonden", "Fout", 4, 23, 9));
        optredenAanmaken(new Optreden(0, "Yellow Claw", "Geen hiphop", 21, 10, 5));
        optredenAanmaken(new Optreden(0, "Di-rect", "Wutduhvuk", 50, 70, 43));
        optredenAanmaken(new Optreden(0, "Stream of Passion", "Metal", 23, 65, 98));
        optredenAanmaken(new Optreden(0, "Dark Rosie", "Pop", 30, 44, 19));
        optredenAanmaken(new Optreden(0, "Cold Water", "Prima", 70, 25, 22));
        optredenAanmaken(new Optreden(0, "The Ocean", "Goed", 17, 57, 99));
        optredenAanmaken(new Optreden(0, "Timeflies", "Top", 87, 66, 34));
    }

    /** public void printBandLijst() {
        System.out.println("*** Lijst met Bands ***");
        for (Band b : bandLijst) {
            System.out.print(b.toString());
        }
        System.out.println("*** Eind ***");
    }
    * */
}
