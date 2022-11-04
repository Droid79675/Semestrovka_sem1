package ru.kpfu.net.service;

import ru.kpfu.net.dao.CarDao;
import ru.kpfu.net.model.Car;

import java.sql.SQLException;
import java.util.List;

public class CarService {
    private static final CarDao carDao = new CarDao();

    public static List<Car> getCars(){
        List<Car> cars = carDao.getAllCars();
        return cars;
    }

    public static Car getCar(String name) throws SQLException {
        Car car = carDao.getCarByName(name);
        return car;
    }
}
