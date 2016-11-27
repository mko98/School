/*
 * AVANS Hogeschool Breda, AE&I, opleiding Informatica 
 */
package duoeventmanager;

/**
 * Deze klasse test de klasse BandDAO
 * @author eleutbec
 */
public class TestPodiumDAO {

    private PodiumDAO aPDAO;

    public TestPodiumDAO() {
        aPDAO = new PodiumDAO(true);
    }

    // test methoden vorigePodium en volgendePodium
    public void volgendeVorigeTest() {
        System.out.println("\n +++ volgendeVorigeTest +++");
        //reset PodiumLijst 
        aPDAO = new PodiumDAO(true);
        aPDAO.printPodiumLijst();

        Podium aPodium = aPDAO.vorigePodium();
        System.out.print(aPodium.toString());
        aPodium = aPDAO.vorigePodium();
        System.out.print(aPodium.toString());
        aPodium = aPDAO.volgendePodium();
        System.out.print(aPodium.toString());
        aPodium = aPDAO.vorigePodium();
        System.out.print(aPodium.toString());
        aPodium = aPDAO.volgendePodium();
        System.out.print(aPodium.toString());
        aPodium = aPDAO.volgendePodium();
        System.out.print(aPodium.toString());
        aPodium = aPDAO.volgendePodium();
        System.out.print(aPodium.toString());
        aPodium = aPDAO.volgendePodium();
        System.out.print(aPodium.toString());
        System.out.println("Podium toevoegen");
        aPDAO.podiumAanmaken(new Podium(0, "Flint Amersfoort", "Theater"));
        aPodium = aPDAO.volgendePodium();
        System.out.print(aPodium.toString());
        aPDAO.printPodiumLijst();

    }

    public void zoekenViaIdTest() {
        System.out.println("\n +++ zoekenViaIdTest +++");
        //reset podiumLijst 
        aPDAO = new PodiumDAO(true);
        Podium aPodium;
        aPDAO.podiumAanmaken(new Podium(0, "Flint Amersfoort", "Test"));
        aPDAO.printPodiumLijst();

        //Podium wordt gevonden 
        System.out.println("Podium met ID = 3 zoeken en vinden "); 
        aPodium = aPDAO.eenPodiumZoeken(3);
        System.out.print(aPodium.toString());
        aPodium = aPDAO.volgendePodium();
        System.out.print(aPodium.toString());

        //Podium wordt NIET gevonden 
        System.out.println("Podium met ID = 13 zoeken en NIET vinden"); 
        aPodium = aPDAO.eenPodiumZoeken(13);
        System.out.print(aPodium.toString());
        aPodium = aPDAO.volgendePodium();
        System.out.print(aPodium.toString());

    }

    public void podiumVerwijderenTest() {
        System.out.println("\n +++ podiumVerwijderenTest +++");
        //reset PodiumLijst 
        aPDAO = new PodiumDAO(true);
        Podium aPodium;
        aPDAO.podiumAanmaken(new Podium(0, "Flint Amersfoort", "Test"));
        aPDAO.printPodiumLijst();

        //Podium verwijderen die bestaat
        boolean bol = aPDAO.podiumVerwijderen(new Podium(5, "", ""));
        System.out.println("Resultaat 1 verwijderen Podium 5: " + bol);
        aPDAO.printPodiumLijst();

        //Podium verwijderen die niet bestaat 
        bol = aPDAO.podiumVerwijderen(new Podium(13, "", ""));
        System.out.println("Resultaat 2 verwijderen Podium 13: " + bol);
        aPDAO.printPodiumLijst();
    }
    
    public void podiumWijzigenTest() {
        System.out.println("\n +++ podiumWijzigenTest +++");
        //reset podiumLijst 
        aPDAO = new PodiumDAO(true);
        Podium aPodium;
        aPDAO.podiumAanmaken(new Podium(0, "Flint Amersfoort", "Test"));
        aPDAO.printPodiumLijst();

        //Podium wijzigen die bestaat
        boolean bol = aPDAO.podiumWijzigen(new Podium(4, "Station Breda", "Alternatief"));
        System.out.println("Resultaat 1 wijzigen Podium 4: " + bol);
        aPDAO.printPodiumLijst();

        //Podium wijzigen die niet bestaat 
        bol = aPDAO.podiumWijzigen(new Podium(13, "", ""));
        System.out.println("Resultaat 2 wijzigen Podium 13: " + bol);
        aPDAO.printPodiumLijst();        
    }
}
