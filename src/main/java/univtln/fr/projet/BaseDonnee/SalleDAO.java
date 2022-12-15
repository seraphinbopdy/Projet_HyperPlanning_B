package univtln.fr.projet.BaseDonnee;

import univtln.fr.projet.Modeles.Matiere;
import univtln.fr.projet.Modeles.Salle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalleDAO implements AutoCloseable{





    private final Connection connection;
    private final PreparedStatement findAll;
    private final PreparedStatement findById;
    private final PreparedStatement persist;
    private final PreparedStatement remove;




    private SalleDAO() throws SQLException {
        connection = DriverManager.getConnection(MainTest.DB_URL, MainTest.USER, MainTest.PASS);
        findAll = connection.prepareStatement(" SELECT *  FROM \"Salle\"  ");
        findById = connection.prepareStatement("SELECT * FROM \"Salle\" WHERE \"IdSalle\" = ?");
        persist = connection.prepareStatement("INSERT INTO \"Salle\" VALUES (?)");
        remove = connection.prepareStatement("DELETE FROM \"Salle\"  WHERE \"IdSalle\" = ?");
        System.err.println("Connection reussi!");
    }

    public static SalleDAO create() throws SQLException {
        return new SalleDAO();
    }


    public boolean exist(int IdSalle) throws SQLException {
        findById.setInt(1,IdSalle);
        ResultSet rs = findById.executeQuery();
        return rs.next();
    }


    public List<Salle> findAll() throws SQLException
    {
        List<Salle> personneList = new ArrayList<Salle>();
        ResultSet resultSet = findAll.executeQuery();

        while (resultSet.next())
        {
            personneList.add(new Salle(resultSet.getInt("IdSalle")));
        }
        return personneList;
    }



    public Salle findById(int Ident) throws SQLException {
        Salle salle = null;
        findById.setInt  (1, Ident);
        ResultSet rs = findById.executeQuery();


        //j'extrait les données du resultset et je passe dans les variables
        while (rs.next()) {
            salle = new Salle(rs.getInt("IdSalle"));
        }
        return salle;
    }


    public Salle persist(Salle salle) throws SQLException {
        return persist(salle.getIdSalle());
    }



    public Salle persist(int IdSalle) throws SQLException {
        persist.setInt(1,IdSalle);

        if(persist.executeUpdate() == 1){
            System.out.println(IdSalle + " persited");
        }
        return new Salle(IdSalle);
    }

    public void remove(Salle salle) throws SQLException {
        remove(salle.getIdSalle());
    }

    public void remove(int IdSalle) throws SQLException {
        remove.setInt(1, IdSalle);
        remove.executeUpdate();
        System.out.println(IdSalle + " removed.");
    }



    @Override
    public void close() throws Exception {
        connection.close();
    }
}
