package com.dlkyy;
import com.dlkyy.dao.StudentDao;
import com.dlkyy.dao.impl.StudentDaoImpl;
import com.dlkyy.entity.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by dlkyy on 2021/2/24 21:23
 */
public class TestMain {
  @Test
  public void TestSelectStudent(){
    StudentDao dao = new StudentDaoImpl();
    List<Student> studentList = dao.selectStudent();
    for(Student student : studentList) {
      System.out.println(student);
    }
  }
}
