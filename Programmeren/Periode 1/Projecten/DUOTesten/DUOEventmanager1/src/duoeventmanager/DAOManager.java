/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoeventmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author quocsyluong
 */
public class DAOManager {

    public DAOManager() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/DUO_1", "duo1", "duo1");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM band_artiest;");
        while (resultset.next()) {
            int Sleutel = resultset.getInt("Sleutel");
            String Naam = resultset.getString("Naam");
            String Beschrijving = resultset.getString("Beschrijving");
            System.out.println(Sleutel + " " + Naam + " " + Beschrijving);
        }
    }
}