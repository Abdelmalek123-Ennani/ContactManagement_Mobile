package ma.enset.mobilebackend;

import ma.enset.mobilebackend.entities.Contacts;
import ma.enset.mobilebackend.repositories.ContactsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class MobileBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ContactsRepository contactsRepository) {
        return args -> {
            for (int i=0; i< 10; i++) {
                Contacts contact = new Contacts((int) (Math.random() * 10 + 10000),
                        "Abdelmalek",
                        "last_",
                        "test@email.com",
                        "067834120954"
                        );
                contactsRepository.save(contact);
            }
        };
    }

}
