package cn.yznu.pca.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author yangbaiwan
 * @date 2019-03-21
 */
public class MailUtil {
    /**
     *注册时发送验证邮件
     *@param toMail 收件人
     *@return void
     */
    public static void sendMail(String toMail,String username) throws MessagingException {
        //4位随机验证码
        String code=Sid.randomNum();
        //设置邮件服务器
        Properties properties = new Properties();
        // 设置发送邮件的协议
        properties.setProperty("mail.transport.protocol", "SMTP");
        //可以设置邮件服务器
        properties.setProperty("mail.host", "smtp.163.com");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.port","465");
        // SSL加密
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            // 设置信任所有的主机
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            //与邮件服务器的连接
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("13212348680@163.com", "Yangbw2019");
                    //return new PasswordAuthentication("13212348680@163.com", "y248795961");

                }
            });

            //创建邮件
            Message message = new MimeMessage(session);
            //设置收件人地址
            message.setFrom(new InternetAddress("13212348680@163.com"));
            //抄送
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            //设置邮件的主体
            message.setSubject("1024Album账户激活邮件");

            //设置内容
            //String msg = "<h1>点击<a href='http://www.1024album.cn/pca/user/activate?code=" + code + "&username="+username+"'>此处</a>激活账户<h1>";
            String msg = "<h1>点击<a href='http://localhost:8080/pca/user/activate?code=" + code + "&username="+username+"'>此处</a>激活账户<h1>";
            message.setContent(msg, "text/html;charset=utf-8");
            //发送邮件
            Transport.send(message);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

    }

    /**
     * 发送重置密码邮件
     * @param toMail
     * @throws MessagingException
     */
    public static void sendMail2(String toMail,String pass) throws MessagingException {
        //设置邮件服务器
        Properties properties = new Properties();
        //可以设置邮件服务器
        properties.setProperty("mail.host", "smtp.163.com");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.port", "465");
        // SSL加密
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            // 设置信任所有的主机
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            //与邮件服务器的连接
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("13212348680@163.com", "Yangbw2019");
                }
            });

            //创建邮件
            Message message = new MimeMessage(session);
            //设置收件人地址
            message.setFrom(new InternetAddress("13212348680@163.com"));
            //抄送
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            //设置邮件的主体
            message.setSubject("1024Album密码重置");

            //设置内容
            String msg = "您1024Album账户密码已重置，新密码为："+pass+",请妥善保管您的密码";

            message.setContent(msg, "text/html;charset=utf-8");
            //发送邮件
            Transport.send(message);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
