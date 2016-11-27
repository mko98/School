/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoeventmanager;

/**
 *
 * @author Mko98
 */
public class testOptredenDAO_1 {
     private OptredenDAO aODAO;

    public testOptredenDAO_1() {
        aODAO = new OptredenDAO(true);
    }

    // test methoden vorigeOptreden en volgendeOptreden
    public void volgendeVorigeTest() {
        System.out.println("\n +++ volgendeVorigeTest +++");
        //reset OptredenLijst 
        aODAO = new OptredenDAO(true);
        aODAO.printOptredenLijst();

        Optreden anOptreden = aODAO.vorigeOptreden();
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.vorigeOptreden();
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.volgendeOptreden();
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.vorigeOptreden();
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.volgendeOptreden();
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.volgendeOptreden();
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.volgendeOptreden();
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.volgendeOptreden();
        System.out.print(anOptreden.toString());
        System.out.println("Optreden toevoegen");
        aODAO.optredenAanmaken(aODAO.maaktTestObjectOptreden(0));

        anOptreden = aODAO.volgendeOptreden();
        System.out.print(anOptreden.toString());
        aODAO.printOptredenLijst();

    }

    public void zoekenViaIdTest() {
        System.out.println("\n +++ zoekenViaIdTest +++");
        //reset optredenLijst 
        aODAO = new OptredenDAO(true);
        Optreden anOptreden;
        aODAO.printOptredenLijst();

        //Optreden wordt gevonden 
        System.out.println("Optreden met ID = 3 zoeken en vinden ");
        anOptreden = aODAO.eenOptredenZoeken(3);
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.volgendeOptreden();
        System.out.print(anOptreden.toString());

        //Optreden wordt NIET gevonden 
        System.out.println("Optreden met ID = 13 zoeken en NIET vinden");
        anOptreden = aODAO.eenOptredenZoeken(13);
        System.out.print(anOptreden.toString());
        anOptreden = aODAO.volgendeOptreden();
        System.out.print(anOptreden.toString());

    }

    public void optredenVerwijderenTest() {
        System.out.println("\n +++ optredenVerwijderenTest +++");
        //reset optredenLijst 
        aODAO = new OptredenDAO(true);
        Optreden anOptreden;
        aODAO.printOptredenLijst();

        //Optreden verwijderen die bestaat
        boolean bol = aODAO.optredenVerwijderen(new Optreden(5));
        System.out.println("Resultaat 1 verwijderen Optreden 5: " + bol);
        aODAO.printOptredenLijst();

        //Optreden verwijderen die niet bestaat 
        bol = aODAO.optredenVerwijderen(new Optreden(13));
        System.out.println("Resultaat 2 verwijderen Optreden 13: " + bol);
        aODAO.printOptredenLijst();
    }

    public void optredenWijzigenTest() {
        System.out.println("\n +++ optredenWijzigenTest +++");
        //reset optredenLijst 
        aODAO = new OptredenDAO(true);
        Optreden anOptreden;
        aODAO.optredenAanmaken(aODAO.maaktTestObjectOptreden(0));
        aODAO.printOptredenLijst();

        //Optreden wijzigen die bestaat
        boolean bol = aODAO.optredenWijzigen(aODAO.maaktTestObjectOptreden(4));
        System.out.println("Resultaat 1 wijzigen Optreden 4: " + bol);
        aODAO.printOptredenLijst();

        //Optreden wijzigen die niet bestaat 
        bol = aODAO.optredenWijzigen(new Optreden(13));
        System.out.println("Resultaat 2 wijzigen Optreden 13: " + bol);
        aODAO.printOptredenLijst();
    }

    private static class OptredenDAO {

        public OptredenDAO() {
        }

        private OptredenDAO(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void printOptredenLijst() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private boolean optredenWijzigen(Optreden optreden) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Optreden maaktTestObjectOptreden(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void optredenAanmaken(Optreden maaktTestObjectOptreden) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private boolean optredenVerwijderen(Optreden optreden) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Optreden eenOptredenZoeken(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Optreden volgendeOptreden() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Optreden vorigeOptreden() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class Optreden {

        public Optreden(int i) {
        }
    }
}


