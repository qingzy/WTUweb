package zyq.pojo;

public class Users {
    private Integer uid;

    private String uname;

    private String upwd;

    private Integer ubnum;

    public Users() {
    }

    public Users(Integer uid, String uname, String upwd, Integer ubnum) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.ubnum = ubnum;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }

    public Integer getUbnum() {
        return ubnum;
    }

    public void setUbnum(Integer ubnum) {
        this.ubnum = ubnum;
    }
}