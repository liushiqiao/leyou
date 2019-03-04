package com.leyou.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.leyou.service.UploadService;

/**
 * @author 18070943
 * @create 2018-12-18 9:59
 * @desc 上传文件
 **/
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String url = this.uploadService.upload(file);
        if (StringUtils.isBlank(url)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(url);
    }

}