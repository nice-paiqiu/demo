package com.yang.service.impl;

import com.yang.dao.IUserDao;
import com.yang.dao.impl.UserDaoImpl;
import com.yang.po.User;
import com.yang.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao =new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public Integer getTotal() {
        return userDao.getTotal();
    }

    @Override
    public List<User> getUsers(Integer pageSize, Integer pageNumber) {
        return userDao.getUsers(pageSize,pageNumber);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public int updateActive(int id, String caozuo) {
        return userDao.updateActive(id,caozuo);
    }

    @Override
    public int addUser(String username, String password, String fullname) {
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setActive(1);
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(int id, String username, String password, String fullname) {
        return userDao.updateUser(id,username,password,fullname);
    }

}
