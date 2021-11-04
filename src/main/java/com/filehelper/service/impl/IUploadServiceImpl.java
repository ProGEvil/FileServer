package com.filehelper.service.impl;

import com.filehelper.mapper.FileMapper;
import com.filehelper.pojo.FileInfoDTO;
import com.filehelper.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * @ClassName IUploadServiceImpl
 * @Description upload service
 * @Author prog_evil
 * @Date 2021/11/4 3:00 下午
 * @Version 1.0
 **/
public class IUploadServiceImpl implements UploadService {

    Logger logger = LoggerFactory.getLogger(IUploadServiceImpl.class);

    @Autowired
    private FileMapper fileMapper;
    //the current date
    Date date = new Date();

    //type of date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    //type of date and time
    SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    FileInfoDTO fileInfoDTO = new FileInfoDTO();
    @Override
    public String uploadAndGetUuid(@RequestParam("file") MultipartFile file) {

        String path = simpleDateFormat.format(date);

        File dir = new File(path + "/");
        //while dir is null , create
        if(dir == null){
            dir.mkdir();
            logger.debug("has make a dir");
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

            logger.debug("set all info");
            //user mapper to insert
            fileMapper.insertFileInfo(fileInfoDTO);

            //get the file name with uuid
            String newFileName = uuid + "." + originalFile.substring(originalFile.lastIndexOf(".") +1).toLowerCase();

            try{
                //output stream for creating file
                FileOutputStream out = new FileOutputStream(simpleDateFormat + "/" + newFileName);
                //writing bytes into file
                out.write(file.getBytes());
                logger.debug("creating completed");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Failed to upload the file");
                return  uuid;
            }
            //output the file upload
            logger.info("Complete to upload the file!");
            return uuid;
        }else{
            logger.debug("Has not been a file");
            logger.error("Please upload again because of the empty file");

            return uuid;
        }
    }
}
