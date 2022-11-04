package ru.kpfu.net.server;

import org.checkerframework.checker.units.qual.C;
import ru.kpfu.net.model.Car;
import ru.kpfu.net.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "searchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    CarService carService = new CarService();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        try {
            Car car = carService.getCar(search);
            if(car != null){
                req.setAttribute("car", car);
                req.getRequestDispatcher("car.ftl").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
