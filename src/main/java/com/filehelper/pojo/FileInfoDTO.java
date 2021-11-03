package com.filehelper.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * @ClassName FileInfoDTO
 * @Description the pojo of files
 * @Author prog_evil
 * @Date 2021/11/3 3:07 下午
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfoDTO {

    private String fileId;

    private String fileName;

    private long fileSize;

    private String fileType;

    private String createDate;

    private String createPath;

}
