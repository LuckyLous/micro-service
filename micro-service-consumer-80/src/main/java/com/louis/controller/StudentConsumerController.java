package com.louis.controller;

import com.louis.entity.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lu
 * @create 2019-05-04 22:39
 */
@RestController
@RequestMapping("/student")
public class StudentConsumerController {

    @Resource
    private RestTemplate restTemplate;

//    private static final String HOST = "http://localhost:2001/eureka/";

    /**
     * 指定的微服务应用名称
     */
    private static final String PRE_HOST = "http://MICRO-SERVICE-STUDENT";

    /**
     * 添加或者修改学生信息
     * @param student
     * @return
     */
    @PostMapping(value="/save")
    public boolean save(Student student){
        return restTemplate.postForObject(PRE_HOST + "/student/save", student, Boolean.class);
    }

    /**
     * 查询学生信息
     * @return
     */
    @GetMapping(value="/list")
    public List<Student> list(){
        return restTemplate.getForObject(PRE_HOST + "/student/list", List.class);
    }

    /**
     * 根据id查询学生信息
     * @return
     */
    @GetMapping(value="/get/{id}")
    public Student get(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PRE_HOST + "/student/get/"+id, Student.class);
    }

    /**
     * 根据id删除学生信息
     * @return
     */
    @GetMapping(value="/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        try{
            restTemplate.getForObject(PRE_HOST + "/student/delete/"+id, Boolean.class);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @GetMapping(value="/getInfo")
    public Map<String, Object> getInfo() throws InterruptedException {
        return  restTemplate.getForObject(PRE_HOST + "/student/getInfo", Map.class);
    }

}
