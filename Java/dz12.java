import java.sql.*;

public class CarDatabase {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:car_database.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS Cars (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "manufacturer TEXT NOT NULL, " +
                    "model TEXT NOT NULL, " +
                    "engine_volume REAL, " +
                    "year INTEGER, " +
                    "color TEXT, " +
                    "type TEXT)");

            String insertQuery = "INSERT INTO Cars (manufacturer, model, engine_volume, year, color, type) " +
                    "VALUES ('Toyota', 'Corolla', 1.8, 2020, 'White', 'Sedan')";
            stmt.executeUpdate(insertQuery);

            ResultSet rs = stmt.executeQuery("SELECT * FROM Cars");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " +
                        rs.getString("manufacturer") + ", " +
                        rs.getString("model") + ", " +
                        rs.getDouble("engine_volume") + ", " +
                        rs.getInt("year") + ", " +
                        rs.getString("color") + ", " +
                        rs.getString("type"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}