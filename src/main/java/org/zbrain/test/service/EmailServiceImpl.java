package org.zbrain.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zbrain.test.entity.EmailModel;
import org.zbrain.test.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public boolean addEmailIfNotAdded(EmailModel email) {

        System.out.println(email.getEmail());

        if (emailRepository.existsById(email.getEmail())){
            return false;
        } else {
            emailRepository.save(email);
        }

        return true;
    }
}
