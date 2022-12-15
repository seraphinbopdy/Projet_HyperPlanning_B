package univtln.fr.projet.Modeles;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cours {



    public enum TypeCours {TP,TD,CN,CT};

    //private LocalDate date;

    private LocalDate Date;
    private LocalTime HeureDebut;
    private LocalTime HeureFin;
    private TypeCours typeCours;
    private int IdCours;
    private int IdFiliere;
    private int IdSalle;
    private int IdEns;
    private int IdMatiere;

    public Cours(int IdCours, LocalDate Date, LocalTime HeureDebut,
                 LocalTime HeureFin,int IdEns, int IdFiliere , int IdMatiere ,int IdSalle,TypeCours typeCours)
    {
        this.IdCours = IdCours;
        this.IdFiliere = IdFiliere;
        this.IdSalle = IdSalle;
        this.IdEns = IdEns;
        this.IdMatiere = IdMatiere;
        this.Date = Date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.typeCours = typeCours;
    }

    public static Cours newInstance(int IdCours,LocalDate Date,LocalTime HeureDebut, LocalTime HeureFin ,int IdEns, int IdFiliere
            ,int IdMatiere, int IdSalle
            ,TypeCours typeCours)
    {
        return new Cours(IdCours,Date,HeureDebut,HeureFin,IdEns,IdFiliere,IdMatiere,IdSalle,typeCours);
    }


    public int getIdEns() {
        return IdEns;
    }

    public void setIdEns(int idEns) {
        IdEns = idEns;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public TypeCours getTypeCours() {
        return typeCours;
    }

    public void setTypeCours(TypeCours typeCours) {
        this.typeCours = typeCours;
    }

    public int getIdCours() {
        return IdCours;
    }

    public void setIdCours(int idCours) {
        IdCours = idCours;
    }

    public LocalTime getHeureDebut() {
        return HeureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        HeureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return HeureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        HeureFin = heureFin;
    }

    public int getIdFiliere() {
        return IdFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        IdFiliere = idFiliere;
    }

    public int getIdSalle() {
        return IdSalle;
    }

    public void setIdSalle(int idSalle) {
        IdSalle = idSalle;
    }

    public int getIdMatiere() {
        return IdMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        IdMatiere = idMatiere;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "identCours='" + IdCours + '\'' +
                ", typeCours=" + typeCours +
                ", filiere=" + IdFiliere +
                ", salle=" + IdSalle +
                ", Enseignant=" + IdEns +
                ", HeureDebut=" + HeureDebut+
                ", HeureFin=" + HeureFin +
                ", matiere=" + IdMatiere +
                ", date=" + Date +
                '}';
    }




    /*
    public enum TypeCours {TP,TD,CN,CT};

    private LocalDate date;

    private String Date;
    private String HeureDebut;
    private String HeureFin;
    private TypeCours typeCours;
    private int IdCours;
    private int IdFiliere;
    private int IdSalle;
    private int IdEns;
    private int IdMatiere;

    public Cours(int IdCours, String Date, String HeureDebut,
                 String HeureFin,int IdEns, int IdFiliere , int IdMatiere ,int IdSalle,TypeCours typeCours)
    {
        this.IdCours = IdCours;
        this.IdFiliere = IdFiliere;
        this.IdSalle = IdSalle;
        this.IdEns = IdEns;
        this.IdMatiere = IdMatiere;
        this.Date = Date;
        this.HeureDebut = HeureDebut;
        this.HeureFin = HeureFin;
        this.typeCours = typeCours;
    }

    public static Cours newInstance(int IdCours,String Date,String HeureDebut, String HeureFin ,int IdEns, int IdFiliere
                                   ,int IdMatiere, int IdSalle
                                   ,TypeCours typeCours)
    {
        return new Cours(IdCours,Date,HeureDebut,HeureFin,IdEns,IdFiliere,IdMatiere,IdSalle,typeCours);
    }


    public int getIdEns() {
        return IdEns;
    }

    public void setIdEns(int idEns) {
        IdEns = idEns;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHeureDebut() {
        return HeureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        HeureDebut = heureDebut;
    }

    public String getHeureFin() {
        return HeureFin;
    }

    public void setHeureFin(String heureFin) {
        HeureFin = heureFin;
    }

    public TypeCours getTypeCours() {
        return typeCours;
    }

    public void setTypeCours(TypeCours typeCours) {
        this.typeCours = typeCours;
    }

    public int getIdCours() {
        return IdCours;
    }

    public void setIdCours(int idCours) {
        IdCours = idCours;
    }

    public int getIdFiliere() {
        return IdFiliere;
    }

    public void setIdFiliere(int idFiliere) {
        IdFiliere = idFiliere;
    }

    public int getIdSalle() {
        return IdSalle;
    }

    public void setIdSalle(int idSalle) {
        IdSalle = idSalle;
    }

    public int getIdMatiere() {
        return IdMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        IdMatiere = idMatiere;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "identCours='" + IdCours + '\'' +
                ", typeCours=" + typeCours +
                ", filiere=" + IdFiliere +
                ", salle=" + IdSalle +
                ", professeur=" + IdEns +
                ", matiere=" + IdMatiere +
                ", matiere=" + Date + date +
                '}';
    }
*/
}
