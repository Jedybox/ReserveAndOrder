package dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import users.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    
    static String url = "jdbc:sqlite:main.db"; 
    
    public static int getUserId(String name) {
        String selectSQL = "SELECT id FROM customers WHERE name = '" + name + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery(selectSQL);

            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return -1;
    }

    public static String getUserPassword(String name) {
        String selectSQL = "SELECT password FROM customers WHERE name = '" + name + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery(selectSQL);

            if (rs.next()) {
                return rs.getString("password");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static boolean checkUser(String name) {
        String selectSQL = "SELECT name FROM customers WHERE name = '" + name + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery(selectSQL);

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static void addCustomer(String name, String pass) {

        String createTableSQL = "CREATE TABLE IF NOT EXISTS customers ("
                                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "name TEXT NOT NULL UNIQUE,"
                                + "password TEXT NOT NULL );";
        String insertSQL = "INSERT INTO customers(name, password) VALUES('" +name+ "', '"+pass+"');";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {
                
                stmt.execute(createTableSQL);
                stmt.execute(insertSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addReservation(Customer customer, String reciept, String details, int amount, String date, String time, double payment) {
        
        String createTableSQL = """
                                CREATE TABLE IF NOT EXISTS reservations (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                user TEXT NOT NULL,
                                order_id INTEGER NOT NULL,
                                amount_guest INTEGER NOT NULL,
                                date TEXT NOT NULL,
                                reciept TEXT NOT NULL,
                                details TEXT NOT NULL,
                                time TEXT NOT NULL,
                                payment DOUBLE NOT NULL);
                                """;

        String insertSQL = "INSERT INTO reservations(user, order_id, amount_guest, date, reciept, details, time, payment) VALUES('" +    
                            customer.getName() + "', " +
                            customer.getName().hashCode() + ", " +
                            amount + ", '" +
                            date + "', '" +
                            reciept + "', '" +
                            details + "', '" +
                            time  + "', '" +
                            payment + "');";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {
            stmt.execute(createTableSQL);
            stmt.execute(insertSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    } 

    public static void deleteReservation(Customer customer) {
        String deleteSQL = "DELETE FROM reservations WHERE user = '" + customer.getName() + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            stmt.execute(deleteSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Object> getReservation(Customer customer) {
        String selectSQL = "SELECT * FROM reservations WHERE user = '" + customer.getName() + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery(selectSQL);
            ArrayList<Object> reservation = new ArrayList<>();

            while (rs.next()) {
                reservation.add(rs.getString("reciept"));
                reservation.add(rs.getString("details"));
                reservation.add(rs.getInt("amount_guest"));
                reservation.add(rs.getString("date"));
                reservation.add(rs.getString("time"));
                reservation.add(rs.getInt("order_id"));
                reservation.add(rs.getDouble("payment"));
            }

            return reservation;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    public static boolean hasReservation(Customer customer) {
        String selectSQL = "SELECT * FROM reservations WHERE user = '" + customer.getName() + "';";

        String deleteSQL = "DELETE FROM reservations WHERE user = '" + customer.getName() + "';";
        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery(selectSQL);

            if (rs.next()) {
                String dateString = rs.getString("date");
                String timeString = rs.getString("time");

                // Define the formatters
                DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
                DateTimeFormatter tFormatter = DateTimeFormatter.ofPattern("h:mm a");

                // Parse the date and time
                LocalDate now = LocalDate.now();
                LocalDate date = LocalDate.parse(dateString, dFormatter);
                LocalTime time = LocalTime.parse(timeString, tFormatter);

                if (!now.isBefore(date)) {
                    stmt.execute(deleteSQL); // Delete if the date is in the past
                    return false;
                }

                if (now.isEqual(date)) { // If the date is today
                    LocalTime nowTime = LocalTime.now();
                    if (!nowTime.isBefore(time)) {
                        stmt.execute(deleteSQL); // Delete if the time is in the past
                        return false;
                    }
                }

                return true; // Otherwise, the date-time is valid
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

}
