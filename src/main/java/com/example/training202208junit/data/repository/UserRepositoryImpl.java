package com.example.training202208junit.data.repository;

import com.example.training202208junit.data.mapper.UserMapper;
import com.example.training202208junit.data.mapper.entity.UserEntity;
import com.example.training202208junit.data.mapper.param.UserParams;
import com.example.training202208junit.domain.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/** UserRepositoryの実装. */
@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
  private final UserMapper userMapper;

  @Override
  public List<UserEntity> select(UserParams userParams) {
    return userMapper.select(userParams);
  }

  @Override
  public void insert(List<UserParams> userParamsList) {
    userMapper.insert(userParamsList);
  }

  @Override
  public void update(UserParams userParams) {
    userMapper.update(userParams);
  }

  @Override
  public void delete(UserParams userParams) {
    userMapper.delete(userParams);
  }
}
