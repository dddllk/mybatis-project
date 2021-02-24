package com.dlkyy.dao.impl;

import com.dlkyy.dao.StudentDao;
import com.dlkyy.entity.Student;
import com.dlkyy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by dlkyy on 2021/2/24 21:19
 */
public class StudentDaoImpl implements StudentDao {

  @Override
  public List<Student> selectStudent() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    String sqlId = "com.dlkyy.dao.StudentDao.selectStudent";
    List<Student> list = sqlSession.selectList(sqlId);
    sqlSession.close();
    return list;
  }
}