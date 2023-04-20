package ma.enset.mobilebackend.web;

import ma.enset.mobilebackend.entities.Contacts;
import ma.enset.mobilebackend.repositories.ContactsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ContratRestController {
    
    private ContactsRepository contactsRepository;

    public ContratRestController(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }


    @GetMapping("/contacts")
    public List<Contacts> getContacts() {
        return contactsRepository.findAll();
    }

    @GetMapping("/contact/{id}")
    public Contacts banckAccount(@PathVariable Integer id) {
        return contactsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account not found", id)));
    }

    @PostMapping("/contacts")
    public Contacts save(@RequestBody Contacts contact) {
        return contactsRepository.save(contact);
    }

    @PutMapping("/contact/{id}")
    public Contacts update(@PathVariable Integer id , @RequestBody Contacts contact) {

        Contacts contacts = contactsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account not found", id)));

        if(contact.getNom() != null ) contacts.setNom(contact.getNom());
        if(contact.getPrenom() != null ) contacts.setPrenom(contacts.getPrenom());
        if(contact.getEmail() != null ) contacts.setEmail(contacts.getEmail());
        if(contact.getTel() != null ) contacts.setTel(contact.getTel());

        return contactsRepository.save(contacts);
    }

}
