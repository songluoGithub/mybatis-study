package dao;

import jdk.nashorn.internal.ir.LiteralNode;
import org.apache.ibatis.annotations.Param;
import proj.Dept;

import java.util.List;

/**
 * @date: 2022/11/19 15:49
 * @author: luosong
 * @version: 1.0
 * @description: Dept2
 */
public interface Dept2Dao {
    void save(Dept dept);

    void save2(Dept dept);

    /**
     * 单个参数需要采用@Param指定，不然报错（There is no getter for property named 'likeName' in 'class java.lang.String'）
     * @param likeName
     * @return
     */
    List<Dept> findAllByName(@Param("likeName") String likeName);

    /**
     * 采用bind绑定
     * @param likeName
     * @return
     */
    List<Dept> findAllByName2(@Param("likeName") String likeName);
}
