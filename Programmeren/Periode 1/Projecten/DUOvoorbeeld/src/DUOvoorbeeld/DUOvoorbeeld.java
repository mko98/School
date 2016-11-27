package DUOvoorbeeld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DUOvoorbeeld {

    public static void main(String[] args) throws SQLException {
        // Zorg dat je bij libraries toevoegt: MySQL JDBC Driver ........
        
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

