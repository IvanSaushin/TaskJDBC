package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException {
        List<User> users;
        UserServiceImpl userDao= new UserServiceImpl();

        // my test
        userDao.dropUsersTable();

        userDao.createUsersTable();
        userDao.saveUser("James", "Smith", (byte) 35);
        userDao.saveUser("John", "Travolta", (byte) 46);
        userDao.saveUser("Ms", "Smith", (byte) 32);
        users = userDao.getAllUsers();
        users.forEach(System.out::println); // 3 user
        System.out.println();

        userDao.dropUsersTable();

        userDao.createUsersTable();
        userDao.saveUser("Ms", "Smith", (byte) 32);
        users = userDao.getAllUsers();
        users.forEach(System.out::println); // 1 user
        System.out.println();

        userDao.cleanUsersTable();
        users = userDao.getAllUsers();
        users.forEach(System.out::println); // // ________
        System.out.println();

        userDao.saveUser("Ms", "Smith", (byte) 32);
        userDao.saveUser("John", "Travolta", (byte) 46);
        users = userDao.getAllUsers();
        users.forEach(System.out::println); // 2 user
        System.out.println();

        userDao.removeUserById(1);
        users = userDao.getAllUsers();
        users.forEach(System.out::println); // 1 user

    }

}
