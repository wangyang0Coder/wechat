package mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.activation.*;

/**
 * @Author: Azhu
 * @Date: 2019/5/24 9:33
 * Description:
 */
public class SendEmail
{
    public static void main(String[] args) throws AddressException,MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("2576419596@qq.com"));
        // 设置收件人邮箱地址
        //message.setRecipients(Msage.RecipientType.TO, new InternetAddress[]{new InternetAddress("xxx@qq.com"),new InternetAddress("xxx@qq.com"),new InternetAddress("xxx@qq.com")});
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("zhuwengjun19961002@foxmail.com"));//一个收件人
        // 设置邮件标题
        message.setSubject("密码提醒通知!");
        // 设置邮件内容
        message.setText("邮件内容邮件内容邮件内容xmqtest");
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("2576419596@qq.com", "akoshsymvlrjdjjc");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}