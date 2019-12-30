package com.yang.service;

import com.yang.po.Dept;

import java.util.List;

public interface IDeptService {
    Integer getTotal();

    List<Dept> getDepts(Integer pageSize, Integer pageNumber);

    int delDept(int i);

    int addDept(String name);

    int updateDept(int i, String name);
}
