package com.dlkyy.dao;

import com.dlkyy.entity.Student;

import java.util.List;

/**
 * Created by dlkyy on 2021/2/23 20:28
 *
 * 操作Student表
 */
public interface StudentDao {
  // 查询Student表的所有数据
  public List<Student> selectStudents();

  // 插入方法
  public int insertStudent(Student student);
}
