package dao;

import proj.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> findAll();

    Department findById(String id);
}
