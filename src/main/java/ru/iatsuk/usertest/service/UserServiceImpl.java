package ru.iatsuk.usertest.service;

import ru.iatsuk.usertest.dao.UserDAO;
import ru.iatsuk.usertest.model.User;
import ru.iatsuk.usertest.util.exception.NotFoundInDataBaseException;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean checkUserExist(User user) {
        try {
            userDAO.getUserByName(user.getName());
        } catch (NotFoundInDataBaseException e) {
            return false;
        }
        return true;
    }
}
