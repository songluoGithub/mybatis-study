package com.mybatis.test.department.dao;

import com.mybatis.test.department.proj.Department;

import java.util.List;

/**
 * @date: 2022/11/1 19:17
 * @author: luosong
 * @version: 1.0
 * @description: DepartmentDao
 */
public interface DepartmentDao {
    List<Department> findAll();

    Department findById(String id);
}
