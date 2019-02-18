package com.chenhaibo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author chenhaibo
 * @since 2018-11-27
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户中心主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", name=" + name +
                "}";
    }
}
