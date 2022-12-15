package univtln.fr.projet.Modeles;

public class Matiere {


    private String NomMatiere;
    private int IdMat;
    private String Semestre;


    public Matiere(int IdMat, String NomMatiere, String Semestre)
    {
        this.IdMat = IdMat;
        this.NomMatiere = NomMatiere;
        this.Semestre = Semestre;
    }

    public static Matiere newInstance(int IdMat, String NomMatiere, String Semestre)
    {
        return new Matiere(IdMat,NomMatiere,Semestre);
    }




    public String getNomMatiere() {
        return NomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        NomMatiere = nomMatiere;
    }

    public int getIdMat() {
        return IdMat;
    }

    public void setIdMat(int idMat) {
        IdMat = idMat;
    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String semestre) {
        Semestre = semestre;
    }

    @Override
    public String toString() {
        return "nomMatiere:  "+NomMatiere+ "identMatiere:  "+ IdMat + " Semestre: "+ Semestre;
    }
}
