package com.yang.service;

import com.yang.po.User;

import java.util.List;

public interface IUserService {
    User login(String username, String password);

    Integer getTotal();

    List<User> getUsers(Integer pageSize, Integer pageNumber);

    int deleteUser(int id);

    int updateActive(int i, String caozuo);

    int addUser(String username, String password, String fullname);

    int updateUser(int i, String username, String password, String fullname);

}
