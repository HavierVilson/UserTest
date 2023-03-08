package ru.iatsuk.usertest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private static final User user = new User("o.metelev2020@yandex.ru", "sky.pro.testing");

    @Test
    public void shouldCreateUserWithTwoParameters(){
        assertFalse(user.getLogin().isEmpty());
        assertFalse(user.getPassword().isEmpty());
    }

    @Test
    public void shouldCreateUserWithoutParameters(){
        assertFalse(new User().canEqual(null));
    }

    @Test
    public void shouldCheckLoginForUser(){
        Assertions.assertTrue(user.getLogin().contains("@") && user.getLogin().contains("."));
    }

    @Test
    public void shouldCheckEqualityForLoginAndPassword(){
        assertNotEquals(user.getLogin(), user.getPassword());
    }

    @Test
    public void shouldCheckCreatingUserForExceptions() throws RuntimeException{
        RuntimeException e = assertThrows(RuntimeException.class, () -> {
            new User("petrov", "petrov");
            new User("", "petrov");
            new User("", "");
        });
        assertNotNull(e.getMessage());
    }
}
