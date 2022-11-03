package ru.kpfu.net.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import ru.kpfu.net.service.impl.UserServiceImpl;
import ru.kpfu.net.service.UserService;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("login.ftl").forward(req, resp);
    }

    private final UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        String emailOrLogin = req.getParameter("loginName");
        String password = req.getParameter("loginPassword");
        String rememberMe = req.getParameter("loginCheck");
        resp.setContentType("text/html");
        //Требуется проверка на соответствие имейла с паролем
        if (userService.getCheckUserNullability(emailOrLogin,password)) {
            httpSession.setAttribute("emailOrLogin", emailOrLogin);
            httpSession.setMaxInactiveInterval(60 * 60);

            if(rememberMe != null){
                Cookie httpCookie = new Cookie("emailOrLogin", emailOrLogin);
                httpCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(httpCookie);
            }
            resp.sendRedirect("/profile");
        } else {
            req.setAttribute("error", "Invalid login/email or password");
            req.getRequestDispatcher("login.ftl").forward(req, resp);
        }
    }
}
