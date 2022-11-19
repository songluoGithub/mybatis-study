import dao.DepartmentDao;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import proj.Department;

import java.io.IOException;
import java.io.InputStream;

/**
 * @date: 2022/11/19 9:40
 * @author: luosong
 * @version: 1.0
 * @description: TestCache flushCache会清除全局一级缓存，以及本namespace下的二级缓存
 */
public class TestCache {
    public static void main(String[] args) throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        // 连续两次查询同一个Department
        DepartmentDao departmentDao = sqlSession1.getMapper(DepartmentDao.class);
        Department department1 = departmentDao.findById("53e3803ebbf4f97968e0253e5ad4cc83");
        System.out.println(department1);

        Department department2 = departmentDao.findById("53e3803ebbf4f97968e0253e5ad4cc83");
        System.out.println("department1 == department2："+(department1==department2));
        // 关闭sqlSession，查询结果持久化到二级缓存中
        sqlSession1.close();

        // 再次开启SqlSession
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        DepartmentDao departmentMapper2 = sqlSession2.getMapper(DepartmentDao.class);
        // 再次查询Department
        Department department3 = departmentMapper2.findById("53e3803ebbf4f97968e0253e5ad4cc83");
        departmentMapper2.findAll();

        UserDao userMapper = sqlSession2.getMapper(UserDao.class);
        // 触发缓存清除
        userMapper.cleanCache();
        System.out.println("==================cleanCache====================");

        // 再次查询Department
        Department department4 = departmentMapper2.findById("53e3803ebbf4f97968e0253e5ad4cc83");
        // 每次从二级缓存中取到的对象是深拷贝对象（序列化与反序列化影响），所以内存地址不一致
        System.out.println("department3 == department4 : " + (department3 == department4));

        sqlSession2.close();
    }
}
