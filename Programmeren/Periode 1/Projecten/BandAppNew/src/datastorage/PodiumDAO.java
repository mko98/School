/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastorage;

import domain.Podium;
import java.util.ArrayList;

/**
 *
 * @author quocsyluong
 */
public class PodiumDAO {

    private static int laatsteID;
    private static ArrayList<Podium> podiumLijst;

    private int indexOfPodium;

    public PodiumDAO() {

        if (podiumLijst == null) {
            podiumLijst = new ArrayList();
            laatsteID = -1;
        }
        if (podiumLijst.size() == 0) {
            this.podiumLijstVullen();
        }

        indexOfPodium = 0;
    }

    //in testmodus altijd met dezelfde basis beginnen ! 
    public PodiumDAO(boolean test) {

        if (test) {
            laatsteID = -1;
            podiumLijst = new ArrayList();
            this.podiumLijstVullen();
        }
        indexOfPodium = 0;
    }

    public boolean podiumAanmaken(Podium aPodium) {
        boolean ret = true;
        aPodium.setPodiumID(getNieuweID());
        podiumLijst.add(aPodium);
        return ret;
    }

    //alleen via ID. De nieuwe gegevens staan in parameter aBand 
    public boolean podiumWijzigen(Podium aPodium) {
        boolean ret = false;
        Podium p;

        this.eenPodiumZoeken(aPodium.getPodiumID());
        if (indexOfPodium == 0) {
            return false;
        } else {
            p = podiumLijst.get(indexOfPodium);
            p.setPodiumNaam(aPodium.getPodiumNaam());
            p.setPodiumLocatie(aPodium.getPodiumLocatie());
            p.setPodiumBeschrijving(aPodium.getPodiumBeschrijving());
        }

        return true;
    }

    //alleen via ID, die in de parameter aBand staat 
    public boolean podiumVerwijderen(Podium aPodium) {
        boolean ret = false;
        int index = -1;
        index = podiumLijst.indexOf(aPodium);
        //als band niet gevonden, alleen false terug geven  
        if (index == -1) {
            return false;
        }

        podiumLijst.remove(index);

        return true;
    }

    //een Band zoeken via ID (unique)
    public Podium eenPodiumZoeken(int aID) {
        int index = -1;
        index = podiumLijst.indexOf(new Podium(aID, null, null, null));
        //als band niet gevonden, toon band met fout 
        if (index == -1) {
            index = 0;
        }
        indexOfPodium = index;
        return podiumLijst.get(index);
    }

    //een Band zoeken via naam. De eerste band met deze naam wordt getoont
    // !!! implementatie gemist !!!
    public Podium eenPodiumZoeken(String naamDeel) {
        int index = 0;

        return podiumLijst.get(index);
    }

    // toont de volgende Band in de lijst. 
    // Als de lijst op is wordt de laatste band getoond. 
    public Podium volgendePodium() {
        if (indexOfPodium < 0) {
            indexOfPodium = 0;
        } else if (indexOfPodium < (podiumLijst.size() - 1)) {
            indexOfPodium = indexOfPodium + 1;
        }
        //anders blijft indexOfBand op de laatste band in de lijst

        return podiumLijst.get(indexOfPodium);
    }

    // toont de vorige Band in de lijst. 
    // Als de lijst aan het begin is wordt de eerste band getoond. 
    public Podium vorigePodium() {
        if (indexOfPodium <= 1) {
            indexOfPodium = 1;
        } else {
            indexOfPodium = indexOfPodium - 1;
        }

        return podiumLijst.get(indexOfPodium);
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
    private void podiumLijstVullen() {
        podiumAanmaken(new Podium(0, "Band niet gevonden", "Fout", "BS"));
        podiumAanmaken(new Podium(0, "Yellow Claw", "Geen hiphop", "AS"));
        podiumAanmaken(new Podium(0, "Di-rect", "Wutduhvuk","CS"));
        podiumAanmaken(new Podium(0, "Stream of Passion", "Metal", "CC"));
        podiumAanmaken(new Podium(0, "Dark Rosie", "Pop", "PP"));
        podiumAanmaken(new Podium(0, "Cold Water", "Prima", "TT"));
        podiumAanmaken(new Podium(0, "The Ocean", "Goed", "GG"));
        podiumAanmaken(new Podium(0, "Timeflies", "Top", "BG"));
    }

    public void printPodiumLijst() {
        System.out.println("*** Lijst met Podia ***");
        for (Podium p : podiumLijst) {
            System.out.print(p.toString());
        }
        System.out.println("*** Eind ***");
    }

}

