package com.manager;

import com.db.DBConnectionProvider;
import com.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void save(User user) {
        String sql = "INSERT INTO `myLibrary`.`user`(`name`, `surname`, `email`, `password`) VALUES(?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
            System.out.println("user inserted into db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getById(int id) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * from `myLibrary`.`user` where `id` = " + id);
            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getByEmail(String email) {
        String sql = "Select * from `myLibrary`.`user` where email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User getByEmailAndPassword(String email, String password) {
        String sql = "Select * from `myLibrary`.`user` where `email` = ? AND `password` = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from `myLibrary`.`user`");
            while (resultSet.next()) {
                userList.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void removeById(int userId) {
        String sql = "DELETE FROM `myLibrary`.`user` WHERE `id` = " + userId;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user) {
        String sql = "UPDATE `myLibrary`.`user` SET `name` = '%s', `username` = '%s', `email` = '%s', `password` = '%s'  WHERE `id` = %d";
        try(PreparedStatement statement = connection.prepareStatement(String.format(sql, user.getName(), user.getSurname(), user.getEmail(), user.getPassword()))){
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = User.builder().
            id(resultSet.getInt("id")).
            name(resultSet.getString("name")).
            surname(resultSet.getString("surname")).
            email(resultSet.getString("email")).
            password(resultSet.getString("password")).
        build();

        return user;
    }
}