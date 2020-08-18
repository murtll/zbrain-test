package org.zbrain.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.zbrain.test.entity.EmailModel;
import org.zbrain.test.service.EmailService;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    EmailService emailService;

    @Test
    void daoWorks() {

        ResponseEntity<String> responseEntity = emailService.addEmailIfNotAdded(new EmailModel("pls@wor.k"));

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assertions.assertEquals("{\"duplicate\": true}", responseEntity.getBody());

    }

}
