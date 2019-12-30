package com.yang.dao;

import com.yang.po.User;

import java.util.List;

public interface IUserDao {
    User login(String username, String password);

    Integer getTotal();

    List<User> getUsers(Integer pageSize, Integer pageNumber);

    int deleteUser(int id);

    int updateActive(int id, String caozuo);

    int addUser(User user);

    int updateUser(int id, String username, String password, String fullname);

}
