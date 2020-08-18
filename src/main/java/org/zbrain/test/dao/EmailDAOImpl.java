package org.zbrain.test.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.*;

@Repository
public class EmailDAOImpl implements EmailDAO {

    @Value("${mariadb.url}")
    private String dbUrl;
    @Value("${mariadb.username}")
    private String username;
    @Value("${mariadb.password}")
    private String password;

    @Override
    public boolean checkOrAddEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection(dbUrl, username, password);

            statement = connection.prepareStatement("select email from email where email=? limit 1");

            statement.setString(1, email);

            resultSet = statement.executeQuery();

            if (resultSet != null && resultSet.next()) {
                return false;
            } else {
                statement = connection.prepareStatement("insert into email (email) values (?)");
                statement.setString(1, email);

                statement.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @PostConstruct
    void init() {
        try {
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
