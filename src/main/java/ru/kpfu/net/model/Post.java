package ru.kpfu.net.model;

public class Post {
    private int id;
    private String name;
    private String content;

    private String email;

    public Post(int id, String name, String content, String email) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.email = email;
    }

    public Post(String name, String content, String email) {
        this.name = name;
        this.content = content;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
