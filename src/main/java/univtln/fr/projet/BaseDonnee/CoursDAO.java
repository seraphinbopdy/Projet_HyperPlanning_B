package univtln.fr.projet.BaseDonnee;
import univtln.fr.projet.Modeles.Cours;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class CoursDAO implements AutoCloseable{




    private final Connection connection;
    private final PreparedStatement findAll;
    private final PreparedStatement findById;
    private final PreparedStatement persist;
    private final PreparedStatement remove;



    private CoursDAO() throws SQLException {
        connection = DriverManager.getConnection(MainTest.DB_URL, MainTest.USER, MainTest.PASS);
        findAll = connection.prepareStatement(" SELECT *  FROM \"Cours\"  ");
        findById = connection.prepareStatement("SELECT * FROM \"Cours\" WHERE \"IdCours\" = ?");
        persist = connection.prepareStatement("INSERT INTO \"Cours\" VALUES (?,?,?,?,?,?,?,?,?)");
        remove = connection.prepareStatement("DELETE FROM \"Cours\"  WHERE \"IdCours\" = ?");
        System.err.println("Connection reussi!");
    }

    public static CoursDAO create() throws SQLException {
        return new CoursDAO();
    }

    public boolean exist(int IdCours) throws SQLException {
        findById.setInt(1,IdCours);
        ResultSet rs = findById.executeQuery();
        return rs.next();
    }

    public List<Cours> findAll() throws SQLException
    {
        Cours cours = null;
        List<Cours> personneList = new ArrayList<Cours>();
        ResultSet resultSet = findAll.executeQuery();

        while (resultSet.next())
        {
            personneList.add(new Cours(resultSet.getInt("IdCours"),resultSet.getDate("Date").toLocalDate(),resultSet.getTime("HeureDebut").toLocalTime(),
                    resultSet.getTime("HeureFin").toLocalTime(),resultSet.getInt("IdEns"),resultSet.getInt("IdFiliere"),
                    resultSet.getInt("IdMatiere"),resultSet.getInt("IdSalle"), Cours.TypeCours.valueOf(resultSet.getString("typeCours"))


            ));
        }
        return personneList;
    }

    public Cours findById(int Id) throws SQLException {
        Cours cours = null;
       // int iden = 0, idens = 0, idfiliere =0,idsalle =0,idematiere=0;
        findById.setInt(1, Id);
        ResultSet rs = findById.executeQuery();

        System.out.println(" RS" +rs);
        //j'extrait les données du resultset
        while (rs.next()) {
            cours = new Cours(rs.getInt("IdCours"), rs.getDate("Date").toLocalDate(),
                    rs.getTime("HeureDebut").toLocalTime(),  rs.getTime("HeureFin").toLocalTime(),
                    rs.getInt("IdEns"), rs.getInt("IdFiliere"),rs.getInt("IdMatiere"),rs.getInt("IdSalle"),
                    Cours.TypeCours.valueOf(rs.getString("typeCours")));

        }
        return cours;
    }


    public Cours persist(Cours cours) throws SQLException {
        return persist(cours.getIdCours(), cours.getDate(),
                cours.getHeureDebut(),cours.getHeureFin(),
                cours.getIdEns(),
                cours.getIdFiliere(),cours.getIdSalle()
                ,cours.getIdMatiere(),cours.getTypeCours());
    }

    private Cours persist(int IdCours, LocalDate  Date, LocalTime HeureDebut,
                          LocalTime HeureFin , int IdEns, int IdFiliere
                        , int IdMatiere, int IdSalle
                            , Cours.TypeCours typeCours) throws SQLException {
        persist.setInt(1,IdCours);
        persist.setObject(2, Date);
        persist.setObject(3,HeureDebut);
        persist.setObject(4,HeureFin);
        persist.setInt(5,IdEns);
        persist.setInt(6,IdFiliere);
        persist.setInt(7,IdMatiere);
        persist.setInt(8,IdSalle);
        persist.setString(9, typeCours.name());

        if(persist.executeUpdate() == 1){
            System.out.println(IdCours + " persited");
        }
        return new Cours(IdCours, Date, HeureDebut, HeureFin ,  IdEns, IdFiliere
            ,  IdMatiere, IdSalle
            , typeCours);
    }

    public void remove(Cours cours) throws SQLException {
        remove(cours.getIdCours());
    }

    public void remove(int IdCours) throws SQLException {
        remove.setInt(1, IdCours);
        remove.executeUpdate();
        System.out.println(IdCours + " removed.");
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
