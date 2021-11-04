package com.filehelper.mapper;

import com.filehelper.pojo.FileInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName FileMapper
 * @Description connect to the mybatis mapper
 * @Author prog_evil
 * @Date 2021/11/3 3:06 下午
 * @Version 1.0
 **/
@Mapper
@Repository
public interface FileMapper {
    public void insertFileInfo(FileInfoDTO fileInfoDTO);
    public FileInfoDTO selectFileInfoById(String uuid);
}
