package com.filehelper.controller;

import com.filehelper.pojo.FileInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //upload file
    @PostMapping("/upload")
    public String uploadFile(){
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
