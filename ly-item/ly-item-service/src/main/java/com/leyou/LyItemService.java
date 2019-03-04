package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 18070943
 * @create 2018-12-08 18:02
 * @desc 启动类
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyou.item.mapper") // mapper接口的包扫描
public class LyItemService {
    public static void main(String[] args) {
        SpringApplication.run(LyItemService.class, args);
    }
}