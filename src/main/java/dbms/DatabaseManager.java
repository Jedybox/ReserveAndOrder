package dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import foodclasses.Appitizer;
import foodclasses.Dessert;
import foodclasses.Drink;
import foodclasses.MainCourse;
import foodclasses.Order;
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

    public static void updateCustomerName(String oldName, String newName) {
        String updateSQL = "UPDATE customers SET name = '" + newName + "' WHERE name = '" + oldName + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            stmt.execute(updateSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateCustomerPassword(String name, String pass) {
        String updateSQL = "UPDATE customers SET password = '" + pass + "' WHERE name = '" + name + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            stmt.execute(updateSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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

    public static void addReservation(Customer customer, Order order, int amount) {
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateNow = DateTimeFormatter.ofPattern("MM--dd-yyyy");
        DateTimeFormatter timeNow = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String date = dateNow.format(now);
        String time = timeNow.format(now);

        String createReservationTable = "CREATE TABLE IF NOT EXISTS reservations ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "user TEXT NOT NULL,"
        + "date TEXT NOT NULL,"
        + "time TEXT NOT NULL,"
        + "guess_amount INTEGER NOT NULL,"
        + "progress TEXT NOT NULL);";
        
        String createOrdersTable = "CREATE TABLE IF NOT EXISTS orders ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "user TEXT NOT NULL,"
        + "food TEXT NOT NULL,"
        + "type TEXT NOT NULL,"
        + "price DOUBLE NOT NULL,"
        + "amount INTEGER NOT NULL,)";


        String insertReservation = "INSERT INTO reservations(user_id, date, time, guess_amount) VALUES('" 
        + customer.getName() + "', '" + date + "', '" + time + "', '" + amount + "', 'PENDING');";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            stmt.execute(createReservationTable);
            stmt.execute(insertReservation);
            stmt.execute(createOrdersTable);

            for (Appitizer appitizer : order.getAppitizers()) {
                String insertOrder = "INSERT INTO orders(user, food, type, price, amount) VALUES('" 
                + customer.getName() + "', '" + appitizer.getName() + "', '"+ appitizer.getClass().toString()
                +"', '" + appitizer.getPrice()
                + "', '" + appitizer.getQuantity() + "');";
                stmt.execute(insertOrder);
            }

            for (MainCourse mainCourse : order.getMainCourses()) {
                String insertOrder = "INSERT INTO orders(user, food, type, price, amount) VALUES('" 
                + customer.getName() + "', '" + mainCourse.getName() + "', '"+ mainCourse.getClass().toString()
                +"', '" + mainCourse.getPrice()
                + "', '" + mainCourse.getQuantity() + "');";
                stmt.execute(insertOrder);
            }

            for (Dessert dessert : order.getDesserts()) {
                String insertOrder = "INSERT INTO orders(user, food, type, price, amount) VALUES('" 
                + customer.getName() + "', '" + dessert.getName() + "', '"+ dessert.getClass().toString()
                +"', '" + dessert.getPrice()
                + "', '" + dessert.getQuantity() + "');";
                stmt.execute(insertOrder);
            }

            for (Drink drink : order.getDrinks()) {
                String insertOrder = "INSERT INTO orders(user, food, type, price, amount) VALUES('" 
                + customer.getName() + "', '" + drink.getName() + "', '"+ drink.getClass().toString()
                +"', '" + drink.getPrice()
                + "', '" + drink.getQuantity() + "');";
                stmt.execute(insertOrder);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    } 

    public static void updateReservation(Customer customer, String progress) {
        String updateSQL = "UPDATE reservations SET progress = '" + progress + "' WHERE user = '" + customer.getName() + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            stmt.execute(updateSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteReservation(Customer customer) {
        String deleteSQL = "DELETE FROM reservations WHERE user = '" + customer.getName() + "';";
        String deleteOrders = "DELETE FROM orders WHERE user = '" + customer.getName() + "';";

        try (Connection conn = DriverManager.getConnection(url); 
            Statement stmt = conn.createStatement();) {

            stmt.execute(deleteSQL);
            stmt.execute(deleteOrders);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
