package dao;

import proj.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    List<User> findAllLazy();
}
