package com.dlkyy;

import com.dlkyy.entity.Student;
import com.dlkyy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


/**
 * Created by dlkyy on 2021/2/23 22:20
 */
public class TestMyBatis {
  // 测试方法
  @Test
  public void testInsert() {
    // 访问mybatis读取Student数据
    // 【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    //【重要】指定要执行的sql语句标识。（sql映射文件中的namespace + "." + 标签id）
    String sqlId = "com.dlkyy.dao.StudentDao" + "." + "insertStudent";
    // 执行sql语句，通过sqlId找到语句
    Student student = new Student(1006, "dlkyy2", "dlkyy2@qq.com", "19");
    int nums = sqlSession.insert(sqlId, student);

    // mybatis默认不是自动提交事务的，所以在insert，update，delete后要手工提交事务
    sqlSession.commit();
    // 8.输出结果
    System.out.println("执行insert结果：" + nums);
    // 9.关闭SqlSession对象
    sqlSession.close();
  }
}
