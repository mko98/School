/*
 * Avans Hogeschool Breda, AE&I,Opleiding Informatica 
 */
package duoeventmanager;

import java.util.ArrayList;

/**
 * Programmeren met Java 1 
 * Klasse om Optredens op te slagen - tijdelijke oplossing
 * Dit is een Mock klasse die de gegevens in het geheugen van de
 * computer opslaat
 *
 * @author eleutbec
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

    //in testmodus altijd met dezelfde basis beginnen ! 
    public OptredenDAO(boolean test) {

        if (test) {
            laatsteID = -1;
            optredenLijst = new ArrayList();
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

    //alleen via ID. De nieuwe gegevens staan in parameter anOptreden 
    public boolean optredenWijzigen(Optreden anOptreden) {
        boolean ret = false;

        this.eenOptredenZoeken(anOptreden.getOptredenID());
        if (indexOfOptreden == 0) {
            return false;
        } else {
            //het optreden vervangen, niet toevoegen
            optredenLijst.set(indexOfOptreden, anOptreden);
        }

        return true;
    }

    //alleen via ID, die in de parameter anOptreden staat 
    public boolean optredenVerwijderen(Optreden anOptreden) {
        boolean ret = false;
        int index = -1;
        index = optredenLijst.indexOf(anOptreden);
        //als Optreden niet gevonden, alleen false terug geven  
        if (index == -1) {
            return false;
        }

        optredenLijst.remove(index);

        return true;
    }

    //een Optreden zoeken via ID (unique)
    public Optreden eenOptredenZoeken(int aID) {
        int index = -1;
        index = optredenLijst.indexOf(new Optreden(aID, null, null, null, null, null));
        //als Optreden niet gevonden, toon Optreden met fout 
        if (index == -1) {
            index = 0;
        }
        indexOfOptreden = index;
        return optredenLijst.get(index);
    }

    //een Optreden zoeken via naam. De eerste Optreden met deze naam wordt getoont
    // !!! implementatie gemist !!!
    public Optreden eenOptredenZoeken(String naamDeel) {
        int index = 0;

        return optredenLijst.get(index);
    }

    // toont de volgende Optreden in de lijst. 
    // Als de lijst op is wordt de laatste Optreden getoond. 
    public Optreden volgendeOptreden() {
        if (indexOfOptreden < 0) {
            indexOfOptreden = 0;
        } else if (indexOfOptreden < (optredenLijst.size() - 1)) {
            indexOfOptreden = indexOfOptreden + 1;
        }
        //anders blijft indexOfOptreden op de laatste Optreden in de lijst

        return optredenLijst.get(indexOfOptreden);
    }

    // toont de vorige Optreden in de lijst. 
    // Als de lijst aan het begin is wordt de eerste Optreden getoond. 
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

    //de eerste Optreden in de lijst wordt gebruikt om fouten te tonen 
    private void optredenLijstVullen() {

        BandDAO bd = new BandDAO();
        Band aBand;
        PodiumDAO pd = new PodiumDAO();
        Podium aPodium;

        //Optreden voor fouten 
        optredenAanmaken(maakOptredenVoorFouten());

        //5 Optredens aanmaken 
        for (int k = 1; k < 6; k++) {
            aBand = bd.volgendeBand();
            aPodium = pd.volgendePodium();
            Optreden op = new Optreden(0, aBand, aPodium, "2016-10-08", "20:00", "22:00");
            optredenAanmaken(op);
        }
    }

    private Optreden maakOptredenVoorFouten() {
        Band aBand = new Band(0, "Geen Band. Optreden niet gevonden!", "");
        Podium aPodium = new Podium(0, "Geen Podium", "");
        Optreden anOptreden = new Optreden(0, aBand, aPodium, "geen", "", "");
        return anOptreden;
    }

    //testobject van Optreden maken 
    public Optreden maaktTestObjectOptreden(int id) {
        BandDAO bd = new BandDAO();
        Band aBand = bd.volgendeBand();
        aBand = bd.volgendeBand();
        PodiumDAO pd = new PodiumDAO();
        Podium aPodium = pd.volgendePodium();
        Optreden op = new Optreden(id, aBand, aPodium, "2016-10-22", "20:00", "22:00");              
        return op;  
    }

    public void printOptredenLijst() {
        System.out.println("*** Lijst met Optredens ***");
        for (Optreden o : optredenLijst) {
            System.out.print(o.toString());
        }
        System.out.println("*** Eind ***");
    }

}
