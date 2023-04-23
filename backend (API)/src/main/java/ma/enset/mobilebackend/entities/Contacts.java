package ma.enset.mobilebackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Contacts {
    @Id
    private int id;
    private String nom;
    private String prenom;

    private String email;

    private String tel;
}
