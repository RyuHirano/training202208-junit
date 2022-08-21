package com.example.training202208junit.data.mapper;

import com.example.training202208junit.data.mapper.entity.UserEntity;
import com.example.training202208junit.data.mapper.param.UserParams;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/** UserMapper. */
@Mapper
public interface UserMapper {
  List<UserEntity> select(@Param("user") UserParams userParams);

  void insert(@Param("userList") List<UserParams> userParamsList);

  void update(@Param("user") UserParams userParams);

  void delete(@Param("user") UserParams userParams);
}
