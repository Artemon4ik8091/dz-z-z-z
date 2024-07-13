import java.sql.*;

public class CoffeeShopDatabase {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/CoffeeShop";
    static final String USER = "root";
    static final String PASS = "password";
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sqlAddCoffeeOrder = "INSERT INTO CoffeeOrders (coffeeType, quantity) VALUES ('Latte', 2)";
            stmt.executeUpdate(sqlAddCoffeeOrder);

            String sqlAddDessertOrder = "INSERT INTO DessertOrders (dessertType, quantity) VALUES ('Cheesecake', 1)";
            stmt.executeUpdate(sqlAddDessertOrder);

            String sqlAddMondaySchedule = "INSERT INTO Schedule (day, openingTime, closingTime) VALUES ('Monday', '08:00', '18:00')";
            stmt.executeUpdate(sqlAddMondaySchedule);

            String sqlAddNewCoffeeType = "INSERT INTO CoffeeTypes (typeName, description) VALUES ('Cappuccino', 'Espresso-based coffee topped with steamed milk foam')";
            stmt.executeUpdate(sqlAddNewCoffeeType);

            String updateScheduleQuery = "UPDATE schedule SET working_days = 'Tuesday' WHERE id = 1";
            executeQuery(connection, updateScheduleQuery);

            String updateCoffeeNameQuery = "UPDATE coffees SET name = 'New Coffee Name' WHERE id = 1";
            executeQuery(connection, updateCoffeeNameQuery);

            String updateOrderInfoQuery = "UPDATE orders SET info = 'Updated Information' WHERE id = 1";
            executeQuery(connection, updateOrderInfoQuery);

            String updateDessertNameQuery = "UPDATE desserts SET name = 'New Dessert Name' WHERE id = 1";
            executeQuery(connection, updateDessertNameQuery);

            String query = "DELETE FROM orders WHERE id = 1";
            statement.executeUpdate(query);

            String query = "DELETE FROM orders WHERE dessert = 'Dessert'";
            statement.executeUpdate(query);

            String query = "DELETE FROM work_schedule WHERE day = 'day'";
            statement.executeUpdate(query);

            String query = "DELETE FROM work_schedule WHERE date BETWEEN 'startdate' AND 'enddate'";
            statement.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}