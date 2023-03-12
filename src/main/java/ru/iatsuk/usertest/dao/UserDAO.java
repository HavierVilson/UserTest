package ru.iatsuk.usertest.dao;

import ru.iatsuk.usertest.model.User;

import java.util.List;

public interface UserDAO {
    User getUserByName(String name);

    List<User> findAllUsers();

    User save(User user);

    User delete(User user);
}
