package com.dlkyy;

import com.dlkyy.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/23 21:23
 */
public class MyApp {
  public static void main(String[] args) throws IOException {
    // 访问mybatis读取Student数据
    // 1.定义mybatis主配置文件的名，从类路径的根开始
    String config = "mybatis.xml";
    // 2.读取这个config表示的文件
    InputStream in = Resources.getResourceAsStream(config);
    // 3.创建SqlSessionFactoryBuilder对象
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    // 4.创建SqlSessionFactory对象
    SqlSessionFactory factory = builder.build(in);// 重量级，一个项目只创建一次
    // 5.【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
    SqlSession sqlSession = factory.openSession();
    // 6.【重要】指定要执行的sql语句标识。（sql映射文件中的namespace + "." + 标签id）
    String sqlId = "com.dlkyy.dao.StudentDao" + "." + "selectStudents";
    // 7.执行sql语句，通过sqlId找到语句
    List<Student> studentList = sqlSession.selectList(sqlId);
    // 8.输出结果
    //studentList.forEach(stu -> System.out.println(stu));
    studentList.forEach(System.out::println);
    // 9.关闭SqlSession对象
    sqlSession.close();
  }
}
