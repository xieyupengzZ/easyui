package mybatis;

import java.util.Date;

public class BandSleepDate {
    private Long id;

    private Integer userId;

    private String macNo;

    private Integer date;

    private Integer endTime;

    private Integer totalMinute;

    private Integer lightSleepCount;

    private Integer deepSleepCount;

    private Integer wakeCount;

    private Integer wakeMinute;

    private Integer ligthSleepMinute;

    private Integer deepSleepMinute;

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

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getTotalMinute() {
        return totalMinute;
    }

    public void setTotalMinute(Integer totalMinute) {
        this.totalMinute = totalMinute;
    }

    public Integer getLightSleepCount() {
        return lightSleepCount;
    }

    public void setLightSleepCount(Integer lightSleepCount) {
        this.lightSleepCount = lightSleepCount;
    }

    public Integer getDeepSleepCount() {
        return deepSleepCount;
    }

    public void setDeepSleepCount(Integer deepSleepCount) {
        this.deepSleepCount = deepSleepCount;
    }

    public Integer getWakeCount() {
        return wakeCount;
    }

    public void setWakeCount(Integer wakeCount) {
        this.wakeCount = wakeCount;
    }

    public Integer getWakeMinute() {
        return wakeMinute;
    }

    public void setWakeMinute(Integer wakeMinute) {
        this.wakeMinute = wakeMinute;
    }

    public Integer getLigthSleepMinute() {
        return ligthSleepMinute;
    }

    public void setLigthSleepMinute(Integer ligthSleepMinute) {
        this.ligthSleepMinute = ligthSleepMinute;
    }

    public Integer getDeepSleepMinute() {
        return deepSleepMinute;
    }

    public void setDeepSleepMinute(Integer deepSleepMinute) {
        this.deepSleepMinute = deepSleepMinute;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}