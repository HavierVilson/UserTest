package ru.iatsuk.usertest.service;

import ru.iatsuk.usertest.model.User;

public interface UserService {
    boolean checkUserExist(User user);
}
