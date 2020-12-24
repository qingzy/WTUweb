package zyq.pojo;

public class Books {
    private Integer bid;

    private String bname;

    private String bauthor;

    private Integer bnum;

    private String bcbs;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor == null ? null : bauthor.trim();
    }

    public Integer getBnum() {
        return bnum;
    }

    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }

    public String getBcbs() {
        return bcbs;
    }

    public void setBcbs(String bcbs) {
        this.bcbs = bcbs == null ? null : bcbs.trim();
    }
}