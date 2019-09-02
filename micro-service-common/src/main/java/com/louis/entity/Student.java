package com.louis.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lu
 * @create 2019-05-04 21:56
 */
@Entity
@Table(name="student")
@Data
public class Student implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 姓名
     */
    @Column(length=50)
    private String name;

    /**
     * 年级
     */
    @Column(length=50)
    private String grade;

}
