package ma.enset.mobilebackend.repositories;

import ma.enset.mobilebackend.entities.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contacts, Integer> {
}
