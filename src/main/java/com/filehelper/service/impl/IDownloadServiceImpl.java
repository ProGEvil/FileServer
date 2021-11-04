package com.filehelper.service.impl;

import com.filehelper.mapper.FileMapper;
import com.filehelper.pojo.FileInfoDTO;
import com.filehelper.service.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Locale;

/**
 * @ClassName IDownloadServiceImpl
 * @Description download service
 * @Author prog_evil
 * @Date 2021/11/4 3:00 下午
 * @Version 1.0
 **/
public class IDownloadServiceImpl implements DownloadService {

    Logger logger = LoggerFactory.getLogger(IDownloadServiceImpl.class);

    @Autowired
    private FileMapper fileMapper;
    @Override
    public String downloadAndGetStatus(@RequestParam("uuid") String uuid, HttpServletResponse response) {

        //get all the info of file
        FileInfoDTO fileInfoDTO = fileMapper.selectFileInfoById(uuid);

        //error handling
        if(fileInfoDTO == null) {
            logger.debug("file is null");
            logger.error("Failed to download");
            return "410";
        }

        //success handling


        //get the uuid
        String fileId = fileInfoDTO.getFileId();
        //get the path
        String filePath = fileInfoDTO.getCreatePath();
        //get the type of files
        String typeOfFile = fileInfoDTO.getFileName().toLowerCase().substring(fileInfoDTO.getFileName().lastIndexOf(".")+1);

        //create the file name
        String fileName = filePath + fileId + "." + typeOfFile;

        File file = new File(fileName);

        if(file == null){
            logger.debug("file does't exist , failed");
            logger.error("Failed to download");
            return "410";
        }

        response.setContentType("application/octet-stream");
        response.setHeader("content-type", "application/octet-stream");
        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileId + "." + typeOfFile, "utf8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.debug("Exception throws");
        }
        byte[] buffer = new byte[1024];
        logger.debug("buffer waiting to be handle");
        OutputStream os = null;
        try  {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                //write the buffer into output stream
                os.write(buffer);
                //reading the buffer
                i = bis.read(buffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("io exception");
            logger.error("exception of io");
            return "410";
        }

        return "410";
    }
}
