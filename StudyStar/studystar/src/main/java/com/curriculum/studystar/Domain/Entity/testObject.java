package com.curriculum.studystar.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data//自动写getter、setter
@AllArgsConstructor //自动写全参构造函数
@NoArgsConstructor //自动写无参数构造函数
@ToString //添加toString方法
@Entity //代表类创建一个数据库表
@Table(name = "testtable") //数据库表名
public class testObject {
    @Id //id属性为主键
    private Integer id;
    private String text;
}

