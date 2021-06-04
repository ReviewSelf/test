package com.oj.DAO;

import com.oj.DAO.model.User;
import com.oj.DAO.model.Users;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {


    List<User> selectAll();

    Integer selectIsUser(User user);

    int insertUser(User user);

    int selectId(String userId);

    List<User> selectUser(String key);

    void updatePassword(String userId);

    int insertUsers(Users record);

    User selectLoginUser(String userId);
}