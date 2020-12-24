package zyq.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyq.mapper.UsersMapper;
import zyq.pojo.Users;

/**
 * Created by Administrator on 2020/12/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper um;

    @Override
    public int insert(Users users) {
        int rows = um.insert(users);
        return rows;
    }

    @Override
    public void updateByUid(Integer uid, String name, String pwd) {

    }

    @Override
    public Users selectUser(Integer uid, String upwd) {
        Users users= um.selectUser(uid, upwd);
        return users;
    }

    @Override
    public int updateByPrimaryKeySelective(Users users) {
        int rows = um.updateByPrimaryKeySelective(users);
        return rows;

    }

    @Override
    public Users selectByPrimaryKey(Integer uid) {
        Users users = um.selectByPrimaryKey(uid);
        return users;
    }

    @Override
    public void jiaUbnum(Integer uid) {
        um.jiaUbnum(uid);
    }

    @Override
    public void jianUbnum(Integer uid) {
        um.jianUbnum(uid);
    }
}
