package zyq.pojo;

public class Records {
    private Integer rid;

    private Integer rbid;

    private Integer ruid;

    private String rdate;

    public Records() {
    }

    public Records(Integer rid, Integer rbid, Integer ruid, String rdate) {
        this.rid = rid;
        this.rbid = rbid;
        this.ruid = ruid;
        this.rdate = rdate;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRbid() {
        return rbid;
    }

    public void setRbid(Integer rbid) {
        this.rbid = rbid;
    }

    public Integer getRuid() {
        return ruid;
    }

    public void setRuid(Integer ruid) {
        this.ruid = ruid;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
}