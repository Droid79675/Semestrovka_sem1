package ru.kpfu.net.server;

import ru.kpfu.net.model.Car;
import ru.kpfu.net.service.CarService;
import ru.kpfu.net.service.UserService;
import ru.kpfu.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "carServlet", urlPatterns = "/cars")

public class CarServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = CarService.getCars();
        req.setAttribute("cars",cars);
        req.getRequestDispatcher("cars.ftl").forward(req, resp);
    }

}
