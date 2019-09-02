package com.louis.controller;

import com.louis.entity.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lu
 * @create 2019-05-04 22:39
 */
@RestController
@RequestMapping("/student")
public class StudentConsumerController {

    @Resource
    private RestTemplate restTemplate;

    private static final String HOST = "http://localhost:2001/eureka/";

    /**
     * 添加或者修改学生信息
     * @param student
     * @return
     */
    @PostMapping(value="/save")
    public boolean save(Student student){
        return restTemplate.postForObject(HOST + "/student/save", student, Boolean.class);
    }

    /**
     * 查询学生信息
     * @return
     */
    @GetMapping(value="/list")
    public List<Student> list(){
        return restTemplate.getForObject(HOST + "/student/list", List.class);
    }

    /**
     * 根据id查询学生信息
     * @return
     */
    @GetMapping(value="/get/{id}")
    public Student get(@PathVariable("id") Integer id){
        return restTemplate.getForObject(HOST + "/student/get/"+id, Student.class);
    }

    /**
     * 根据id删除学生信息
     * @return
     */
    @GetMapping(value="/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        try{
            restTemplate.getForObject(HOST + "/student/delete/"+id, Boolean.class);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
