package mybatis;

import java.util.Date;

public class BandHeartRateDate {
    private Long id;

    private Integer userId;

    private String macNo;

    private Integer date;

    private Integer averageHeartRate;

    private Integer burnFatThreshold;

    private Integer aerobicThreshold;

    private Integer limitThreshold;

    private Integer burnFatMins;

    private Integer aerobicMins;

    private Integer limitMins;

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

    public Integer getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(Integer averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public Integer getBurnFatThreshold() {
        return burnFatThreshold;
    }

    public void setBurnFatThreshold(Integer burnFatThreshold) {
        this.burnFatThreshold = burnFatThreshold;
    }

    public Integer getAerobicThreshold() {
        return aerobicThreshold;
    }

    public void setAerobicThreshold(Integer aerobicThreshold) {
        this.aerobicThreshold = aerobicThreshold;
    }

    public Integer getLimitThreshold() {
        return limitThreshold;
    }

    public void setLimitThreshold(Integer limitThreshold) {
        this.limitThreshold = limitThreshold;
    }

    public Integer getBurnFatMins() {
        return burnFatMins;
    }

    public void setBurnFatMins(Integer burnFatMins) {
        this.burnFatMins = burnFatMins;
    }

    public Integer getAerobicMins() {
        return aerobicMins;
    }

    public void setAerobicMins(Integer aerobicMins) {
        this.aerobicMins = aerobicMins;
    }

    public Integer getLimitMins() {
        return limitMins;
    }

    public void setLimitMins(Integer limitMins) {
        this.limitMins = limitMins;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}