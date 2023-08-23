package com.shortlink.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shortlink.common.R;
import com.shortlink.pojo.Link;
import com.shortlink.service.LinkService;
import com.shortlink.urils.MurmurHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping("/getShort")
    public R<String> getShort(@RequestBody Link link){
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getOriginUrl, link.getOriginUrl());
        Link link1 = linkService.getOne(queryWrapper);
        String shortUrl;
        if (link1 == null){
            shortUrl = MurmurHashUtil.getHexHashString(link.getOriginUrl());
            link.setShortUrl(shortUrl);
            linkService.save(link);
        } else {
            shortUrl = link1.getShortUrl();
        }
        return R.success("http://127.0.0.1:8000/" + shortUrl);
    }
}
