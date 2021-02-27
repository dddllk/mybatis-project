package com.dlkyy.dao;

import com.dlkyy.entity.Student;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/24 21:18
 */
public interface StudentDao {
  // 动态sql
  List<Student> selectStudentIf(Student student);

  List<Student> selectStudentWhere(Student student);

  // foreach用法1
  List<Student> selectStudentForeachOne(List<String> list);

  // foreach用法2
  List<Student> selectStudentForeachTwo(List<Student> list);

  // 使用PageHelper分页数据
  List<Student> selectAll();

}

/**
 * 面试题：
 *  # 和 $ 的区别：
 *  1. # 使用 ? 在sql语句中做占位的，使用PreparedStatement执行sql，效率高
 *  2. # 能够避免sql注入，更安全
 *  3. $ 不使用占位符，是字符串连接方式，使用Statement对象执行sql，效率低
 *  4. $ 有sql注入的风险，缺乏安全性。
 *  5. $ :可以替换表名或者列名
 *
 */

