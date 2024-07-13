import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class 1th {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "coffee_shop";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "user";
        String password = "password";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement stmt = conn.createStatement();

            String createTableQuery = "CREATE TABLE CoffeeShops ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(50),"
                    + "location VARCHAR(100)"
                    + ")";
            stmt.executeUpdate(createTableQuery);

            String insertDataQuery = "INSERT INTO CoffeeShops (name, location) VALUES "
                    + "('Coffee Shop 1', 'Address 1'),"
                    + "('Coffee Shop 2', 'Address 2')";
            stmt.executeUpdate(insertDataQuery);

            String createMenuTableQuery = "CREATE TABLE CoffeeMenu ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "coffeeShopId INT,"
                    + "itemName VARCHAR(50),"
                    + "price DECIMAL(10, 2)"
                    + ")";
            stmt.executeUpdate(createMenuTableQuery);

            String insertMenuDataQuery = "INSERT INTO CoffeeMenu (coffeeShopId, itemName, price) VALUES "
                    + "(1, 'Espresso', 2.50),"
                    + "(1, 'Latte', 3.00),"
                    + "(2, 'Cappuccino', 3.50)";
            stmt.executeUpdate(insertMenuDataQuery);

            stmt.close();
            conn.close();
            System.out.println("Database created successfully.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


public class 2th {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/coffee_shop";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String createTriggerDrink = "CREATE TRIGGER after_delete_drink " +
                    "AFTER DELETE ON drinks " +
                    "FOR EACH ROW " +
                    "INSERT INTO archive_drinks (drink_id, drink_name) VALUES (OLD.drink_id, OLD.drink_name)";
            statement.execute(createTriggerDrink);

            String createTriggerDessert = "CREATE TRIGGER after_delete_dessert " +
                    "AFTER DELETE ON desserts " +
                    "FOR EACH ROW " +
                    "INSERT INTO archive_desserts (dessert_id, dessert_name) VALUES (OLD.dessert_id, OLD.dessert_name)";
            statement.execute(createTriggerDessert);

            String createTriggerEmployee = "CREATE TRIGGER after_employee_transfer " +
                    "AFTER INSERT ON employee_transfers " +
                    "FOR EACH ROW " +
                    "INSERT INTO transfer_history (employee_id, old_coffee_shop_id, new_coffee_shop_id, transfer_date) " +
                    "VALUES (NEW.employee_id, NEW.old_shop_id, NEW.new_shop_id, NOW())";
            statement.execute(createTriggerEmployee);

            System.out.println("Triggers added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class 3th {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee_shop", "username", "password");

            Statement stmt = conn.createStatement();

            ResultSet allCoffeeShops = stmt.executeQuery("SELECT * FROM coffee_shops");
            while (allCoffeeShops.next()) {
                System.out.println("Coffee Shop Name: " + allCoffeeShops.getString("name"));
            }

            ResultSet allDrinks = stmt.executeQuery("SELECT DISTINCT drink_name FROM drinks");
            while (allDrinks.next()) {
                System.out.println("Drink available in all coffee shops: " + allDrinks.getString("drink_name"));
            }

            ResultSet allDesserts = stmt.executeQuery("SELECT DISTINCT dessert_name FROM desserts");
            while (allDesserts.next()) {
                System.out.println("Dessert available in all coffee shops: " + allDesserts.getString("dessert_name"));
            }

            ResultSet allBaristas = stmt.executeQuery("SELECT * FROM baristas");
            while (allBaristas.next()) {
                System.out.println("Barista Name: " + allBaristas.getString("name"));
            }

            ResultSet allWaiters = stmt.executeQuery("SELECT * FROM waiters");
            while (allWaiters.next()) {
                System.out.println("Waiter Name: " + allWaiters.getString("name"));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class 4th {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeehouse", "username", "password");

            CallableStatement cs1 = conn.prepareCall("{ CALL ShowMostPopularDrink() }");
            cs1.executeQuery();

            CallableStatement cs2 = conn.prepareCall("{ CALL ShowMostPopularDessert() }");
            cs2.executeQuery();

            CallableStatement cs3 = conn.prepareCall("{ CALL ShowTop3Drinks() }");
            cs3.executeQuery();

            CallableStatement cs4 = conn.prepareCall("{ CALL ShowTop3Desserts() }");
            cs4.executeQuery();

            CallableStatement cs5 = conn.prepareCall("{ CALL ShowBaristaInAllLocations() }");
            cs5.executeQuery();

            CallableStatement cs6 = conn.prepareCall("{ CALL AddEmployeeToBlacklist(?) }");
            cs6.setString(1, "EmployeeName");
            cs6.executeQuery();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}