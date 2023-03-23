package com.ruoyi.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author Krson
 * @date 2022/12/7 20:38
 */
public class MsUtils {

    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    public static void sendQQ(String from,String pwd,String mail,String sub,String content){
        Properties props = new Properties();
        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, pwd);
                    }
                });
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail));
            msg.setSubject(sub);
            msg.setText(content);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.err.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("请求失败，异常信息为:{}"+e.getMessage());
        }
    }

    public static void sendGG(String from,String pwd,String mail,String subject,String content){
        Properties props = new Properties();
        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, pwd);
                    }
                });
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail));
            msg.setSubject(subject);
            msg.setText(content);
            msg.setSentDate(new Date());
            Transport.send(msg);
            System.err.println("发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("请求失败，异常信息为:{}"+e.getMessage());
        }
    }
}
