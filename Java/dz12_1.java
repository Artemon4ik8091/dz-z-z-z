
import java.sql.*;

public class CarDatabaseApp {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/car_database";
        String user = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database.");

            // Отображение всего содержимого таблицы с автомобилями
            Statement statement = connection.createStatement();
            ResultSet carsResultSet = statement.executeQuery("SELECT * FROM cars");
            while (carsResultSet.next()) {
                System.out.println(carsResultSet.getString("car_name"));
            }

            // Показать всех производителей автомобилей
            ResultSet manufacturersResultSet = statement.executeQuery("SELECT DISTINCT manufacturer FROM cars");
            while (manufacturersResultSet.next()) {
                System.out.println(manufacturersResultSet.getString("manufacturer"));
            }

            // Показать названия производителей и количество автомобилей каждого производителя
            ResultSet countResultSet = statement.executeQuery("SELECT manufacturer, COUNT(*) as car_count FROM cars GROUP BY manufacturer");
            while (countResultSet.next()) {
                System.out.println(countResultSet.getString("manufacturer") + " - " + countResultSet.getInt("car_count") + " cars");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}