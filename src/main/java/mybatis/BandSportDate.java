package mybatis;

import java.util.Date;

public class BandSportDate {
    private Long id;

    private Integer userId;

    private String macNo;

    private Integer date;

    private Integer totalActiveTime;

    private Integer totalCal;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMacNo() {
        return macNo;
    }

    public void setMacNo(String macNo) {
        this.macNo = macNo == null ? null : macNo.trim();
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getTotalActiveTime() {
        return totalActiveTime;
    }

    public void setTotalActiveTime(Integer totalActiveTime) {
        this.totalActiveTime = totalActiveTime;
    }

    public Integer getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(Integer totalCal) {
        this.totalCal = totalCal;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}