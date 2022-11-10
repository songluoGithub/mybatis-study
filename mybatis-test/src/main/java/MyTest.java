import com.mybatis.test.department.dao.DepartmentDao;
import com.mybatis.test.department.dao.impl.DepartmentDaoImpl;
import com.mybatis.test.department.proj.Department;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @date: 2022/7/11 10:31
 * @author: luosong
 * @version: 1.0
 * @description: MyTest
 */
public class MyTest {
    public static void main(String[] args) throws IOException {
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DepartmentDao departmentDao = new DepartmentDaoImpl(sqlSessionFactory);
        List<Department> departmentList = departmentDao.findAll();
        departmentList.forEach(System.out::println);
    }
}
