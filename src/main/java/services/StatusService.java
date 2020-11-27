package services;

import entities.Status;
import utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusService {

    private static final String SAVE = "INSERT INTO statuses (alias, description) VALUES (?,?)";
    private static final String GET_ALL = "SELECT * FROM statuses";
    private static final String UPDATE = "UPDATE statuses SET alias = ?, description = ?  WHERE id = ?";
    private static final String DELETE = "DELETE FROM statuses WHERE id = ?";

    public void save(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            preparedStatement.setString(1, status.getAlias());
            preparedStatement.setString(2, status.getDescription());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Status> getStatuses() {
        ArrayList<Status> statuses = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                Status status = new Status();
                status.setAlias(resultSet.getString("alias"));
                status.setDescription(resultSet.getString("description"));
                statuses.add(status);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    public void update(Status status) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, status.getAlias());
            preparedStatement.setString(2, status.getDescription());
            preparedStatement.setInt(3, status.getId());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
