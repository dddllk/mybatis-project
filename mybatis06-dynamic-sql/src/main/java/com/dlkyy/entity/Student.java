package com.dlkyy.entity;

/**
 * Created by dlkyy on 2021/2/24 21:16
 */
public class Student {
  private Integer id;
  private String name;
  private String email;
  private String age;

  public Student() {
  }

  public Student(Integer id, String name, String email, String age) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", age='" + age + '\'' +
        '}';
  }
}
