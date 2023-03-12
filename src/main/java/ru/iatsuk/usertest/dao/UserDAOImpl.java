package ru.iatsuk.usertest.dao;

import ru.iatsuk.usertest.model.User;
import ru.iatsuk.usertest.util.exception.AlreadyAddedException;
import ru.iatsuk.usertest.util.exception.NotFoundInDataBaseException;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    public static final String THAT_USER = "That user";

    private final List<User> users;

    public UserDAOImpl() {
        users = new ArrayList<>(List.of(new User("Aleksey"), new User("Semen"),
                new User("Arseniy"), new User("Ivan")));
    }

    @Override
    public User getUserByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name))
                .findAny().orElseThrow(() -> new NotFoundInDataBaseException(THAT_USER));
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User save(User user) {
        if (users.contains(user)) throw new AlreadyAddedException(THAT_USER);
        users.add(user);
        return user;
    }

    @Override
    public User delete(User user) {
        if (!users.contains(user)) throw new NotFoundInDataBaseException(THAT_USER);
        users.remove(user);
        return user;
    }
}
