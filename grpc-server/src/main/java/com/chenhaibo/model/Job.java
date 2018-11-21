package com.chenhaibo.model;

/**
 * @Author: com.com.chenhaibo
 * @Description:
 * @Date: Created in 15:41 2018/7/26
 */
public class Job {

    private Long id;

    private String jobCode;

    public Job() {
    }

    public Job(Long id, String jobCode) {
        this.id = id;
        this.jobCode = jobCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }
}
