package com.yang.service;

import com.yang.po.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getRoles(Integer pageSize, Integer pageNumber);

    Integer getTotal();

    int delRole(int i);

    int updateRole(int i, String name);

    int addRole(String name);
}
