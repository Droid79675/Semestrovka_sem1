package ru.kpfu.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.net.dao.Dao;
import ru.kpfu.net.model.User;
import ru.kpfu.net.util.PostgresConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ru.kpfu.net.util.Helper;

public class UserDaoImpl implements Dao<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectUtil.getConnection();


    @Override
    public User get(String emailOrLogin) throws SQLException {
        boolean temp = Helper.checkEmailOrLogin(emailOrLogin);
        String sql;
        if(temp){
            sql = "SELECT * FROM users WHERE email = ?;";
        }
        else{
            sql = "SELECT * FROM users WHERE login = ?;";
        }
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, emailOrLogin);
        ResultSet rs = ps.executeQuery();
        return extractUser(rs);
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user = null;
        if (rs.next()) {
            user = new User(rs.getInt("id"), rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("login"), rs.getString("password"),
                    rs.getString("birthday"), rs.getString("sex"));
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from users;";
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday"),
                        resultSet.getString("sex")
                        );
                users.add(user);
            }

            return users;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            //Нужен аналог List.of для 8 версии java
            return Collections.unmodifiableList(new ArrayList<>(Arrays.asList()));
        }
    }

    @Override
    public void save(User user) {
        String sql = "INSERT into users (name, email, login, password, birthday, sex) VALUES (?, ?, ?, ?, ? ,?);";
        createPS(user, sql, connection, LOGGER);
    }

    private static void createPS(User user, String sql, Connection connection, Logger logger) {
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            setStrings(user, ps);

            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Failed execute save query", e);
        }
    }

    public static void setStrings(User user, PreparedStatement ps) throws SQLException {
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getLogin());
        ps.setString(4, user.getPassword());
        ps.setString(5, user.getBirthday());
        ps.setString(6, user.getSex());
    }

    public User checkLogin(String emailOrLogin, String password){

        String sql = "SELECT * FROM users WHERE email = ? and password = ?;";
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailOrLogin);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if(Helper.checkEmailOrLogin(emailOrLogin)){
                if (resultSet.next()) {
                    user = new User(" ",emailOrLogin,"",password,"","");
                }
            }
            else{
                if (resultSet.next()) {
                    user = new User("","",emailOrLogin,password,"","");
                }
            }


            return user;

        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }
        return user;
    }

    @Override
    public boolean checkModelNullability(String emailOrLogin, String password) {
        User user = checkLogin(emailOrLogin, password);
        if(user != null){
            return true;
        }
        return false;
    }
    @Override
    public int updateModel(User user, String oldEmail) throws SQLException {
        String sql = "UPDATE users SET name = ?, login = ?, password = ?, birthday = ?, sex = ? WHERE email = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getLogin());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getBirthday());
        ps.setString(5, user.getSex());
        ps.setString(6, oldEmail);
        int temp = ps.executeUpdate();
        System.out.println(temp);
        return temp;
    }


}
