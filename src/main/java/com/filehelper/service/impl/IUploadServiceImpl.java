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
    //type of date and time
    SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
            //set the file size
            fileInfoDTO.setFileSize(file.getSize());
            //set the file type
            fileInfoDTO.setFileType(file.getContentType());
            //set the original name
            fileInfoDTO.setFileName(originalFile);
            //set the create time
            fileInfoDTO.setCreateDate(simpleDateTimeFormat.format(date));
            //set the path
            fileInfoDTO.setCreatePath(path);
        }

        return "";
    }
}
