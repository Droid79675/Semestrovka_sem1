package ru.kpfu.net.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgresConnectUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostgresConnectUtil.class);
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/testuser";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123Qaws9900";

    private static Connection connection;

    public static Connection getConnection(){
        if(connection == null){
            try{
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
                LOGGER.info("Connection opened!");
            } catch (ClassNotFoundException | SQLException e) {
                LOGGER.info("Connection NOT opened!");
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
