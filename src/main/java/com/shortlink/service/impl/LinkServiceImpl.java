package com.shortlink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shortlink.pojo.Link;
import com.shortlink.mapper.LinkMapper;
import com.shortlink.service.LinkService;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {
}