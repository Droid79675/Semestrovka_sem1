package ru.kpfu.net.server;

import ru.kpfu.net.model.Car;
import ru.kpfu.net.model.Post;
import ru.kpfu.net.service.CarService;
import ru.kpfu.net.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "postServlet", urlPatterns = "/posts")

public class PostServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> posts = PostService.getPosts();
        req.setAttribute("posts",posts);
        req.getRequestDispatcher("posts.ftl").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String emailOrLogin = (String) httpSession.getAttribute("emailOrLogin");
        if(emailOrLogin != null){
            String name = req.getParameter("postName");
            String content = req.getParameter("postContent");
            Post post = new Post(name, content, emailOrLogin);
            PostService.save(post);
            resp.sendRedirect("/posts");
        }
        else{
            resp.sendRedirect("/login");
        }
    }
}
