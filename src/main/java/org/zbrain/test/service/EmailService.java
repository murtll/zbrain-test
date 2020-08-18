package org.zbrain.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.zbrain.test.entity.EmailModel;

public interface EmailService {

    ResponseEntity<String> addEmailIfNotAdded(EmailModel email);

}
