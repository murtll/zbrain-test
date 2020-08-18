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

@Controller
public class MainController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/add-email", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> addEmail(@RequestBody EmailModel email) {

        ResponseEntity<String> response;

        try {
            response = emailService.addEmailIfNotAdded(email);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

}
