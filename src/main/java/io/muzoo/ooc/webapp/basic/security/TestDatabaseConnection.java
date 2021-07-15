package io.muzoo.ooc.webapp.basic.security;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(20);
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mariadb://localhost:13306/login_webapp");
        ds.addDataSourceProperty("user", "ssc");
        ds.addDataSourceProperty("password", "hardpass");
        ds.setAutoCommit(false);

        try {
            Connection connection = ds.getConnection();
            String sql = "INSERT INTO tbl_user (username, password, display_name ) VALUES (?, ?, ?);";
            PreparedStatement ps =  connection.prepareStatement(sql);
            //setting username column 1
            ps.setString(1,"my_username");
            ps.setString(2,"my_password");
            ps.setString(3,"my_display_name");
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
