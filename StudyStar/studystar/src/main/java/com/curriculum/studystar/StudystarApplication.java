package com.curriculum.studystar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*","com.curriculum.studystar"})
@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*","com.curriculum.studystar.Mapper"})
public class StudystarApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudystarApplication.class, args);
	}

}
