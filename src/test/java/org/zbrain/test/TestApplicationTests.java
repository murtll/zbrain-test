package org.zbrain.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zbrain.test.entity.EmailModel;
import org.zbrain.test.service.EmailService;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    EmailService emailService;

    @Test
    void daoWorks() {

        boolean isCorrectEmail = emailService.addEmailIfNotAdded(new EmailModel("pls@wor.k"));

        Assertions.assertTrue(isCorrectEmail);

    }

}
