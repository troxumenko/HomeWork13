package services;

import entities.Client;
import utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private static final String SAVE = "INSERT INTO clients (name, email, phone, about, age) VALUES (?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM clients";
    private static final String UPDATE = "UPDATE clients SET name = ?, email = ?, phone = ?, about = ?, age = ?  WHERE id = ?";
    private static final String DELETE = "DELETE FROM clients WHERE id = ?";
    private static final String GET_CLIENTS_BY_PHONE = "SELECT * FROM clients WHERE phone = ?";
    private static final String GET_CLIENTS_WHERE_EQUAL_ID = "SELECT c.* FROM clients c INNER JOIN accounts a ON c.id = a.client_id";
    private static final String GET_VALUES_FROM_CLIENTS_AND_ACCOUNTS = "SELECT c.name, c.email, s.alias FROM clients c INNER JOIN client_status cs ON c.id = cs.client_id INNER JOIN statuses s ON cs.status_id = s.id WHERE age > 18";

    public void save(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setLong(3, client.getPhone());
            preparedStatement.setString(4, client.getAbout());
            preparedStatement.setInt(5, client.getAge());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getClients() {
        ArrayList<Client> clients = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                Client client = new Client();
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void update(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setLong(3, client.getPhone());
            preparedStatement.setString(4, client.getAbout());
            preparedStatement.setInt(5, client.getAge());
            preparedStatement.setInt(6, client.getId());
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

    public List<Client> getClientsByPhone(long phone) {
        ArrayList<Client> clients = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CLIENTS_BY_PHONE)) {
            preparedStatement.setLong(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getLong("phone"),
                        resultSet.getString("about"),
                        resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<Client> getClientsByEqualId() {
        ArrayList<Client> clients = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CLIENTS_WHERE_EQUAL_ID)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getLong("phone"),
                        resultSet.getString("about"),
                        resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public ArrayList<String> getValuesFromClientsAndAccounts() {
        ArrayList<String> values = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_VALUES_FROM_CLIENTS_AND_ACCOUNTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                values.add("name: " +
                        resultSet.getString("name") + "\nemail: " +
                        resultSet.getString("email") + "\nalias: " +
                        resultSet.getString("alias") + "\n");
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return values;
    }
}
