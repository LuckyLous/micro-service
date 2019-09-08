package com.louis.controller;

import com.louis.entity.Student;
import com.louis.service.StudentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author lu
 * @create 2019-05-04 22:39
 */
@RestController
@RequestMapping("/student")
public class StudentConsumerController {

    @Autowired
    private StudentClientService studentClientService;

    /**
     * 添加或者修改学生信息
     * @param student
     * @return
     */
    @PostMapping(value="/save")
    public boolean save(Student student){
        return studentClientService.save(student);
    }

    /**
     * 查询学生信息
     * @return
     */
    @GetMapping(value="/list")
    public List<Student> list(){
        return studentClientService.list();
    }

    /**
     * 根据id查询学生信息
     * @return
     */
    @GetMapping(value="/get/{id}")
    public Student get(@PathVariable("id") Integer id){
        return studentClientService.get(id);
    }

    /**
     * 根据id删除学生信息
     * @return
     */
    @GetMapping(value="/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return studentClientService.delete(id);
    }

    @GetMapping(value="/getInfo")
    public Map<String,Object> getInfo() {
        return studentClientService.getInfo();
    }
}
