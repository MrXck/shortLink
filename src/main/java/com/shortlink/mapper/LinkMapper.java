package com.shortlink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shortlink.pojo.Link;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LinkMapper extends BaseMapper<Link> {
}