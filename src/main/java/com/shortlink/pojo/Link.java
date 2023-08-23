package com.shortlink.pojo;

import lombok.Data;

@Data
public class Link {
    private Integer id;
    private String originUrl;
    private String shortUrl;
}
