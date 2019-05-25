package model.po;

import util.ChatType;

import java.util.Date;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 12:00
 * Description:消息类
 */
public class MessageInfo {
    private int id;
    private Integer fromUserId;
    private Integer toUserId;
    private Integer toGroupId;
    private String content;
    private String type;
    private String fileUrl;
    private String originalFilename;
    private String fileSize;

    public MessageInfo() {
    }
    /*
        消息发送构造函数
     */
    public MessageInfo(String fromUserId, String to, String content, ChatType type) {
        this.fromUserId=Integer.valueOf(fromUserId);
        this.content=content;
        if(type==ChatType.SINGLE_SENDING) {
            this.toUserId=Integer.valueOf(to);
        }else{
            this.toGroupId=Integer.valueOf(to);
        }
        this.type=type.toString();
    }

    public MessageInfo(String fromUserId, String to, String originalFilename, String fileSize, String fileUrl, ChatType type) {
        this.fromUserId=Integer.valueOf(fromUserId);
        this.originalFilename=originalFilename;
        this.fileSize=fileSize;
        this.fileUrl=fileUrl;
        if(type==ChatType.FILE_MSG_SINGLE_SENDING) {
            this.toUserId=Integer.valueOf(to);
        }else{
            this.toGroupId=Integer.valueOf(to);
        }
        this.type=type.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(Integer toGroupId) {
        this.toGroupId = toGroupId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
    @Override
    public String toString(){
        String s=toGroupId==null? toUserId.toString():toGroupId.toString();
        return "\n"+
                fromUserId.toString()+"\n" +
                s+"\n" +
                content+"\n" +
                type;
    }
}
