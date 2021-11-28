package pl.infoshare.model;

import pl.infoshare.service.AddUserService;

public class User  {
    private int id;
    private String name;
    private String surname;
    private Address deliveryAddress;
    private String phoneNumber;
    private String mail;
    private String login;
    private String password;
    private UserType userType;

    public User(String name,String surname, String phoneNumber,
                String mail, String login, String password, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.login = login;
        this.password = password;
        this.userType = userType;
    }
    public User() {
        this.name = "unknown";
        this.mail = "unknown";
        this.password = "unknown";
    }
    public int getId() {return  id;};

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    };

    public void setSurname(String surname) {
    }

    public void setLogin(String login) {
    }

    public String getLogin() {
        return this.login;
    }
}
