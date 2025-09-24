package org.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String toEmail, String userEmail, String messageContent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("charlielobeinfo@gmail.com"); // Set this as the 'from' address
        message.setTo(toEmail);                      // This would be lobecf@gmail.com
        message.setSubject("New message from " + userEmail); // Optionally include user's email in the subject
        message.setText(messageContent);

        emailSender.send(message);
    }
}



