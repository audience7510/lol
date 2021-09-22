package com.github.hero.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.hero.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
