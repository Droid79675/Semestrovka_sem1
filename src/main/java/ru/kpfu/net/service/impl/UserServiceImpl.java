package ru.kpfu.net.service.impl;

import ru.kpfu.net.dao.Dao;
import ru.kpfu.net.dao.impl.UserDaoImpl;
import ru.kpfu.net.dto.UserDTO;
import ru.kpfu.net.model.User;
import ru.kpfu.net.service.UserService;
import ru.kpfu.net.util.Helper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final Dao<User> userDao = new UserDaoImpl();


    @Override
    public List<UserDTO> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDTO(u.getName(), u.getEmail(), u.getLogin())
        ).collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        user.setPassword(Helper.encrypt(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public boolean getCheckUserNullability(String emailOrLogin, String password){

        boolean temp = userDao.checkModelNullability(emailOrLogin ,password);
        if(temp){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkUserNameExistence(String login){
        List<User> users = userDao.getAll();
        for(User u: users){
            if(u.getLogin() == login){
                return true;
            }
        }
        return false;
    }
    @Override
    public User getUser(String emailOrLogin) throws SQLException {
        return userDao.get(emailOrLogin);
    }

    @Override
    public int updateUser(User user, String oldEmail) throws SQLException {
        return userDao.updateModel(user, oldEmail);
    }

}
