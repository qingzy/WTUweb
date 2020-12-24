package zyq.service.user;

import zyq.pojo.Users;

/**
 * Created by Administrator on 2020/12/17.
 */
public interface UserService {

    public int insert(Users users);

    public void updateByUid(Integer uid,String name,String pwd);

    public Users selectUser(Integer uid, String upwd);

    public int updateByPrimaryKeySelective(Users users);

    public Users selectByPrimaryKey(Integer uid);

    void jiaUbnum(Integer uid);

    void jianUbnum(Integer uid);
}
