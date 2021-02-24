package com.dlkyy;
import com.dlkyy.dao.StudentDao;
import com.dlkyy.entity.Student;
import com.dlkyy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by dlkyy on 2021/2/24 21:23
 */
public class TestMain {
  @Test
  public void TestSelectStudent(){
    /**
     *
     * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
     *  getMapper能获取dao接口对于实现类的对象。
     */
    SqlSession sqlSession = MyBatisUtils.getSqlSession();

    StudentDao dao = sqlSession.getMapper(StudentDao.class);

    // dao = com.sun.proxy.$Proxy5
    System.out.println("dao = " + dao.getClass().getName());

    // 调用dao的方法，执行数据库操作
    List<Student> studentList = dao.selectStudent();
    for(Student student : studentList) {
      System.out.println("学生=" + student);
    }
  }
}
