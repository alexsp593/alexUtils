package com.alex.utils.ftp;

/**
 * @Deception:FTP上传日志
 * @Author:Alex
 * @Date:2018年06月06日21点43分
 */
public class FTPLog {
    private String host;                    //主机
    private String operation;               //操作
    private int    ReplyCode;               //返回code
    private String localFile;               //本地文件
    private String remoteFile;              //远程文件
    private String ReplyCodeDesc;           //返回描述
    private String createTime = null;       //创建时间

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getReplyCode() {
        return ReplyCode;
    }

    public void setReplyCode(int replyCode) {
        ReplyCode = replyCode;
    }

    public String getLocalFile() {
        return localFile;
    }

    public void setLocalFile(String localFile) {
        this.localFile = localFile;
    }

    public String getRemoteFile() {
        return remoteFile;
    }

    public void setRemoteFile(String remoteFile) {
        this.remoteFile = remoteFile;
    }

    public String getReplyCodeDesc() {
        return ReplyCodeDesc;
    }

    public void setReplyCodeDesc(String replyCodeDesc) {
        ReplyCodeDesc = replyCodeDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "FTPLog{" +
                "host='" + host + '\'' +
                ", operation='" + operation + '\'' +
                ", ReplyCode=" + ReplyCode +
                ", localFile='" + localFile + '\'' +
                ", remoteFile='" + remoteFile + '\'' +
                ", ReplyCodeDesc='" + ReplyCodeDesc + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
