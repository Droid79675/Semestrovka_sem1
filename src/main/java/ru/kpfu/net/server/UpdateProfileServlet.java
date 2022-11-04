package ru.kpfu.net.server;

import ru.kpfu.net.model.Profile;
import ru.kpfu.net.model.User;
import ru.kpfu.net.service.ProfileService;
import ru.kpfu.net.service.UserService;
import ru.kpfu.net.service.impl.ProfileServiceImpl;
import ru.kpfu.net.service.impl.UserServiceImpl;
import ru.kpfu.net.util.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.servlet.http.*;
import java.sql.SQLException;
@MultipartConfig


@WebServlet(name = "updateProfileServlet", urlPatterns = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final ProfileService profileService = new ProfileServiceImpl();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        String name = req.getParameter("profileName");
        String password = req.getParameter("profilePassword");
        String day = req.getParameter("profileDay");
        String month = req.getParameter("profileMonth");
        String year = req.getParameter("profileYear");
        String sex = req.getParameter("sex");
        String birthday = String.format("%s-%s-%s", day, month, year);
        Part avatarFile = req.getPart("profileAvatar");
        try {

            String about = req.getParameter("profileAbout");
            Helper.createFile(avatarFile);

            String avatar = Helper.transphereFileToString(avatarFile);
            String oldEmail = (String) httpSession.getAttribute("emailOrLogin");
            User user = new User(name, oldEmail, password, birthday, sex);
            Profile profile = new Profile(name, oldEmail, password, birthday, sex, avatar, about);
            if (userService.updateUser(user, oldEmail) == 1 && profileService.updateProfile(profile, oldEmail) == 1) {
                resp.sendRedirect("/profile");
            } else {
                req.getRequestDispatcher("editProfile.ftl").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
