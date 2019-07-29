package edu.lab3FX.api.repository;

import edu.lab3FX.api.model.Mitarbeiter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InDatabaseRepository implements CrudRepository<Mitarbeiter> {

    public static Connection connection;
    public static Statement stmt;


    public static List<Mitarbeiter> inDatabaseListe = new ArrayList<>();

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab5Map", "root", "anamaria385585");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public InDatabaseRepository() throws SQLException {


    }


    public static void verbindeDatabase() throws SQLException {
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void leseVonDatatbase() throws SQLException {
        inDatabaseListe.clear();
        verbindeDatabase();
        ResultSet rs = stmt.executeQuery("select * from Mitarbeitern");
        while (rs.next()) {
            Mitarbeiter mitarbeiter = new Mitarbeiter();
            mitarbeiter.setID(rs.getLong(1));
            mitarbeiter.setVorName(rs.getString(2));
            mitarbeiter.setNachName(rs.getString(3));
            mitarbeiter.setAdresse(rs.getString(4));
            mitarbeiter.setBerufPosition(Mitarbeiter.berufsPosition.valueOf(rs.getString(5)));
            mitarbeiter.setErfahrungsNiveau(rs.getInt(6));
            mitarbeiter.setStundenLohn(rs.getDouble(7));
            mitarbeiter.setStundenProTag(rs.getInt(8));

            inDatabaseListe.add(mitarbeiter);

        }
    }

//    public static void schreibeImDatatbase(Mitarbeiter mitarbeiter) throws SQLException {
//        stmt.executeUpdate("INSERT INTO Mitarbeitern (ID, vorName, nachName, adresse, berufPosition,erfahrungsNiveau, stundenLohn, stundenProTag) values("+mitarbeiter.getID()+","+mitarbeiter.getVorName()+","+mitarbeiter.getVorName()+","+
//                mitarbeiter.getAdresse()+","+mitarbeiter.getBerufPosition()+","+mitarbeiter.getErfahrungsNiveau()+","+mitarbeiter.getStundenLohn()+","+
//                mitarbeiter.getStundenProTag()+")");
//    }

    public static void schreibeImDatatbase(Mitarbeiter mitarbeiter) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Mitarbeitern (ID, vorName, nachName, adresse, berufPosition,erfahrungsNiveau, stundenLohn, stundenProTag) values (?,?,?,?,?,?,?,?)");
             preparedStatement.setString(1,mitarbeiter.getID().toString());
             preparedStatement.setString(2,mitarbeiter.getVorName());
             preparedStatement.setString(3,mitarbeiter.getNachName());
             preparedStatement.setString(4,mitarbeiter.getAdresse());
             preparedStatement.setString(5,mitarbeiter.getBerufPosition().toString());
             preparedStatement.setString(6,String.valueOf(mitarbeiter.getErfahrungsNiveau()));
             preparedStatement.setString(7,String.valueOf(mitarbeiter.getStundenLohn()));
             preparedStatement.setString(8,String.valueOf(mitarbeiter.getStundenProTag()));
             preparedStatement.executeUpdate();
             leseVonDatatbase();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Mitarbeiter findOne(Long id) {
        for (Mitarbeiter mitarbeiter : inDatabaseListe) {
            if (mitarbeiter.getID().equals(id))
                return mitarbeiter;
        }
        return null;
    }

    @Override
    public Iterable<Mitarbeiter> findAll() {
        try {
            leseVonDatatbase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inDatabaseListe;
    }

    @Override
    public Mitarbeiter save(Mitarbeiter entity) {
        boolean valid = true;
        for (Mitarbeiter mitarbeiter : inDatabaseListe) {
            if (mitarbeiter.getID().equals(entity.getID())) {
                valid = false;
                break;
            }
        }

        if (!valid)
            return null;
        else {


            schreibeImDatatbase(entity);
            try {
                leseVonDatatbase();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return entity;
        }
    }

    @Override
    public Mitarbeiter delete(Long id) {

        Mitarbeiter deleteMitarbeiter = new Mitarbeiter();

        for (Mitarbeiter mitarbeiter : inDatabaseListe) {
            if (mitarbeiter.getID().equals(id)) {
                inDatabaseListe.remove(mitarbeiter);

                try {
                    stmt.executeUpdate("DELETE FROM Mitarbeitern WHERE ID =" + mitarbeiter.getID()+";");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                deleteMitarbeiter = mitarbeiter;
                break;
            }
        }
        return deleteMitarbeiter;
    }

    @Override
    public Mitarbeiter update(Mitarbeiter mitarbeiter) {
        PreparedStatement preparedStatement = null;
        try {
            boolean valid = false;
            leseVonDatatbase();
            if(inDatabaseListe.contains(mitarbeiter))
                valid=true;
            preparedStatement = connection.prepareStatement("UPDATE Mitarbeitern set vorName=?, nachName=?, adresse=?, berufPosition=?,erfahrungsNiveau=?, stundenLohn=?, stundenProTag=? where ID=?;");
            preparedStatement.setString(1,mitarbeiter.getVorName());
            preparedStatement.setString(2,mitarbeiter.getNachName());
            preparedStatement.setString(3,mitarbeiter.getAdresse());
            preparedStatement.setString(4,mitarbeiter.getBerufPosition().toString());
            preparedStatement.setString(5,String.valueOf(mitarbeiter.getErfahrungsNiveau()));
            preparedStatement.setString(6,String.valueOf(mitarbeiter.getStundenLohn()));
            preparedStatement.setString(7,String.valueOf(mitarbeiter.getStundenProTag()));
            preparedStatement.setString(8,mitarbeiter.getID().toString());

            preparedStatement.executeUpdate();
            if(valid){
                return null;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mitarbeiter;
    }
}
