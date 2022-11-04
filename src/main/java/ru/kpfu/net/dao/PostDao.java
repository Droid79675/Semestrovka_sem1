package ru.kpfu.net.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.net.dao.impl.UserDaoImpl;
import ru.kpfu.net.model.Car;
import ru.kpfu.net.model.Post;
import ru.kpfu.net.model.Profile;
import ru.kpfu.net.util.Helper;
import ru.kpfu.net.util.PostgresConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PostDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private static final Connection connection = PostgresConnectUtil.getConnection();

    public static List<Post> getAllPosts() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from post";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Post> posts = new ArrayList<>();

            while (resultSet.next()) {
                Post post = new Post(
                        resultSet.getString("name"),
                        resultSet.getString("content"),
                        resultSet.getString("email")
                );
                posts.add(post);
            }

            return posts;
        } catch (SQLException e) {
            LOGGER.warn("Failed execute get all query", e);
            return Collections.unmodifiableList(new ArrayList<>(Arrays.asList()));
        }
    }

    public static Post getPostByName(String email) throws SQLException {
        String select = "SELECT * FROM post WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(select);
        ps.setString(1, email);
        return extractPost(ps.executeQuery());
    }

    private static Post extractPost(ResultSet rs) throws SQLException {
        Post post = null;
        if (rs.next()) {
            post = new Post(rs.getInt("id"), rs.getString("name"),
                    rs.getString("content"), rs.getString("email"));
        }
        return post;
    }

    public void save(Post post) {
        String sql = "INSERT into post (name, content, email) VALUES (?, ?, ?);";
        createPS(post, sql, connection, LOGGER);
    }

    private static void createPS(Post post, String sql, Connection connection, Logger logger) {
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            setStrings(post, ps);

            ps.executeUpdate();
        } catch (SQLException e) {
            logger.warn("Failed execute save query", e);
        }
    }

    private static void setStrings(Post post, PreparedStatement ps) throws SQLException {
        ps.setString(1, post.getName());
        ps.setString(2, post.getContent());
        ps.setString(3, post.getEmail());

    }
}
