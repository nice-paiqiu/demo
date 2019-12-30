package com.yang.service.impl;

import com.yang.dao.impl.RoleDaoImpl;
import com.yang.po.Role;
import com.yang.service.IRoleService;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    RoleDaoImpl roleDao = new RoleDaoImpl();
    @Override
    public List<Role> getRoles(Integer pageSize, Integer pageNumber) {
        return roleDao.getRoles(pageSize,pageNumber);
    }

    @Override
    public Integer getTotal() {
        return roleDao.getTotal();
    }

    @Override
    public int delRole(int i) {
        return roleDao.delRole(i);
    }

    @Override
    public int updateRole(int i, String name) {
        return roleDao.updateRole(i,name);
    }

    @Override
    public int addRole(String name) {
        return roleDao.addRole(name);
    }
}
