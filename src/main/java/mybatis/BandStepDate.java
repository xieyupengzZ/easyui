package mybatis;

import java.util.Date;

public class BandStepDate {
    private Long id;

    private Integer userid;

    private String macno;

    private Integer date;

    private Integer totalstep;

    private Integer totalcal;

    private Integer totaldistances;

    private Integer totalactivetime;

    private Date updatetime;

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

    public Integer getTotalstep() {
        return totalstep;
    }

    public void setTotalstep(Integer totalstep) {
        this.totalstep = totalstep;
    }

    public Integer getTotalcal() {
        return totalcal;
    }

    public void setTotalcal(Integer totalcal) {
        this.totalcal = totalcal;
    }

    public Integer getTotaldistances() {
        return totaldistances;
    }

    public void setTotaldistances(Integer totaldistances) {
        this.totaldistances = totaldistances;
    }

    public Integer getTotalactivetime() {
        return totalactivetime;
    }

    public void setTotalactivetime(Integer totalactivetime) {
        this.totalactivetime = totalactivetime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}