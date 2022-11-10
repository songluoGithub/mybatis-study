package com.mybatis.test.department.dao.impl;

import com.mybatis.test.department.dao.DepartmentDao;
import com.mybatis.test.department.proj.Department;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @date: 2022/11/1 19:17
 * @author: luosong
 * @version: 1.0
 * @description: DepartmentDaoImpl
 */
public class DepartmentDaoImpl implements DepartmentDao {
    private SqlSessionFactory sqlSessionFactory;

    public DepartmentDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Department> findAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectList("departmentMapper.findAll");
        }
    }

    @Override
    public Department findById(String id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("departmentMapper.findById", id);
        }
    }
}
