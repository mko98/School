/*
 * Avans Hogeschool Breda, AE&I,Opleiding Informatica 
 */
package duoeventmanager;

import java.util.ArrayList;

/**
 * Programmeren met Java 1 
 * Klasse om Podiums op te slagen - tijdelijke oplossing
 * Dit is een Mock klasse die de gegevens in het geheugen van de computer
 * opslaat
 *
 * @author eleutbec
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
        indexOfPodium = podiumLijst.size() - 1; 
        return ret;
    }

    //alleen via ID. De nieuwe gegevens staan in parameter aPodium 
    public boolean podiumWijzigen(Podium aPodium) {
        boolean ret = false;
        Podium b;

        this.eenPodiumZoeken(aPodium.getPodiumID());
        if (indexOfPodium == 0) {
            return false;
        } else {
            b = podiumLijst.get(indexOfPodium);
            b.setNaam(aPodium.getNaam());
            b.setBeschrijving(aPodium.getBeschrijving());
        }

        return true;
    }

    //alleen via ID, die in de parameter aPodium staat 
    public boolean podiumVerwijderen(Podium aPodium) {
        boolean ret = false;
        int index = -1;
        index = podiumLijst.indexOf(aPodium);
        //als Podium niet gevonden, alleen false terug geven  
        if (index == -1) {
            return false;
        }

        podiumLijst.remove(index);

        return true;
    }

    //een Podium zoeken via ID (unique)
    public Podium eenPodiumZoeken(int aID) {
        int index = -1;
        index = podiumLijst.indexOf(new Podium(aID, null, null));
        //als Podium niet gevonden, toon Podium met fout 
        if (index == -1) {
            index = 0;
        }
        indexOfPodium = index;
        return podiumLijst.get(index);
    }

    //een Podium zoeken via naam. De eerste Podium met deze naam wordt getoont
    // !!! implementatie gemist !!!
    public Podium eenPodiumZoeken(String naamDeel) {
        int index = 0;

        return podiumLijst.get(index);
    }

    // toont de volgende Podium in de lijst. 
    // Als de lijst op is wordt de laatste Podium getoond. 
    public Podium volgendePodium() {
        if (indexOfPodium < 0) {
            indexOfPodium = 0;
        } else if (indexOfPodium < (podiumLijst.size() - 1)) {
            indexOfPodium = indexOfPodium + 1;
        }
        //anders blijft indexOfPodium op de laatste Podium in de lijst

        return podiumLijst.get(indexOfPodium);
    }

    // toont de vorige Podium in de lijst. 
    // Als de lijst aan het begin is wordt de eerste Podium getoond. 
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

    //de eerste Podium in de lijst wordt gebruikt om fouten te tonen 
    private void podiumLijstVullen() {
        podiumAanmaken(new Podium(0, "Podium niet gevonden", "Fout"));
        podiumAanmaken(new Podium(0, "Theater Breda 1", "goot"));
        podiumAanmaken(new Podium(0, "Theater Breda 2", "middel"));
        podiumAanmaken(new Podium(0, "Cultuurfabriek", "Metal"));
        podiumAanmaken(new Podium(0, "Schuur Dordrecht", "alternatief"));
        podiumAanmaken(new Podium(0, "Belcrum Watertoren ", "klein"));
        podiumAanmaken(new Podium(0, "Grote Kerk Breda", "kerk"));

    }

    public void printPodiumLijst() {
        System.out.println("*** Lijst met Podia ***");
        for (Podium p : podiumLijst) {
            System.out.print(p.toString());
        }
        System.out.println("*** Eind ***");
    }

}
