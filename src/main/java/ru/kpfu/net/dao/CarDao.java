package ru.kpfu.net.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.net.dao.impl.UserDaoImpl;
import ru.kpfu.net.model.Car;
import ru.kpfu.net.model.User;
import ru.kpfu.net.util.PostgresConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private static final Connection connection = PostgresConnectUtil.getConnection();


    public static List<Car> getAllCars() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from car";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getString("name"),
                        resultSet.getString("brand"),
                        resultSet.getString("creationData"),
                        resultSet.getString("enginType"),
                        resultSet.getString("gearBox"),
                        resultSet.getString("gear")
                );
                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return Collections.unmodifiableList(new ArrayList<>(Arrays.asList()));
        }
    }

    public static Car getCarByName(String name) throws SQLException {
        String select = "SELECT * FROM car WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(select);
        ps.setString(1, name);
        return extractCar(ps.executeQuery());
    }

    private static Car extractCar(ResultSet rs) throws SQLException {
        Car car = null;
        if (rs.next()) {
            car = new Car(rs.getInt("id"), rs.getString("name"),
                    rs.getString("brand"),
                    rs.getString("creationData"), rs.getString("enginType"),
                    rs.getString("gearBox"), rs.getString("gear"));
        }
        return car;
    }

}
