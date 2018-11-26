package com.chenhaibo.controller;

import com.chenhaibo.client.JobClient;
import com.chenhaibo.model.Job;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chenhaibo
 * @Date: 2018/11/21 11:39
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("api/job")
@Api("JobController")
public class JobController {

    @Autowired
    private JobClient jobClient;

    @ApiOperation(value = "根据id查询职务信息", notes = "根据id查询职务信息")
    @ApiImplicitParam(name = "id", value = "编号", paramType = "path", required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Job getJobById(@PathVariable String id) {
        log.info("开始根据id查询职务信息");
        Job job = jobClient.getJobById(Long.parseLong(id));
        if (null == job) {
            Job job1 = new Job();
            job1.setId(-1L);
            job1.setJobCode("职务不存在");
            return job1;
        } else {
            return job;
        }
    }
}
