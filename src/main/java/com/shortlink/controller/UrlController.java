package com.shortlink.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shortlink.pojo.Link;
import com.shortlink.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UrlController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/{url}")
    public void redirect(@PathVariable String url, HttpServletResponse response) throws Exception {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getShortUrl, url);
        Link link = linkService.getOne(queryWrapper);
        if (link != null){
            response.sendRedirect(link.getOriginUrl());
        } else {
            throw new Exception();
        }
    }
}
