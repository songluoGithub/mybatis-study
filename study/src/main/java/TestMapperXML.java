import dao.Dept2Dao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import proj.Dept;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @date: 2022/11/19 15:52
 * @author: luosong
 * @version: 1.0
 * @description: TestMapperXML  测试xml标签内容
 */
public class TestMapperXML {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Dept2Dao dept2Dao = sqlSession.getMapper(Dept2Dao.class);
//        Dept dept = new Dept();
//        dept.setName("张三");
//        dept.setTel("1001");
//
//        // 不会自动填充id属性
//        dept2Dao.save(dept);
//        sqlSession.commit();
//        System.out.println(dept);
//
//        Dept dept2 = new Dept();
//        dept2.setName("张三");
//        dept2.setTel("1001");
//        // 可以自动填充id值
//        dept2Dao.save2(dept2);
//        System.out.println(dept2);

        System.out.println("=====================================");
        List<Dept> allByName = dept2Dao.findAllByName2("2");
        allByName.forEach(System.out::println);
        sqlSession.close();
    }
}
