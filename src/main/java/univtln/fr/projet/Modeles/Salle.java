package univtln.fr.projet.Modeles;

public class Salle {


    private int IdSalle;

    public Salle(int IdSalle)
    {
        this.IdSalle = IdSalle;
    }


    public int getIdSalle() {
        return IdSalle;
    }

    public void setIdSalle(int idSalle) {
        IdSalle = idSalle;
    }

    public static Salle newInstance(int IdSalle)
    {
        return new Salle(IdSalle);
    }






    @Override
    public String toString() {
        return "IdSalle:  "+ IdSalle;
    }

}
