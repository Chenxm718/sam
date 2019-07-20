package com.sam.test;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author:ChenXinmin
 * @Date:2019/6/14 12:51
 */
public class FinishedData {

    private int dataId;
    private long id;
    /**
     * 会员编码
     */
    private String memberNo;
    /**
     * 规则ID
     */
    private long ruleId;
    /**
     * 完成日期
     */
    private LocalDate finishedDate;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private List<String> list;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    public LocalDate getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(LocalDate finishedDate) {
        this.finishedDate = finishedDate;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
