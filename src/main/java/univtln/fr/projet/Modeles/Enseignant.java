package univtln.fr.projet.Modeles;

public class Enseignant {



    private int IdEns;
    private String Email;
    private String Nom;
    private String Prenom;


    public Enseignant(int IdEns, String Nom, String Prenom, String Email)
    {

        this.IdEns = IdEns;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;

    }

    public int getIdEns() {
        return IdEns;
    }

    public void setIdEns(int idEns) {
        IdEns = idEns;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    @Override
    public String toString() {

        return  IdEns + " " + Nom + " "+ Prenom + " "+ Email;
    }
}
