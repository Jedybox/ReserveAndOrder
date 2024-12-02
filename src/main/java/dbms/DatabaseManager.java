package dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import users.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    
    static String url = "jdbc:sqlite:main.db"; 

    public static void addCustomer(String name, String pass) {

        String createTableSQL = "CREATE TABLE IF NOT EXISTS customers ("
                                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "name TEXT NOT NULL UNIQUE,"
                                + "password TEXT NOT NULL );";
        String insertSQL = "INSERT INTO customers(name, password) VALUES('" +name+ "', '"+pass+"');";
        String selectSQL = "SELECT id, name, password FROM customers;";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

                stmt.execute(insertSQL);
                stmt.execute(createTableSQL);
                
                stmt.executeQuery(selectSQL);

                ResultSet rs = stmt.executeQuery(selectSQL);

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("password"));
                }
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("nice");
    }

    public static void addReservation(Customer customer) {
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateNow = DateTimeFormatter.ofPattern("MM--dd-yyyy");
        DateTimeFormatter timeNow = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String date = dateNow.format(now);
        String time = timeNow.format(now);

        String createTableSQL = "CREATE TABLE IF NOT EXISTS reservations ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "user_id INTEGER NOT NULL,"
        + "date TEXT NOT NULL,"
        + "time TEXT NOT NULL,"
        + "guess_amount INTEGER NOT NULL);";
        
        
        // TODO: make this thing

    } 

}
