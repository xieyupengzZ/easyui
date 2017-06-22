package mybatis;

import java.util.Date;

public class BandGoalData {
    private Long id;

    private Integer userid;

    private String macno;

    private Integer stepcount;

    private Integer stepcalories;

    private Integer stepdistances;

    private Integer stepactivetime;

    private Integer sportcalories;

    private Integer sleepminute;

    private Date createtime;

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

    public Integer getStepcount() {
        return stepcount;
    }

    public void setStepcount(Integer stepcount) {
        this.stepcount = stepcount;
    }

    public Integer getStepcalories() {
        return stepcalories;
    }

    public void setStepcalories(Integer stepcalories) {
        this.stepcalories = stepcalories;
    }

    public Integer getStepdistances() {
        return stepdistances;
    }

    public void setStepdistances(Integer stepdistances) {
        this.stepdistances = stepdistances;
    }

    public Integer getStepactivetime() {
        return stepactivetime;
    }

    public void setStepactivetime(Integer stepactivetime) {
        this.stepactivetime = stepactivetime;
    }

    public Integer getSportcalories() {
        return sportcalories;
    }

    public void setSportcalories(Integer sportcalories) {
        this.sportcalories = sportcalories;
    }

    public Integer getSleepminute() {
        return sleepminute;
    }

    public void setSleepminute(Integer sleepminute) {
        this.sleepminute = sleepminute;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}