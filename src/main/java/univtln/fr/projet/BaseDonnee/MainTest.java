package univtln.fr.projet.BaseDonnee;

import univtln.fr.projet.Modeles.Cours;
import univtln.fr.projet.Modeles.Etudiant;
import univtln.fr.projet.Modeles.Matiere;
import univtln.fr.projet.Modeles.Salle;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class MainTest {


    public static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static String USER = "postgres";
    public static String PASS = "yves&pat";






    public static void main(String[] args) throws Exception {


        //cette partie permet d'executer le la Relation Etudiant

        try (EtudiantDAO etudiantDAO = EtudiantDAO.create()) {
            System.err.println(etudiantDAO.findById(1));
            Etudiant etudiant = new Etudiant(5,"Bopdy", "Seraphin","seraph#yahoo.fr");
            Etudiant etudiant1 = new Etudiant(9,"HAjar"," Hajar","hajar@yahoo.com");

            System.out.println(" ByID" + etudiantDAO.findById(4));
            System.out.println(" Persiste" + etudiantDAO.persist(etudiant));
            System.err.println(" Select tous les etudiant --> " + etudiantDAO.findAll());

            etudiantDAO.remove(etudiant1);

            if (etudiantDAO.exist(4)) {
                etudiantDAO.remove(4);
            } else
                etudiantDAO.persist(etudiant1);
            System.err.println(etudiantDAO.findById(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }






/*
        //cette partie teste la Relation Matiere

        try (MatiereDAO matiereDAO = MatiereDAO.create()) {
            System.err.println(matiereDAO.findById(1));
            Matiere matiere = new Matiere(5,"Programmation_JAVA", "S1");
            Matiere matiere1 = new Matiere(9,"Protection_Données","S1");

            System.out.println(" ByID" + matiereDAO.findById(4));
            //System.out.println(" Persiste" + matiereDAO.persist(salle1));
            System.err.println(" Select tous--> " + matiereDAO.findAll());

            matiereDAO.remove(matiere);

            if (matiereDAO.exist(4)) {
                matiereDAO.remove(4);
            } else
                matiereDAO.persist(matiere);
            System.err.println(matiereDAO.findById(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


*/


        /*

         //cette partie permet d'executer le la Relation Salle

        try (SalleDAO salleDAO = SalleDAO.create()) {
            System.err.println(salleDAO.findById(1));
            Salle salle = new Salle(5);
            Salle salle1 = new Salle(9);

            System.out.println(" ByID" + salleDAO.findById(4));
            //System.out.println(" Persiste" + salleDAO.persist(salle1));
            System.err.println(" Select tous--> " + salleDAO.findAll());

            salleDAO.remove(salle);

            if (salleDAO.exist(4)) {
                salleDAO.remove(4);
            } else
                salleDAO.persist(salle1);
            System.err.println(salleDAO.findById(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */

















        /*
        // cette partie permet d'executer le la Relation Cours



        try (CoursDAO coursDAO = CoursDAO.create()) {
            System.err.println(coursDAO.findById(1));
            Cours cours = new Cours(10, LocalDate.now(), LocalTime.of(20, 0), LocalTime.of(22, 0), 0, 0, 0, 0, Cours.TypeCours.CT);
            Cours cours1 = new Cours(40, LocalDate.now(), LocalTime.of(20, 0), LocalTime.of(22, 0), 0, 0, 0, 0, Cours.TypeCours.TD);

            //chaque fois avant d'executer ces trois lignes suivantes verifiez les IdCours disponible deja dans la base de données
            System.out.println(" ByID" + coursDAO.findById(4));
            System.out.println(" Persiste" + coursDAO.persist(cours));
            System.err.println(" Select tous--> " +coursDAO.findAll());

            coursDAO.remove(cours);

            if (coursDAO.exist(7)) {
                coursDAO.persist(cours1);


            } else
                coursDAO.persist(cours1);
            System.err.println(coursDAO.findById(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/

    }
}
