package org.zbrain.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zbrain.test.entity.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {

    boolean existsByEmail(String email);

}
