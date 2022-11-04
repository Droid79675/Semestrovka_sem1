package ru.kpfu.net.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import ru.kpfu.net.model.Profile;
import ru.kpfu.net.service.ProfileService;
import ru.kpfu.net.service.impl.ProfileServiceImpl;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    private final ProfileService profileService = new ProfileServiceImpl();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("emailOrLogin") != null){
            String emailOrLogin = (String) httpSession.getAttribute("emailOrLogin");
            try {
                Profile profile = profileService.getProfile(emailOrLogin);
                String[] birthday = profile.getBirthday().split("-");
                String day = birthday[0];
                String month = birthday[1];
                String year = birthday[2];
                req.setAttribute("profile", profile);
                req.setAttribute("day", day);
                req.setAttribute("month", month);
                req.setAttribute("year", year);
                req.getRequestDispatcher("profile.ftl").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
//            String message = "You aren't in system!";
            resp.sendRedirect("/login");

        }

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String edit = req.getParameter("edit");
        if(edit != null){
            req.getRequestDispatcher("editProfile.ftl").forward(req, resp);
        }
        String post = req.getParameter("post");
        if(post != null){
            req.getRequestDispatcher("createPost.ftl").forward(req, resp);
        }
    }

}
