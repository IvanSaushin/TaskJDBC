package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.List;

/*
    public class UserServiceImpl extends Util сервис не должен
наследоваться от Ютилит, в Ютиле должен быть статитечский метод который возвращает коннекшен.
    B юзер сервисе не должно быть ссылки на коннекшен и мы не должны
в сервисе делать запросов в базу. Запросы делаются в дао, а в сервисе
 мы создаем объект дао и вызываем его методы.
 */
// was:
//public class UserServiceImpl extends Util implements UserService

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoJDBCImpl();

    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
