package com.dlkyy;
import com.dlkyy.dao.StudentDao;
import com.dlkyy.entity.Student;
import com.dlkyy.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dlkyy on 2021/2/24 21:23
 */
public class TestMain {

  @Test
  public void testSelectStudentIf(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);

    Student student = new Student();
    student.setName("");
    student.setAge("16");

    List<Student> studentList = dao.selectStudentIf(student);
    for(Student stu : studentList) {
      System.out.println(stu);
    }
  }

  @Test
  public void testSelectStudentWhere(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);

    Student student = new Student();
    student.setName("");
    student.setAge("16");

    List<Student> studentList = dao.selectStudentWhere(student);
    for(Student stu : studentList) {
      System.out.println(stu);
    }
  }

  @Test
  public void testSelectStudentForeachOne(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);

    List<String> list = new ArrayList<>();
    list.add("1001");
    list.add("1002");
    list.add("1003");

    List<Student> students = dao.selectStudentForeachOne(list);
    for(Student student : students) {
      System.out.println(student);
    }
  }

  @Test
  public void testSelectStudentForeachTwo(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    List<Student> list = new ArrayList<>();

    Student s1 = new Student();
    s1.setId(1001);
    list.add(s1);

    s1 = new Student();
    s1.setId(1002);
    list.add(s1);

    List<Student> stuList = dao.selectStudentForeachTwo(list);
    for(Student student : stuList) {
      System.out.println(student);
    }
  }

  // 分页
  @Test
  public void testSelectAllPageHelper(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);

    // 加入PageHelper的方法，分页
    // pageNum：第几页，从1开始
    // pageSize：一页中有几行数据
    PageHelper.startPage(1,3);
    List<Student> studentList = dao.selectAll();
    for(Student student : studentList) {
      System.out.println(student);
    }
  }
}
