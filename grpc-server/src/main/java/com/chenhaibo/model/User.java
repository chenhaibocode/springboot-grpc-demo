package com.chenhaibo.model;

import javax.persistence.*;

/**
 * @Author: com.com.chenhaibo
 * @Description:
 * @Date: Created in 15:41 2018/7/26
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
