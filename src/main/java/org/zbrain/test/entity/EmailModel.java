package org.zbrain.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "email")
public class EmailModel {

    @Id
    @Column(name = "email")
    private String email;

    public EmailModel() {
    }

    public EmailModel(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailAddress) {
        this.email = emailAddress;
    }
}
