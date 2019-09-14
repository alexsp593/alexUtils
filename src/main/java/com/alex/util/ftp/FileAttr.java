package com.alex.util.ftp;

import java.util.Date;

/**
 * @Deception:FTP文件熟悉
 * @Author:Alex
 * @Date:2018年06月06日17点57分
 */
public class FileAttr {
    private String fileName;    //文件名
    private Date ModifyTime;    //上传时间
    private Long   size;        //文件大小

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getModifyTime() {
        return new Date(ModifyTime.getTime());
    }

    public void setModifyTime(Date modifyTime) {
        ModifyTime = modifyTime;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
