package org.zbrain.test.service;

import org.zbrain.test.entity.EmailModel;

public interface EmailService {

    boolean addEmailIfNotAdded(EmailModel email);

}
