package ru.kpfu.net.service.impl;

import ru.kpfu.net.dao.Dao;
import ru.kpfu.net.dao.impl.ProfileDaoImpl;
import ru.kpfu.net.model.Profile;
import ru.kpfu.net.service.ProfileService;
import ru.kpfu.net.util.Helper;
import java.sql.SQLException;
import java.util.List;

public class ProfileServiceImpl implements ProfileService {

    private final Dao<Profile> profileDao = new ProfileDaoImpl();


    @Override
    public Profile getProfile(String emailOrLogin) throws SQLException {
        return profileDao.get(emailOrLogin);
    }

    @Override
    public void save(Profile profile) {
        profile.setPassword(Helper.encrypt(profile.getPassword()));
        profileDao.save(profile);
    }

    @Override
    public int updateProfile(Profile profile, String oldEmail) throws SQLException {
        return profileDao.updateModel(profile, oldEmail);
    }
}
