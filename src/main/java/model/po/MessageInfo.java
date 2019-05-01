package model.po;

import java.util.Date;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 12:00
 * Description:消息类
 */
public class MessageInfo {
    private String sendId;
    private String receiveId;
    private String message;
    private Date time;

    public MessageInfo(String sendId, String receiveId, String message, Date time) {
        this.sendId = sendId;
        this.receiveId = receiveId;
        this.message = message;
        this.time = time;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
