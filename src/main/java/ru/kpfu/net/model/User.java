package ru.kpfu.net.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String login;
    private String password;
    private String birthday;
    private String sex;


    public User(int id, String name, String email, String login, String password, String birthday, String sex) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
    }

    public User(String name, String email, String login, String password, String birthday, String sex) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
