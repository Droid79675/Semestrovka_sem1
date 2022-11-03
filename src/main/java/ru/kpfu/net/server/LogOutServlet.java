package ru.kpfu.net.server;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        HttpSession httpSession = req.getSession();

        if(httpSession != null){
            httpSession.invalidate();
        }

        resp.sendRedirect("/login");
    }
}
