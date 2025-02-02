package com.njy.cli_tools.mapper;

import com.njy.cli_tools.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (id, name) VALUES (#{id}, #{name})")
    void insertUser(User user);

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(@Param("id") int id);

    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Update("UPDATE users SET name = #{name} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUser(@Param("id") int id);

}

