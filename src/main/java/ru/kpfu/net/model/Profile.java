package ru.kpfu.net.model;

public class Profile extends User{

    String about;
    String avatar_image;
    public Profile(int id, String name, String email, String login, String password, String birthday, String sex, String avatar_image, String about) {
        super(id, name, email, login, password, birthday, sex);
        this.avatar_image = avatar_image;
        this.about = about;
    }

    public Profile(String name, String email, String login, String password, String birthday, String sex, String about, String avatar_image) {
        super(name, email, login, password, birthday, sex);
        this.about = about;
        this.avatar_image = avatar_image;
    }

    public String getAvatar_image(){
        return avatar_image;
    }

    public String getAbout(){
        return about;
    }
}
