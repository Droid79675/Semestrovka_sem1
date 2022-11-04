package ru.kpfu.net.service;

import ru.kpfu.net.model.Profile;

import java.sql.SQLException;

public interface ProfileService {

    //List<UserDTO> getAll();

    Profile getProfile(String emailOrLogin) throws SQLException;

    void save(Profile profile);

    int updateProfile(Profile profile, String oldEmail) throws SQLException;
}
