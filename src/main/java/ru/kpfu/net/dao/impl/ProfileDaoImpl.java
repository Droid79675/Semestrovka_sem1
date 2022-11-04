package ru.kpfu.net.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.net.dao.Dao;
import ru.kpfu.net.model.Profile;
import ru.kpfu.net.model.User;
import ru.kpfu.net.util.Helper;
import ru.kpfu.net.util.PostgresConnectUtil;
import ru.kpfu.net.util.StringConverter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProfileDaoImpl implements Dao<Profile>{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectUtil.getConnection();

    @Override
    public Profile get(String emailOrLogin) throws SQLException {
        System.out.println(connection.isClosed());
        boolean temp = Helper.checkEmailOrLogin(emailOrLogin);
        String select;
        if(temp){
            select = "SELECT * FROM profile WHERE email = ?;";
        }
        else{
            select = "SELECT * FROM profile WHERE login = ?;";
        }
        PreparedStatement ps = connection.prepareStatement(select);
        ps.setString(1, emailOrLogin);
        ResultSet rs = ps.executeQuery();
        return extractProfile(rs);
    }

    @Override
    public List<Profile> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from profile;";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Profile> profiles = new ArrayList<>();
            while (resultSet.next()) {
                Profile profile = new Profile(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday"),
                        resultSet.getString("sex"),
                        Helper.transphereBytesToString(resultSet.getBytes("avatar_image")),
                        resultSet.getString("about")
                );
                profiles.add(profile);
            }

            return profiles;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            //Нужен аналог List.of для 8 версии java
            return Collections.unmodifiableList(new ArrayList<>(Arrays.asList()));
        }
    }

    @Override
    public void save(Profile profile) {
        String sql = "INSERT into profile (name, email, login, password, birthday, sex, avatar_image, about) VALUES (?, ?, ?, ?, ? ,?, ?, ?);";
        createPS(profile, sql, connection, LOGGER);
    }


    private static void createPS(Profile profile, String sql, Connection connection, Logger logger) {
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            setStrings(profile, ps);

            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Failed execute save query", e);
        }
    }

    @Override
    public int updateModel(Profile profile, String oldEmail) throws SQLException {
        String sql = "UPDATE profile SET name = ?, password = ?, birthday = ?, sex = ?, avatar_image = ?, about = ? WHERE email = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, profile.getName());
        ps.setString(2, profile.getPassword());
        ps.setString(3, profile.getBirthday());
        ps.setString(4, profile.getSex());
        if(!profile.getAvatar_image().equals("")){
            ps.setBytes(5, Helper.transphereStringToBytes(profile.getAvatar_image()));
        }
        else{
            byte[] arr = new byte[0];
            ps.setBytes(5, arr);
        }

        ps.setString(6,profile.getAbout());
        ps.setString(7, oldEmail);
        return ps.executeUpdate();
    }


    private static void setStrings(Profile profile, PreparedStatement ps) throws SQLException {
        ps.setString(1, profile.getName());
        ps.setString(2, profile.getEmail());
        ps.setString(3, profile.getLogin());
        ps.setString(4, profile.getPassword());
        ps.setString(5, profile.getBirthday());
        ps.setString(6, profile.getSex());
        if(!profile.getAvatar_image().equals("")){
            ps.setBytes(7, Helper.transphereStringToBytes(profile.getAvatar_image()));
        }
        else{
            byte[] arr = new byte[0];
            ps.setBytes(7, arr);
        }

        ps.setString(8,profile.getAbout());
    }

    private Profile extractProfile(ResultSet rs) throws SQLException {
        Profile profile = null;
        if (rs.next()) {
            String avatar = StringConverter.convertBase64(rs.getBytes("avatar_image"));
            profile = new Profile(rs.getInt("id"), rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("login"), rs.getString("password"),
                    rs.getString("birthday"), rs.getString("sex"), avatar, rs.getString("about"));
        }
        return profile;
    }

    @Override
    public boolean checkModelNullability(String emailOrLogin, String password) {
        return false;
    }
}
