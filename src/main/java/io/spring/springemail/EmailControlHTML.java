package io.spring.springemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
public class EmailControlHTML {
    @Autowired private JavaMailSender mailSender;

    @RequestMapping(path = "email-html", method = RequestMethod.GET)
    public String sendMail(){
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo("cafenoporao@gmail.com");
            helper.setSubject("Teste Envio de E-mail");
            helper.setText("<p>Hello from Spring Boot Application</p>", true);
            mailSender.send(mail);

            return "OK";
        } catch (Exception e){
            e.printStackTrace();
            return "Erro ao enviar Email";
        }
    }
}
