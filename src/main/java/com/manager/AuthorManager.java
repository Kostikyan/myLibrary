package com.manager;

import com.db.DBConnectionProvider;
import com.model.Author;
import com.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void save(Author author) {
        String sql = "INSERT INTO `myLibrary`.`author`(`name`, `surname`, `email`, `age`) VALUES(?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, author.getName());
            ps.setString(2, author.getSurname());
            ps.setString(3, author.getEmail());
            ps.setInt(4, author.getAge());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
                author.setId(generatedKeys.getInt(1));
            }
            System.out.println("author inserted into db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Author getById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("Select * from `myLibrary`.`author` where `id` = " + id)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getAuthorFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Author> getAll() {
        List<Author> authorList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from `myLibrary`.`author`");
            while (resultSet.next()) {
                authorList.add(getAuthorFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    public Author getByEmail(String email) {
        String sql = "Select * from `myLibrary`.`author` where email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getAuthorFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void removeById(int id) {
        String sql = "DELETE FROM `myLibrary`.`author` WHERE `id` = " + id;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Author author) {
        String sql = "UPDATE `myLibrary`.`author` SET `name` = '%s', `surname` = '%s', `email` = '%s', `age` = %d  WHERE `id` = %d";
        try(PreparedStatement statement = connection.prepareStatement(String.format(sql, author.getName(), author.getSurname(), author.getEmail(), author.getAge(), author.getId()))){
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Author getAuthorFromResultSet(ResultSet resultSet) throws SQLException {
        Author author = Author.builder().
                id(resultSet.getInt("id")).
                name(resultSet.getString("name")).
                surname(resultSet.getString("surname")).
                email(resultSet.getString("email")).
                age(resultSet.getInt("age")).
                build();

        return author;
    }
}
