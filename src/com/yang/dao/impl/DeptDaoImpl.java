package com.yang.dao.impl;

import com.yang.dao.IDeptDao;
import com.yang.dao.utils.DBUtils;
import com.yang.po.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements IDeptDao{

    @Override
    public Integer getTotal() {
        Integer total =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst=con.prepareStatement("select count(*) from dept");
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
    public List<Dept> getDepts(Integer pageSize, Integer pageNumber) {
        List<Dept> depts =new ArrayList<>();
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        try {
            pst=con.prepareStatement("select * from dept limit ?,?");
            pst.setInt(1,(pageSize-1)*pageNumber);
            pst.setInt(2,pageNumber);
            rs =pst.executeQuery();
            while(rs.next()){
                Dept dept = new Dept();

                dept.setId(rs.getInt("id"));
                dept.setName(rs.getString("name"));
                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depts;

    }

    @Override
    public int updateDept(int i, String name) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            pst=con.prepareStatement("update dept set NAME =? where id=? ");
            pst.setString(1,name);
            pst.setInt(2,i);
            count =pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int addDept(String name) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            pst=con.prepareStatement("INSERT INTO dept(NAME) VALUE (?) ");
            pst.setString(1,name);
            count =pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    @Override
    public int delDept(int i) {
        Integer count =0;
        Connection con = DBUtils.getConnection();
        PreparedStatement pst =null;
        try {
            pst=con.prepareStatement("delete from dept where id=? ");
            pst.setInt(1,i);
            count =pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
