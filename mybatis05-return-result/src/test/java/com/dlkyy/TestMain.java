package com.dlkyy;
import com.dlkyy.dao.StudentDao;
import com.dlkyy.entity.MyStudent;
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

  @Test
  public void countStudent(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    int count = dao.countStudent();
    System.out.println(count);
  }

  // 测试返回map
  @Test
  public void testReturnMap(){
    SqlSession sqlsession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlsession.getMapper(StudentDao.class);
    Map<Object, Object> map = dao.selectMapById(1002);
    System.out.println("map=" + map);
  }

  // 测试返回所有student
  @Test
  public void testSelectAllStudents(){
    SqlSession sqlsession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlsession.getMapper(StudentDao.class);
    List<Student> studentList = dao.selectAllStudents();
    for(Student student : studentList) {
      System.out.println(student);
    }
  }

  // 测试返回所有MyStudent---1
  @Test
  public void testSelectAllMyStudents(){
    SqlSession sqlsession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlsession.getMapper(StudentDao.class);
    List<MyStudent> myStudentList = dao.selectAllMyStudents();
    for(MyStudent student : myStudentList) {
      System.out.println(student);
    }
  }

  // 测试返回所有MyStudent---2
  @Test
  public void testSelectAllMyStudents2(){
    SqlSession sqlsession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlsession.getMapper(StudentDao.class);
    List<MyStudent> myStudentList = dao.selectAllMyStudents2();
    for(MyStudent student : myStudentList) {
      System.out.println(student);
    }
  }

  // 测试 selectLikeOne
  @Test
  public void testSelectLikeOne(){
    SqlSession sqlsession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlsession.getMapper(StudentDao.class);
    //准备好like的内容
    String name = "%d";
    List<Student> stu = dao.selectLikeOne(name);
    for(Student student : stu) {
      System.out.println(student);
    }
  }

  // 测试 selectLikeTwo
  @Test
  public void testSelectLikeTwo(){
    SqlSession sqlsession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlsession.getMapper(StudentDao.class);
    List<Student> stu = dao.selectLikeTwo("d");
    for(Student student : stu) {
      System.out.println(student);
    }
  }
}
