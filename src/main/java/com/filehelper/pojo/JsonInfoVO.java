package com.filehelper.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName JsonInfoVO
 * @Description TODO
 * @Author prog_evil
 * @Date 2021/11/5 12:41 上午
 * @Version 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JsonInfoVO implements Serializable {
    private int code;

    private String info;

    private FileInfoDTO data;

    public JsonInfoVO(FileInfoDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonInfoVO{" +
                "code=" + code +
                ", info='" + info + '\'' +
                ", data={" + data.getCreateDate() + '\n'
                + data.getCreatePath() + '\n'
                + data.getFileId() + '\n'
                + data.getFileName() + '\n'
                + data.getFileType() + '\n'
                + data.getFileSize() + '\n'
                + '}' + '\n' +
                '}';
    }
}
