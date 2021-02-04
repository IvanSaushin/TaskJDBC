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
        UserServiceImpl userService= new UserServiceImpl();

        // my test
        userService.dropUsersTable();

        userService.createUsersTable();
        userService.saveUser("James", "Smith", (byte) 35);
        userService.saveUser("John", "Travolta", (byte) 46);
        userService.saveUser("Ms", "Smith", (byte) 32);
        users = userService.getAllUsers();
        users.forEach(System.out::println); // 3 user
        System.out.println();

        userService.dropUsersTable();

        userService.createUsersTable();
        userService.saveUser("Ms", "Smith", (byte) 32);
        users = userService.getAllUsers();
        users.forEach(System.out::println); // 1 user
        System.out.println();

        userService.cleanUsersTable();
        users = userService.getAllUsers();
        users.forEach(System.out::println); // // ________
        System.out.println();

        userService.saveUser("Ms", "Smith", (byte) 32);
        userService.saveUser("John", "Travolta", (byte) 46);
        users = userService.getAllUsers();
        users.forEach(System.out::println); // 2 user
        System.out.println();

        userService.removeUserById(1);
        users = userService.getAllUsers();
        users.forEach(System.out::println); // 1 user

    }

}
