package classes;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail2{
public static void sendMail2() {
    final String username = "sakar.sharma@globallogic.com"; //change to your Gmail username
    final String password = "Sonika51081!"; //change to your Gmail password
    final String from = "sakar.sharma@globallogic.com"; //change to from email address
    final String to = "sakar.sharma@globallogic.com"; //change to to email address
    final String cc = ""; //change to cc email address
    final String bcc = ""; //change to bcc email address
    final String subject = "WOL-Web Automation Excel Report"; //change to your subject
    final String msg = "Please Find The Attachment Of Automation Result Below."; //change to your message
    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
     Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
               }
            });
     try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to));
        //below code only requires if your want cc email address
        message.setRecipients(Message.RecipientType.CC,
                InternetAddress.parse(cc));
        //below code only requires if your want bcc email address
        message.setRecipients(Message.RecipientType.BCC,
                InternetAddress.parse(bcc));
        message.setSubject(subject);
        message.setText(msg);
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        messageBodyPart = new MimeBodyPart();
        String file1 = "D:\\WOL_Mobility\\automation\\RnD2\\ExcelFiles\\Report.xlsx"; //change to your attachment filepath
        String fileName1 = "Report.xlsx"; //change to your attachment filename
        DataSource source1 = new FileDataSource(file1);
        messageBodyPart.setDataHandler(new DataHandler(source1));
        messageBodyPart.setFileName(fileName1);
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);
        System.out.println("Sending Email Contains Report Excel File ");
        Transport.send(message);
        System.out.println("Email Send");
     	} catch (MessagingException e) {
        e.printStackTrace();
    }
  }
}