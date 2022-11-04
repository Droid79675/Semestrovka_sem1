package ru.kpfu.net.dto;

public class UserDTO {
    private String name;
    private String email;
    private String login;

    public UserDTO(String name, String email, String login) {
        this.name = name;
        this.email = email;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }
}
