package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 18070943
 * @create 2018-12-18 9:57
 * @desc 启动类
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class LyUploadService {
    public static void main(String[] args) {
        SpringApplication.run(LyUploadService.class, args);
    }
}