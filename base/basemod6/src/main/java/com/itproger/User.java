package com.itproger;

public class User {
    private String login;
    private String email;

    public User(String login, String email) {
        setLogin(login); // Используем сеттер
        setEmail(email); // Используем сеттер
    }

    private boolean isValidEmail(String email) {
        // Проверка на корректность email
        // true если email корректный, иначе false
        return email != null && email.contains("@") && email.contains(".");
    }

    public String getLogin() {
        return login;
    }

    //если логин не null и имеет длину не менее 5 символов,то логин устанавливается, иначе null
    public void setLogin(String login) {
        if (login != null && login.length() >= 5) {
            this.login = login;
        } else {
            this.login = null;
        }
    }

    public String getEmail() {
        return email;
    }

    //если email соответствует валидации то он устанавливается, иначе null
    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            this.email = null;
        }
    }
}
