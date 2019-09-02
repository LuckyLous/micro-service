package com.louis.service;

import java.util.List;

/**
 * @author lu
 * @create 2019-05-04 22:22
 */
public interface BaseService<T> {

    /**
     * 添加或者修改元素信息
     * @param t
     */
    void save(T t);

    /**
     * 根据id删除学生信息
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id查找学生信息
     * @param id
     * @return
     */
    T getById(Integer id);

    /**
     * 查询学生信息
     * @return
     */
    List<T> list();


}
