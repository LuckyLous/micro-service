package com.louis.controller;

import com.louis.entity.Student;
import com.louis.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lu
 * @create 2019-05-04 22:34
 */
@RestController
@RequestMapping("/student")
public class StudentProviderController {

    @Resource
    private StudentService studentService;

    /**
     * 添加或者修改学生信息
     * @param student
     * @return
     */
    @PostMapping(value="/save")
    public boolean save(@RequestBody Student student){
        try{
            studentService.save(student);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * 根据id删除学生信息
     * @return
     */
    @GetMapping(value="/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        try{
            studentService.delete(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * 查询学生信息
     * @return
     */
    @GetMapping(value="/list")
    public List<Student> list(){
        System.out.println("list -- by provide 1003");
        return studentService.list();
    }

    /**
     * 根据id查询学生信息
     * @return
     */
    @GetMapping(value="/get/{id}")
    public Student get(@PathVariable("id") Integer id){
        return studentService.getById(id);
    }

    @GetMapping(value = "/getInfo")
    @HystrixCommand(fallbackMethod = "getInfoFallback")
    public Map<String, Object> getInfo() throws InterruptedException {
        Thread.sleep(4000);
//        Thread.sleep(200);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("data", "business data");
        return resultMap;
    }

    public Map<String, Object> getInfoFallback() throws InterruptedException {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 500);
        resultMap.put("data", "server error, please try later");
        return resultMap;
    }

}
