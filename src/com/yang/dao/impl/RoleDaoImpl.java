package com.yang.dao.impl;

import com.yang.dao.IRoleDao;
import com.yang.dao.utils.DBUtils;
import com.yang.po.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements IRoleDao {
    //获取角色列表
    @Override
    public List<Role> getRoles(Integer pageSize, Integer pageNumber) {
        List<Role> roles =new ArrayList<>();
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst=con.prepareStatement("select * from role limit ?,?");
            pst.setInt(1,(pageSize-1)*pageNumber);
            pst.setInt(2,pageNumber);
            rs =pst.executeQuery();
            while(rs.next()){
                Role role = new Role();

              role.setId(rs.getInt("id"));
              role.setName(rs.getString("name"));
              roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Integer getTotal() {
        Integer total =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst=con.prepareStatement("select count(*) from role");
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
    public int delRole(int i) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            pst=con.prepareStatement("delete from role where id=? ");
            pst.setInt(1,i);
            count =pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateRole(int i, String name) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            pst=con.prepareStatement("update role set NAME =? where id=? ");
            pst.setString(1,name);
            pst.setInt(2,i);
            count =pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int addRole(String name) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            pst=con.prepareStatement("INSERT INTO role(NAME) VALUE (?) ");
            pst.setString(1,name);
            count =pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}

