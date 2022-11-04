package ru.kpfu.net.service;

import ru.kpfu.net.dao.CarDao;
import ru.kpfu.net.dao.PostDao;
import ru.kpfu.net.model.Car;
import ru.kpfu.net.model.Post;
import ru.kpfu.net.model.User;
import ru.kpfu.net.util.Helper;

import java.sql.SQLException;
import java.util.List;

public class PostService {

    private static final PostDao postDao = new PostDao();

    public static List<Post> getPosts(){
        List<Post> posts = postDao.getAllPosts();
        return posts;
    }

    public static Post getPost(String name) throws SQLException {
        Post post = postDao.getPostByName(name);
        return post;
    }

    public static void save(Post post) {
        postDao.save(post);
    }
}
