package ru.kpfu.net.server;

import ru.kpfu.net.model.Profile;
import ru.kpfu.net.model.User;
import ru.kpfu.net.service.ProfileService;
import ru.kpfu.net.service.UserService;
import ru.kpfu.net.service.impl.ProfileServiceImpl;
import ru.kpfu.net.service.impl.UserServiceImpl;
import ru.kpfu.net.util.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@WebServlet(name = "updateProfileServlet", urlPatterns = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet{
    private final UserService userService = new UserServiceImpl();
    private final ProfileService profileService = new ProfileServiceImpl();


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        String name = req.getParameter("profileName");
        String login = req.getParameter("profileLogin");
        String password = req.getParameter("profilePassword");
        String day = req.getParameter("profileDay");
        String month = req.getParameter("profileMonth");
        String year = req.getParameter("profileYear");
        String sex = req.getParameter("sex");
        String birthday = String.format("%s-%s-%s", day, month, year);

        try {
            Part avatarFile = req.getPart("profileAvatar");

            String about = req.getParameter("profileAbout");
            Helper.createFile(avatarFile, req);

            String avatar = Helper.transphereFileToString(avatarFile);
            String oldEmail = (String) httpSession.getAttribute("emailOrLogin");
            User user = new User(name, oldEmail, login, password, birthday, sex);
            Profile profile = new Profile(name, oldEmail, login, password, birthday, sex, avatar, about);
            if (userService.updateUser(user, oldEmail) == 6 && profileService.updateProfile(profile, oldEmail) == 8) {
                req.getRequestDispatcher("profile.ftl").forward(req, resp);
                System.out.println("ok");
            } else {
                System.out.println("fuck");
                req.getRequestDispatcher("editProfile.ftl").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
