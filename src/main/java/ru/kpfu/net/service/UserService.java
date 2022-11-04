package ru.kpfu.net.service;

import ru.kpfu.net.dto.UserDTO;
import ru.kpfu.net.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<UserDTO> getAll();


    User getUser(String emailOrLogin) throws SQLException;
    void save(User user);

    boolean getCheckUserNullability(String emailOrLogin, String password);

    boolean checkUserNameExistence(String login);

    int updateUser(User user, String oldEmail) throws SQLException;
}
