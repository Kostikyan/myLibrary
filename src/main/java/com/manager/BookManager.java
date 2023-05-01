package com.manager;

import com.db.DBConnectionProvider;
import com.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private AuthorManager authorManager = new AuthorManager();
    private UserManager userManager = new UserManager();
    public void save(Book book) {
        String sql = "INSERT INTO `myLibrary`.`book`(`title`, `description`, `price`, `author_id`, `user_id`, `pic_name`) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setInt(3, book.getPrice());
            ps.setInt(4, book.getAuthor().getId());
            ps.setInt(5, book.getUser().getId());
            ps.setString(6, book.getPicName());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if(generatedKeys.next()) {
                book.setId(generatedKeys.getInt(1));
            }
            System.out.println("book inserted into db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getById(int id) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * from `myLibrary`.`book` where `id` = " + id);
            if (resultSet.next()) {
                return getBookFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from `myLibrary`.`book`");
            while (resultSet.next()) {
                books.add(getBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void removeById(int id) {
        String sql = "DELETE FROM `myLibrary`.`book` WHERE `id` = " + id;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Book book) {
        String sql = "UPDATE `myLibrary`.`book` SET `title` = '%s', `description` = '%s', `price` = %d, `author_id` = %d, `pic_name` = '%s'  WHERE `id` = %d";
        try(PreparedStatement statement = connection.prepareStatement(String.format(sql, book.getTitle(), book.getDescription(), book.getPrice(), book.getAuthor().getId(), book.getPicName(), book.getId()))){
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = Book.builder().
                id(resultSet.getInt("id")).
                title(resultSet.getString("title")).
                description(resultSet.getString("description")).
                price(resultSet.getInt("price")).
                author(authorManager.getById(resultSet.getInt("author_id"))).
                user(userManager.getById(resultSet.getInt("user_id"))).
                picName(resultSet.getString("pic_name")).
                build();

        return book;
    }

    public List<Book> search(String searchText) {
        List<Book> books = new ArrayList<>();
        String pattern = "'" + "%"+searchText+"%" + "'";
        try {
            PreparedStatement ps = connection.prepareStatement("Select * from `myLibrary`.`book` where book.title LIKE " + pattern);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                books.add(getBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
