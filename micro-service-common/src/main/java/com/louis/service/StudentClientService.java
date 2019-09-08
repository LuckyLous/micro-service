package com.louis.service;

import com.louis.entity.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * Student Feign接口客户端
 * @author lu
 * @create 2019-09-03 23:50
 */
@FeignClient(value = "MICRO-SERVICE-STUDENT", fallbackFactory = StudentClientFallbackFactory.class)
public interface StudentClientService {

    /**
     * 根据id查询学生信息
     * @param id
     * @return
     */
    @GetMapping(value="/student/get/{id}")
    Student get(@PathVariable("id") Integer id);

    /**
     * 查询学生信息
     * @return
     */
    @GetMapping(value="/student/list")
    List<Student> list();

    /**
     * 添加或者修改学生信息
     * @param student
     * @return
     */
    @PostMapping(value="/student/save")
    boolean save(Student student);

    /**
     * 根据id删除学生信息
     * @return
     */
    @GetMapping(value="/student/delete/{id}")
    boolean delete(@PathVariable("id") Integer id);

    /**
     * 获取信息
     */
    @GetMapping(value = "/getInfo")
    Map<String, Object> getInfo();

}
