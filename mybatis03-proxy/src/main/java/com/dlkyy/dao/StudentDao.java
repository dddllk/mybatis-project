package com.dlkyy.dao;

import com.dlkyy.entity.Student;

import java.util.List;

/**
 * Created by dlkyy on 2021/2/24 21:18
 */
public interface StudentDao {
  List<Student> selectStudent();
}
