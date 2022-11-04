package ru.kpfu.net.server;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.TemplateException;
import ru.kpfu.net.service.ProfileService;
import ru.kpfu.net.service.impl.UserServiceImpl;
import ru.kpfu.net.service.UserService;
import ru.kpfu.net.model.User;
import ru.kpfu.net.model.Profile;
import ru.kpfu.net.service.impl.ProfileServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;
import ru.kpfu.net.util.StringConverter;


@WebServlet(name="registrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private final ProfileService profileService = new ProfileServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("register.ftl").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        resp.setContentType("text/html");

        String name=req.getParameter("registerName");
        String login=req.getParameter("registerUsername");
        String email=req.getParameter("registerEmail");
        String password=req.getParameter("registerPassword");
        String repeatPassword=req.getParameter("registerRepeatPassword");
        String day = req.getParameter("registerDay");
        String month = req.getParameter("registerMonth");
        String year = req.getParameter("registerYear");
        String sex = req.getParameter("sex");


        if(!userService.checkUserNameExistence(login)){
            if(password.equals(repeatPassword)){
                String birthday = String.format("%s-%s-%s", day, month, year);
                User user = new User(name,email,login,password,birthday,sex);
                userService.save(user);
                //String content = Files.readString(path, encoding);
                //byte[] encoded = Files.readAllBytes(Paths.get(path));
                Profile profile = new Profile(name, email, login, password, birthday, sex,"", "");
                profileService.save(profile);

                resp.sendRedirect("/login");
            }

            else{
                String message = "Registration failed! Passwords does not match!";
                req.setAttribute("message", message);
                req.getRequestDispatcher("register.ftl").forward(req, resp);
            }
        }
        else{
            String message = "Registration failed! This username already exists";
            req.setAttribute("message", message);
            req.getRequestDispatcher("register.ftl").forward(req, resp);
        }

    }



}
