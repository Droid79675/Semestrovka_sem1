package ru.kpfu.net.dao;

import ru.kpfu.net.model.User;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    T get(String emailOrLogin) throws SQLException;

    List<T> getAll();
    void save(T t);

    boolean checkModelNullability(String emailOrLogin, String password);

    int updateModel(T t, String oldEmail) throws SQLException;
}
