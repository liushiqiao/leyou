package com.leyou.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

import com.github.tobato.fastdfs.FdfsClientConfig;

/**
 * @author 18070943
 * @create 2018-12-19 20:46
 * @desc FDFS
 **/
@Configuration
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastClientImporter {
}