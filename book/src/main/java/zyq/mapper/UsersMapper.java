package zyq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zyq.pojo.Users;
import zyq.pojo.UsersExample;

@Mapper
public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(Users users);

    int insertSelective(Users users);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer uid);

    int updateByUid(@Param("uid") Integer uid,@Param("uname") String uname,@Param("upwd") String pwd);

    Users selectUser(@Param("uid") Integer uid,@Param("upwd") String upwd);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    void jiaUbnum(Integer uid);

    void jianUbnum(Integer uid);
}