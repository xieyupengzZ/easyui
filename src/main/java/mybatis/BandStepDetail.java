package mybatis;

import java.util.Date;

public class BandStepDetail {
    private Long id;

    private Integer userid;

    private String macno;

    private Integer date;

    private Integer stepcount;

    private Integer distance;

    private Integer calories;

    private Integer activetime;

    private Byte serialnumber;

    private Date createtime;

    private Date synctime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMacno() {
        return macno;
    }

    public void setMacno(String macno) {
        this.macno = macno == null ? null : macno.trim();
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getStepcount() {
        return stepcount;
    }

    public void setStepcount(Integer stepcount) {
        this.stepcount = stepcount;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getActivetime() {
        return activetime;
    }

    public void setActivetime(Integer activetime) {
        this.activetime = activetime;
    }

    public Byte getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(Byte serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getSynctime() {
        return synctime;
    }

    public void setSynctime(Date synctime) {
        this.synctime = synctime;
    }
}