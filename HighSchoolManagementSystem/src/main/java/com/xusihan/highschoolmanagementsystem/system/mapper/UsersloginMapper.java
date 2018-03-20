package com.xusihan.highschoolmanagementsystem.system.mapper;

import com.xusihan.highschoolmanagementsystem.po.Userslogin;
import com.xusihan.highschoolmanagementsystem.po.UsersloginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersloginMapper {
    int countByExample(UsersloginExample example);

    int deleteByExample(UsersloginExample example);

    int deleteByPrimaryKey(String account);

    int insert(Userslogin record);

    int insertSelective(Userslogin record);

    List<Userslogin> selectByExample(UsersloginExample example);

    Userslogin selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") Userslogin record, @Param("example") UsersloginExample example);

    int updateByExample(@Param("record") Userslogin record, @Param("example") UsersloginExample example);

    int updateByPrimaryKeySelective(Userslogin record);

    int updateByPrimaryKey(Userslogin record);
}