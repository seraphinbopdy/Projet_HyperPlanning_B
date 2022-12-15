package univtln.fr.projet.Modeles;

public class Filiere {




    private int IdFiliere;
    private String Filiere;


    public Filiere(int IdFiliere, String Filiere)
    {
        this.Filiere = Filiere;
        this.IdFiliere = IdFiliere;
    }

    public static Filiere newInstance(int IdFiliere, String Filiere)
    {
        return new Filiere(IdFiliere, Filiere);
    }


    public int getIdFiliere() {
        return IdFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        IdFiliere = idFiliere;
    }

    public String getNomFiliere() {
        return Filiere;
    }

    public void setNomFiliere(String nomFiliere) {
        Filiere = nomFiliere;
    }

    @Override
    public String toString() {
        return "NomeFiliere:  "+ Filiere;
    }


}
