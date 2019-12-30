package com.yang.dao;

import com.yang.po.Role;

import java.util.List;

public interface IRoleDao {
    List<Role> getRoles(Integer pageSize, Integer pageNumber);

    Integer getTotal();

    int delRole(int i);

    int updateRole(int i, String name);

    int addRole(String name);
}
