package com.leyou.fdfs;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.LyUploadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author 18070943
 * @create 2018-12-19 20:50
 * @desc fdfs测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LyUploadService.class)
public class FdfsTest {
    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("F:\\study\\heima\\upload\\typora.JPEG");
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadFile(new FileInputStream(file), file.length(), "png", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException {
        File file = new File("F:\\file\\413ff283-237b-4f6b-8268-554b8e72a4ba.jpg");
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(new FileInputStream(file), file.length(),
                "jpg", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
        // 获取缩略图路径
        String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println(path);
    }
}