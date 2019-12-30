package com.yang.dao;

import com.yang.po.Dept;

import java.util.List;

public interface IDeptDao {
    Integer getTotal();

    List<Dept> getDepts(Integer pageSize, Integer pageNumber);

    int updateDept(int i, String name);

    int addDept(String name);

    int delDept(int i);
}
