package com.filehelper;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName FileSupportApplication
 * @Description TODO
 * @Author prog_evil
 * @Date 2021/11/4 11:39 上午
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan("com.filehelper")
public class FileSupportApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileSupportApplication.class,args);
    }
}
