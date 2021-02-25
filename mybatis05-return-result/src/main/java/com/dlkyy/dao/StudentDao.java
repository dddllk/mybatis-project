package com.dlkyy.dao;

import com.dlkyy.entity.MyStudent;
import com.dlkyy.entity.Student;
import com.dlkyy.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by dlkyy on 2021/2/24 21:18
 */
public interface StudentDao {

  Student selectStudentById(Integer id);

  /**
   * 多个参数：命名参数，在形参定义的前面加入@Param("自定义参数名称")
   */

  List<Student> selectMultiParam(@Param("myname") String name,
                                 @Param("myage") Integer age);

  int countStudent();

  // 定义方法返回Map
  Map<Object, Object> selectMapById(@Param("myId") Integer id);

  /**
   *
   * 使用resultMap定义映射关系
   *
   */
  List<Student> selectAllStudents();

  List<MyStudent> selectAllMyStudents();

  List<MyStudent> selectAllMyStudents2();

  /**
   * 第一种模糊查询：在java代码中指定like的内容
   */
  List<Student> selectLikeOne(String name);

  /**
   *  name就是d值，在mapper中拼接 like "%"d"%"
   * */
  List<Student> selectLikeTwo(String name);
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

