package com.yang.service.impl;

import com.yang.dao.impl.DeptDaoImpl;
import com.yang.po.Dept;
import com.yang.service.IDeptService;

import java.util.List;

public class DeptServiceImpl implements IDeptService {
    DeptDaoImpl deptDao = new DeptDaoImpl();
    @Override
    public Integer getTotal() {
        return deptDao.getTotal();
    }

    @Override
    public List<Dept> getDepts(Integer pageSize, Integer pageNumber) {
        return deptDao.getDepts(pageSize,pageNumber);
    }

    @Override
    public int delDept(int i) {
        return deptDao.delDept(i);
    }

    @Override
    public int addDept(String name) {
        return deptDao.addDept(name);
    }

    @Override
    public int updateDept(int i, String name) {
        return deptDao.updateDept(i,name);
    }
}
