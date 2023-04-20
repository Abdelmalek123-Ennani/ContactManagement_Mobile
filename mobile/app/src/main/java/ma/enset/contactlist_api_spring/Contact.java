package ma.enset.contactlist_api_spring;

public class Contact {

    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;

    public Contact(Long id, String nom, String prenom, String email, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
    }

    public Contact(Contact c) {
        this.id = c.id;
        this.nom = c.nom;
        this.prenom = c.prenom;
        this.email = c.email;
        this.tel = c.tel;
    }

    public long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
