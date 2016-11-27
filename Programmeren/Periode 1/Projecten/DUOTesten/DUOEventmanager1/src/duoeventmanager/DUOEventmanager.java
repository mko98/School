/*
 * AVANS Hogeschool Breda, AE&I, opleiding Informatica 
 * 
 * DUO opdracht Programmeren en Databases 2016
 */
package duoeventmanager;

import javax.swing.JFrame;

/**
 * Testversie met Domainklassen, DAO Klassen en TestDAO klassen
 * slagen de gegevens in het geheugen van de computer op ! 
 *
 * Ellen Leutbecher
 *
 * @author eleutbec
 */
public class DUOEventmanager {

    /**
     * @param args the command line arguments - geen
     */
    public static void main(String[] args) {
    StartGUI sGui = new StartGUI();
        DUOEventmanager duo = new DUOEventmanager();
        duo.testBandDAO();
        duo.testPodiumDAO(); 
        duo.testOptredenDAO();

    }

    public void testBandDAO() {
        TestBandDAO test = new TestBandDAO();
        test.volgendeVorigeTest();
        test.zoekenViaIdTest();
        test.bandVerwijderenTest();
        test.bandWijzigenTest();

    }

    public void testPodiumDAO() {
        TestPodiumDAO test = new TestPodiumDAO();
        test.volgendeVorigeTest();
        test.zoekenViaIdTest();
        test.podiumVerwijderenTest();
        test.podiumWijzigenTest();

    }

    public void testOptredenDAO() {
        TestOptredenDAO test = new TestOptredenDAO();
        test.volgendeVorigeTest();
        test.zoekenViaIdTest();
        test.optredenVerwijderenTest();
        test.optredenWijzigenTest();

    }

}

// https://docs.oracle.com/javase/tutorial/index.html

