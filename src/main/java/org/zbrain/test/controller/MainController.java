package org.zbrain.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zbrain.test.entity.EmailModel;
import org.zbrain.test.service.EmailService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class MainController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/add-email", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> addEmail(@RequestBody EmailModel email) {

        ResponseEntity<String> response;

        try {
            if (email.getEmail() == null || email.getEmail().equals("")) throw new RuntimeException("Empty request!");

            String emailPattern = "[\\w]{1,15}@[\\w]{1,15}+\\.[\\w]{1,5}";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email.getEmail());
            if (!matcher.matches()) throw new RuntimeException("Not email!");

            response = emailService.addEmailIfNotAdded(email);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

}
