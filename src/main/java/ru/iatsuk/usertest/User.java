package ru.iatsuk.usertest;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Getter
@Data
@NoArgsConstructor
public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        if (!Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").matcher(login).matches()) {
            throw new RuntimeException("Login should be match email pattern");
        }
        if (password.length() < 10) throw new RuntimeException("Password's length should be more than 10 chars");
        this.login = login;
        this.password = password;
    }
}
