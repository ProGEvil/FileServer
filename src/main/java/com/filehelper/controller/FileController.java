package com.filehelper.controller;

import com.filehelper.pojo.FileInfoDTO;
import com.filehelper.service.DownloadService;
import com.filehelper.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    private final UploadService uploadService;
    private final DownloadService downloadService;

    public FileController(UploadService uploadService, DownloadService downloadService) {
        this.uploadService = uploadService;
        this.downloadService = downloadService;
    }

    //upload file
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file){
        Logger logger = LoggerFactory.getLogger(FileController.class);



        return "";
    }

    //download file
    @GetMapping("/download")
    public String downloadFile(){
        return "";
    }

    //get the message from file
    @GetMapping("/getInfoById")
    public FileInfoDTO getFileInfo(){
        //mapper get fileInfo
        FileInfoDTO fileInfo = new FileInfoDTO();

        return fileInfo;
    }


}
