package univtln.fr.projet.BaseDonnee;

import univtln.fr.projet.Modeles.Enseignant;
import univtln.fr.projet.Modeles.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO implements AutoCloseable{




    private final Connection connection;
    private final PreparedStatement findAll;
    private final PreparedStatement findById;
    private final PreparedStatement persist;
    private final PreparedStatement remove;




    private EtudiantDAO() throws SQLException {
        connection = DriverManager.getConnection(MainTest.DB_URL, MainTest.USER, MainTest.PASS);
        findAll = connection.prepareStatement(" SELECT *  FROM \"Etudiant\"  ");
        findById = connection.prepareStatement("SELECT * FROM \"Etudiant\" WHERE \"IdEtud\" = ?");
        persist = connection.prepareStatement("INSERT INTO \"Etudiant\" VALUES (?,?,?,?)");
        remove = connection.prepareStatement("DELETE FROM \"Etudiant\"  WHERE \"IdEtud\" = ?");
        System.err.println("Connection reussi!");
    }

    public static EtudiantDAO create() throws SQLException {
        return new EtudiantDAO();
    }


    public boolean exist(int IdEtud) throws SQLException {
        findById.setInt(1,IdEtud);
        ResultSet rs = findById.executeQuery();
        return rs.next();
    }


    public List<Etudiant> findAll() throws SQLException
    {
        List<Etudiant> personneList = new ArrayList<Etudiant>();
        ResultSet resultSet = findAll.executeQuery();

        while (resultSet.next())
        {
            personneList.add(new Etudiant(resultSet.getInt("IdEtud"),
                    resultSet.getString("Nom"),
                    resultSet.getString("Prenom"),
                    resultSet.getString("Email")
            ));
        }
        return personneList;
    }



    public Etudiant findById(int Ident) throws SQLException {
        Etudiant etudiant = null;
        findById.setInt(1, Ident);
        ResultSet rs = findById.executeQuery();


        //j'extrait les données du resultset et je passe dans les variables
        while (rs.next()) {
            etudiant = new Etudiant(rs.getInt("IdEtud"),
                    rs.getString("Nom"),
                    rs.getString("Prenom"),
                    rs.getString("Email"));
        }
        return etudiant;
    }


    public Etudiant persist(Etudiant etudiant) throws SQLException {
        return persist(etudiant.getIdEtud(),
                etudiant.getNom()
                ,etudiant.getPrenom(),
                etudiant.getEmail());
    }


    private Etudiant persist(int IdEtud, String Nom, String Prenom, String Email) throws SQLException {
        persist.setInt(1,IdEtud);
        persist.setString(2, Nom);
        persist.setString(3,Prenom);
        persist.setString(4,Email);

        if(persist.executeUpdate() == 1){
            System.out.println(IdEtud+ " persited");
        }
        return new Etudiant(IdEtud, Nom,Prenom, Email);
    }

    public void remove(Etudiant etudiant) throws SQLException {
        remove(etudiant.getIdEtud());
    }

    public void remove(int IdEtud) throws SQLException {
        remove.setInt(1, IdEtud);
        remove.executeUpdate();
        System.out.println(IdEtud+ " removed.");
    }


    @Override
    public void close() throws Exception {
        connection.close();
    }
}
