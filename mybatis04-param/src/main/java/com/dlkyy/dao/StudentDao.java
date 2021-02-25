package com.dlkyy.dao;

import com.dlkyy.entity.Student;
import com.dlkyy.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by dlkyy on 2021/2/24 21:18
 */
public interface StudentDao {

  public Student selectStudentById(Integer id);

  /**
   * 多个参数：命名参数，在形参定义的前面加入@Param("自定义参数名称")
   */

  List<Student> selectMultiParam(@Param("myname") String name,
                                 @Param("myage") Integer age);

  /**
   * 多个参数：使用java对象作为借口中方法的参数
   *
   * 括号里面的参数是java对象 如：Student student
   */
  List<Student> selectMultiObjects(QueryParam param);

  /**
   * 多个参数--简单类型：按位置传值
   *
   * mybatis：3.4之前使用#{0}，#{1}
   * mybatis：3.4之后，使用#{args0},#{args1}
   */
  List<Student> selectMultiPosition(String name, Integer age);

  /**
   *
   * 多个参数---使用Map
   */

  List<Student> selectMultiByMap(Map<String, Object> map);
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

