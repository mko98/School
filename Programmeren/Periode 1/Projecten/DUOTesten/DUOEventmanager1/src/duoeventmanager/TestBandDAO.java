/*
 * AVANS Hogeschool Breda, AE&I, opleiding Informatica 
 */
package duoeventmanager;

/**
 * Deze klasse test de klasse BandDAO
 * @author eleutbec
 */
public class TestBandDAO {

    private BandDAO aBDAO;

    public TestBandDAO() {
        aBDAO = new BandDAO(true);
    }

    // test methoden vorigeBand en volgendeBand
    public void volgendeVorigeTest() {
        System.out.println("\n +++ volgendeVorigeTest +++");
        //reset BandLijst 
        aBDAO = new BandDAO(true);
        aBDAO.printBandLijst();

        Band aBand = aBDAO.vorigeBand();
        System.out.print(aBand.toString());
        aBand = aBDAO.vorigeBand();
        System.out.print(aBand.toString());
        aBand = aBDAO.volgendeBand();
        System.out.print(aBand.toString());
        aBand = aBDAO.vorigeBand();
        System.out.print(aBand.toString());
        aBand = aBDAO.volgendeBand();
        System.out.print(aBand.toString());
        aBand = aBDAO.volgendeBand();
        System.out.print(aBand.toString());
        aBand = aBDAO.volgendeBand();
        System.out.print(aBand.toString());
        aBand = aBDAO.volgendeBand();
        System.out.print(aBand.toString());
        System.out.println("Band toevoegen");
        aBDAO.bandAanmaken(new Band(0, "Pink", "Test"));
        aBand = aBDAO.volgendeBand();
        System.out.print(aBand.toString());
        aBDAO.printBandLijst();

    }

    public void zoekenViaIdTest() {
        System.out.println("\n +++ zoekenViaIdTest +++");
        //reset bandLijst 
        aBDAO = new BandDAO(true);
        Band aBand;
        aBDAO.bandAanmaken(new Band(0, "Pink", "Test"));
        aBDAO.printBandLijst();

        //band wordt gevonden 
        System.out.println("Band met ID = 3 zoeken en vinden "); 
        aBand = aBDAO.eenBandZoeken(3);
        System.out.print(aBand.toString());
        aBand = aBDAO.volgendeBand();
        System.out.print(aBand.toString());

        //band wordt NIET gevonden 
        System.out.println("Band met ID = 13 zoeken en NIET vinden"); 
        aBand = aBDAO.eenBandZoeken(13);
        System.out.print(aBand.toString());
        aBand = aBDAO.volgendeBand();
        System.out.print(aBand.toString());

    }

    public void bandVerwijderenTest() {
        System.out.println("\n +++ bandVerwijderenTest +++");
        //reset bandLijst 
        aBDAO = new BandDAO(true);
        Band aBand;
        aBDAO.bandAanmaken(new Band(0, "Pink", "Test"));
        aBDAO.printBandLijst();

        //band verwijderen die bestaat
        boolean bol = aBDAO.bandVerwijderen(new Band(5, "", ""));
        System.out.println("Resultaat 1 verwijderen Band 5: " + bol);
        aBDAO.printBandLijst();

        //band verwijderen die niet bestaat 
        bol = aBDAO.bandVerwijderen(new Band(13, "", ""));
        System.out.println("Resultaat 2 verwijderen Band 13: " + bol);
        aBDAO.printBandLijst();
    }
    
    public void bandWijzigenTest() {
        System.out.println("\n +++ bandWijzigenTest +++");
        //reset bandLijst 
        aBDAO = new BandDAO(true);
        Band aBand;
        aBDAO.bandAanmaken(new Band(0, "Pink", "Test"));
        aBDAO.printBandLijst();

        //band wijzigen die bestaat
        boolean bol = aBDAO.bandWijzigen(new Band(4, "Light Wind", "Softpop"));
        System.out.println("Resultaat 1 wijzigen Band 4: " + bol);
        aBDAO.printBandLijst();

        //band wijzigen die niet bestaat 
        bol = aBDAO.bandWijzigen(new Band(13, "", ""));
        System.out.println("Resultaat 2 wijzigen Band 13: " + bol);
        aBDAO.printBandLijst();        
    }
}
