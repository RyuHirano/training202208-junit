package com.example.training202208junit.domain.repository;

import com.example.training202208junit.data.mapper.entity.UserEntity;
import com.example.training202208junit.data.mapper.param.UserParams;
import java.util.List;

/** UserRepositoryインターフェース. */
public interface UserRepository {
  List<UserEntity> select(UserParams userParams);

  void insert(List<UserParams> userParamsList);

  void update(UserParams userParams);

  void delete(UserParams userParams);
}
