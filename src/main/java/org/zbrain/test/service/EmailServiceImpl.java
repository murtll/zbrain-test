package org.zbrain.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.zbrain.test.entity.EmailModel;
import org.zbrain.test.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public ResponseEntity<String> addEmailIfNotAdded(EmailModel email) {

        if (emailRepository.existsByEmail(email.getEmail())){
            return new ResponseEntity<>("{\"duplicate\": true}", HttpStatus.BAD_REQUEST);
        } else {
            emailRepository.save(email);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
