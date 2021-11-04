package com.filehelper.controller;

import com.filehelper.mapper.FileMapper;
import com.filehelper.pojo.FileInfoDTO;
import com.filehelper.pojo.JsonInfoVO;
import com.filehelper.service.DownloadService;
import com.filehelper.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName FileController
 * @Description upload and download the files
 * @Author prog_evil
 * @Date 2021/11/3 3:07 下午
 * @Version 1.0
 **/

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileMapper fileMapper;

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private UploadService uploadService;
    @Autowired
    private DownloadService downloadService;

    //upload file
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file){

        if(!file.isEmpty()) {
            String s = uploadService.uploadAndGetUuid(file);
            logger.debug("uploaded" + file.getName());
            return s;
        }
        logger.debug("file is empty");
        return "ERROR";
    }

    //download file
    @GetMapping("/download")
    public String downloadFile(String uuid, HttpServletResponse response){

        if (!uuid.equals("")) {
            downloadService.downloadAndGetStatus(uuid,response);
        }
        return "410";
    }

    //get the message from file
    @GetMapping("/getInfoById")
    public JsonInfoVO getFileInfo(@RequestParam String uuid){
        //mapper get fileInfo
        FileInfoDTO fileInfo = fileMapper.selectFileInfoById(uuid);

        if(fileInfo != null){

            JsonInfoVO jsonInfoVO = new JsonInfoVO(fileInfo);
            logger.debug("get the json"+jsonInfoVO.getInfo());
            return jsonInfoVO;
        }else{
            fileInfo.setFileName("null");
            JsonInfoVO jsonInfoVO = new JsonInfoVO(fileInfo);

            logger.debug("file can't be gotten" + fileInfo.getFileName());
            logger.error("null file");
            return jsonInfoVO;
        }
    }


}
