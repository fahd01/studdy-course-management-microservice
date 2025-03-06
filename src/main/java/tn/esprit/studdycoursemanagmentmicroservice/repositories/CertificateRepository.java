package tn.esprit.studdycoursemanagmentmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.studdycoursemanagmentmicroservice.entities.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
