package org.zbrain.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zbrain.test.dao.EmailDAO;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    EmailDAO emailDAO;

    @Test
    void daoWorks() {

        boolean isCorrectEmail = emailDAO.checkOrAddEmail("testemail@mail.ru");

        Assertions.assertFalse(isCorrectEmail);

    }

}
