package com.chenhaibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chenhaibo.model.Job;
import com.chenhaibo.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/20 15:26
 * @Description:
 */
@Mapper
public interface JobMapper extends BaseMapper<Job> {

    Job getJobById(Long id);

}
