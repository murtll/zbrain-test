package org.zbrain.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String addEmail(@RequestBody EmailModel email) {

        System.out.println(email.getEmail());

        boolean isRequestCorrect = emailService.addEmailIfNotAdded(email);

        if (isRequestCorrect) return "{\"status\":200}";
        else return "{\"status\":400, \"duplicate\":true}";
    }

}
