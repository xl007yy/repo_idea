package com.lagou.damian;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserVO {
    // 注册手机
    private String phone;
    // 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startCreateTime;
    // 结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endCreateTime;
    //当前页
    private Integer currentPage;
    //每页个数
    private Integer pageSize;



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
