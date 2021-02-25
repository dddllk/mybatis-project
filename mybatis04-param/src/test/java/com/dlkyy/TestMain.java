package com.dlkyy;
import com.dlkyy.dao.StudentDao;
import com.dlkyy.entity.Student;
import com.dlkyy.utils.MyBatisUtils;
import com.dlkyy.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dlkyy on 2021/2/24 21:23
 */
public class TestMain {
  @Test
  public void selectStudentById(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();

    StudentDao dao = sqlSession.getMapper(StudentDao.class);

    // dao = com.sun.proxy.$Proxy5
    System.out.println("dao = " + dao.getClass().getName());

    // 调用dao的方法，执行数据库操作
     Student student = dao.selectStudentById(1002);

     // 输出
    System.out.println("student=" + student);
  }

  // 传递多个参数
  @Test
  public void selectMultiParam(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    List<Student> stu = dao.selectMultiParam("ll", 16);
    for(Student student : stu) {
      System.out.println(student);
    }
  }
  // 传递多个参数---方式2
  @Test
  public void selectMultiObjects(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    QueryParam param = new QueryParam("ll", 16);
    List<Student> stu = dao.selectMultiObjects(param);
    for(Student student : stu) {
      System.out.println(student);
    }
  }
  // 传递多个参数---按位置传值
  @Test
  public void selectMultiPosition(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    List<Student> list = dao.selectMultiPosition("dd", 16);
    for(Student student : list) {
      System.out.println(student);
    }
    sqlSession.close();
  }

  // 传递多个参数---使用Map
  public void selectMultiByMap(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);

    Map<String, Object> data = new HashMap<>();
    data.put("myname", "dd");
    data.put("myage", 16);

    List<Student> list = dao.selectMultiByMap(data);

    for(Student student : list) {
      System.out.println("学生=" + student);
    }

    sqlSession.close();
  }
}
