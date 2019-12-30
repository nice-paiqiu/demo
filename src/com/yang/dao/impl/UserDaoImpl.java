package com.yang.dao.impl;

import com.yang.dao.IUserDao;
import com.yang.dao.utils.DBUtils;
import com.yang.po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public User login(String username, String password) {
        User user =null;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst=con.prepareStatement("select * from user where username=? and password=? and active=?");
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setInt(3,1);
            rs =pst.executeQuery();
            while(rs.next()){
                user =new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setActive(rs.getInt("active"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Integer getTotal() {
        Integer total =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst=con.prepareStatement("select count(*) from user ");
            rs =pst.executeQuery();
            while(rs.next()){
               total =rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public List<User> getUsers(Integer pageSize, Integer pageNumber) {
        List<User> users =new ArrayList<>();
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst=con.prepareStatement("select * from user limit ?,?");
            pst.setInt(1,(pageSize-1)*pageNumber);
            pst.setInt(2,pageNumber);
            rs =pst.executeQuery();
            while(rs.next()){
              User user =new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setActive(rs.getInt("active"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int deleteUser(int id) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            pst=con.prepareStatement("delete from user where id=? ");
            pst.setInt(1,id);
            count =pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateActive(int id, String caozuo) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            int active=0;
            if("start".equals(caozuo)){
                active=1;
            }
            pst=con.prepareStatement("update user set active=? where id=? ");
            pst.setInt(1,active);
            pst.setInt(2,id);
            count =pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int addUser(User user) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
             pst=con.prepareStatement("insert into user(username,password,fullname,active) values(?,?,?,?)");
             pst.setString(1,user.getUsername());
             pst.setString(2,user.getPassword());
             pst.setString(3,user.getFullname());
             pst.setInt(4,user.getActive());
             count=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateUser(int id, String username, String password, String fullname) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            pst=con.prepareStatement("update user set username=?,password=?,fullname=? where id=?");
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setString(3,fullname);
            pst.setInt(4,id);
            count=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
