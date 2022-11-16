

import dao.DepartmentDao;
import dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import proj.Department;
import proj.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class MyTest {
    public static void main(String[] args) throws IOException {
        // 借助类加载器初始化xml
        InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");

        // 编程式加载配置文件
        Properties properties = Resources.getResourceAsProperties("application.properties");

        // 同样可以借助Resources.getResourceAsStream加载properties文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml,properties);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 动态代理获取实例对象
        DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
        List<Department> departmentList = departmentDao.findAll();
        departmentList.forEach(System.out::println);

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> allLazy = userDao.findAllLazy();
        allLazy.forEach(System.out::println);
    }
}
