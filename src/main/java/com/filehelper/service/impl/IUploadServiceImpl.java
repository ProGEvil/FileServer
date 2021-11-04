package com.filehelper.service.impl;

import com.filehelper.pojo.FileInfoDTO;
import com.filehelper.service.UploadService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName IUploadServiceImpl
 * @Description TODO
 * @Author prog_evil
 * @Date 2021/11/4 3:00 下午
 * @Version 1.0
 **/
public class IUploadServiceImpl implements UploadService {

    //the current date
    Date date = new Date();
    //type of date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    FileInfoDTO fileInfoDTO = new FileInfoDTO();
    @Override
    public String uploadAndGetUuid(MultipartFile file) {

        String path = simpleDateFormat.format(date);

        File dir = new File(path + "/");
        //while dir is null , create
        if(dir == null){
            dir.mkdir();
        }


        String uuid = UUID.randomUUID().toString();
        String originalFile = file.getOriginalFilename();

        if(!originalFile.equals("")){

        }

        return "";
    }
}
