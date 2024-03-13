package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventDao {
    private String connectionString; // Connection string for your database

    public EventDao(String connectionString) {
        this.connectionString = connectionString;
    }

    public void addEvent(String name, String location, String notes) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String query = "INSERT INTO Events (Name, Location, Notes) VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, location);
            pst.setString(3, notes);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editEvent(int eventId, String name, String location, String notes) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String query = "UPDATE Events SET Name = ?, Location = ?, Notes = ? WHERE EventID = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, location);
            pst.setString(3, notes);
            pst.setInt(4, eventId);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int eventId) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String query = "DELETE FROM Events WHERE EventID = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, eventId);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}