package com.louis.service.impl;

import com.louis.entity.Student;
import com.louis.repository.StudentRepository;
import com.louis.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lu
 * @create 2019-05-04 22:31
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.delete(id);
    }

    @Override
    public Student getById(Integer id) {
        return studentRepository.findOne(id);
    }

    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }
}
