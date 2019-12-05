package com.aaa.mapper.user;

import com.aaa.model.PermInfo;
import com.aaa.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:30
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     *
     * @param principal
     * @return
     */
    @Select("select * from user_info where user_name=#{principal}")
    UserInfo getUserByUserName(String principal);
    /**
     * 添加用户
     * @param userInfo
     */
    @Insert("insert into user_info(user_name,user_password) values(#{userName},#{userPassword})")
    void addUser(UserInfo userInfo);
    /**
     * 根据用户名去数据库中查询该用户所拥有的权限
     * @param userName
     * @return
     */
    @Select("SELECT * FROM perm_info WHERE perm_id IN (SELECT perm_id FROM role_perm_info where role_id in (SELECT role_id from user_role_info WHERE user_id =(SELECT user_id from user_info where user_name=#{userName})))")
    List<PermInfo> getPermsByUserName(String userName);

}
