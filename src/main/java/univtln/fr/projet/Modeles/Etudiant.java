package univtln.fr.projet.Modeles;

public class Etudiant  {




    private int IdEtud;
    private String Email;
    private String Nom;
    private String Prenom;


    public Etudiant(int IdEtud, String nom, String Prenom, String Email)
    {
        this.IdEtud = IdEtud;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Email = Email;
    }

    public int getIdEtud() {
        return IdEtud;
    }

    public void setIdEtud(int idEtud) {
        IdEtud = idEtud;
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
        return IdEtud + " " + Nom + " " + Prenom + " "+ Email;
    }
}
