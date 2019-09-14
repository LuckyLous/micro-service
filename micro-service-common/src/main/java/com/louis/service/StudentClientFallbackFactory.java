package com.louis.service;

import com.louis.entity.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lu
 * @create 2019-09-08 16:57
 */
@Component
public class StudentClientFallbackFactory implements FallbackFactory<StudentClientService> {

    @Override
    public StudentClientService create(Throwable throwable) {
        return new StudentClientService() {
            @Override
            public Student get(Integer id) {
                return null;
            }

            @Override
            public List<Student> list() {
                return null;
            }

            @Override
            public boolean save(Student student) {
                return false;
            }

            @Override
            public boolean delete(Integer id) {
                return false;
            }

            @Override
            public Map<String, Object> getInfo() {
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("code", 500);
                resultMap.put("data", "server error, please try later -- common");
                return resultMap;
            }
        };
    }
}
