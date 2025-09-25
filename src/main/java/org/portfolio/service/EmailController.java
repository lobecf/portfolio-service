package org.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<Object> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmail("lobecf@gmail.com", emailRequest.getFirstName(), emailRequest.getLastName(), emailRequest.getUserEmail(), emailRequest.getMessageContent());
            return ResponseEntity.ok(new ApiResponse("success", "Email sent successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("error", "Error sending email: " + e.getMessage()));
        }
    }
}

