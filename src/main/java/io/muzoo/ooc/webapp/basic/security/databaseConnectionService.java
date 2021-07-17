package io.muzoo.ooc.webapp.basic.security;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class databaseConnectionService {
    private final String jdbcDriver = "org.mariadb.jdbc.Driver";
    private final String jdbcURL = "jdbc:mariadb://localhost:13306/login_webapp"
            + "username =ssc&password=hardpass";
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    public databaseConnectionService() {
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            statement.execute("create table if not exists tbl_user (id int(11) primary key auto_increment, username varchar(255) not null, password varchar(255),  display_name varchar(255))");
            resultSet = statement.executeQuery("select * from login_webapp.tbl_user;");
            if (!resultSet.next()) {
                insert("admin", "root", null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
    }

    public User getUser(String username) {
        for (User user : getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(jdbcURL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from login_webapp.username;");
            while (resultSet.next()) {
                User user = new User(resultSet.getString(2), resultSet.getString(3));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close();
        }
        return users;
    }

        public void insert(String username, String password, String display_name) {
            try {
                connection = DriverManager.getConnection(jdbcURL);
                String query = " insert into tbl_user (username, password, display_name)"
                        + " values (?, ?, ?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                preparedStatement.setString(2, hashedPassword);
                preparedStatement.setString(3, display_name);
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                close();
            }
        }

        public void delete(String username) {
            try {
                connection = DriverManager.getConnection(jdbcURL);
                String query = " delete from tbl_user where username = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public void update(String username, String password, String display_name) {
            try {
                connection = DriverManager.getConnection(jdbcURL);

                String query = " update tbl_user set password = ? where username = ?";
                preparedStatement = connection.prepareStatement(query);
                String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
                preparedStatement.setString(1, hashpw);
//            preparedStatement.setString(1, password);
                preparedStatement.setString(2, username);
                preparedStatement.executeUpdate();

                query = " update tbl_user set display_name = ? where username = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, display_name);
                preparedStatement.setString(2, username);
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                close();
            }
        }

        private void close() {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
            }
        }
    }