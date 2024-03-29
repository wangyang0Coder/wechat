package util;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import model.po.UserInfo;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Author: Azhu
 * @Date: 2019/5/24 9:57
 * Description:
 */
public class MailUtil {
    static Properties properties;
    static Session session;
    static Message message;
    static {
        properties=new Properties();
        properties.setProperty("mail.host", "smtp.qq.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        // 得到会话对象
        session = Session.getInstance(properties);
        // 获取邮件对象
        message = new MimeMessage(session);
        // 设置发件人邮箱地址
        try {
            message.setFrom(new InternetAddress("2576419596@qq.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    static public void sendMail(UserInfo user) throws MessagingException {
        // 设置收件人邮箱地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));//一个收件人
        // 设置邮件标题
        message.setSubject("密码提醒通知!");
        // 设置邮件内容
        message.setText("你好\n" +
                "你的原密码为" +
                user.getPassword()+
                "请牢记，并妥善保管");
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("2576419596@qq.com", "akoshsymvlrjdjjc");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
