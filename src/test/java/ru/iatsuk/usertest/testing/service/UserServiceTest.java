package ru.iatsuk.usertest.testing.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.iatsuk.usertest.dao.UserDAOImpl;
import ru.iatsuk.usertest.model.User;
import ru.iatsuk.usertest.service.UserServiceImpl;
import ru.iatsuk.usertest.util.exception.NotFoundInDataBaseException;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserDAOImpl userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    private static final User IVAN = new User("Ivan");

    private static final User MEFODIY = new User("Mefodiy");



    @Test
    void shouldReturnTrueGetUserByName() {
        when(userDAO.getUserByName(IVAN.getName())).thenReturn(IVAN);
        Assertions.assertTrue(userService.checkUserExist(IVAN));
    }

    @Test
    void shouldThrowExceptionNotFoundInDataBase(){
        when(userDAO.getUserByName(MEFODIY.getName())).thenThrow(NotFoundInDataBaseException.class);
        Assertions.assertFalse(userService.checkUserExist(MEFODIY));
    }
}
