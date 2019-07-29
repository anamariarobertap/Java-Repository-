package edu.lab3FX.api.controller;

import edu.lab3FX.api.model.Mitarbeiter;
import edu.lab3FX.api.repository.CrudRepository;
import edu.lab3FX.api.repository.InDatabaseRepository;
import edu.lab3FX.api.repository.PersonFileRepository;
import edu.lab3FX.api.repository.PersonInMemoryRepository;
import javafx.concurrent.Worker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonController {
    private CrudRepository<Mitarbeiter> personCrudRepository;
    public PersonController(){}

    public PersonController(CrudRepository<Mitarbeiter> personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }

    public void wahlRepository(int wahl)
    {
        if(wahl==0)
            personCrudRepository = new PersonInMemoryRepository();
        else if (wahl ==1)
            personCrudRepository = new PersonFileRepository();
        else if (wahl ==2){
            try {
                personCrudRepository=new InDatabaseRepository();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public Mitarbeiter findMitarbeiterbyID(Long id)
    {
        return personCrudRepository.findOne(id);
    }

    protected List<Mitarbeiter> findAll()
    {
        List<Mitarbeiter> result = new ArrayList<>();
        personCrudRepository.findAll().forEach(result::add);
        //result = (List<Mitarbeiter>) personCrudRepository.findAll();
        return result;
    }

    protected Mitarbeiter updateMitarbeiter (Mitarbeiter m)
    {
        return personCrudRepository.update(m);
    }
    protected Mitarbeiter deleteMitarbeiter(Long id)

    {
        return personCrudRepository.delete(id);
    }

    protected Mitarbeiter saveMitarbeiter (Mitarbeiter m){
        return personCrudRepository.save(m);
    }

    public double berechneLohn(Mitarbeiter m, Integer numberOfDays)
    {

        return numberOfDays*m.getStundenLohn()*m.getStundenProTag();
    }


    public String gehaltBerufsPosition (Mitarbeiter.berufsPosition berufsPosition)
    {
        /**
         * - Gehalte nur für ein ausgewähltes berufsPosition (z.B. Salaries für alle
         *  Entwicklern);
         */
        double gehalt = 0;
        StringBuilder s = new StringBuilder(" ");
        for(Mitarbeiter mitarbeiter : personCrudRepository.findAll())
        {
            if(mitarbeiter.getBerufPosition().equals(berufsPosition)) {
                gehalt= berechneLohn(mitarbeiter,365);
                assert false;
                s.append("\n Das Gehalt der ").append(berufsPosition).append(" ist: ").append(gehalt).append('\n');
            }
        }
        File file =new File("D:\\LabMAP\\Lab3JFX\\src\\salary.txt");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file,false));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert bufferedWriter != null;
            bufferedWriter.write(s.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s.toString();
    }

    protected String gehaltAlleMitarbeitern(){
        /**
         * - Gehalte für alle Mitarbeitern;
         */
        StringBuilder s= new StringBuilder(" ");
        for (Mitarbeiter mitarbeiter : personCrudRepository.findAll())
        {
            s.append("\n Das Gehalt der Mitarbeiter ist:").append(berechneLohn(mitarbeiter, 365));
        }

        File file =new File("D:\\LabMAP\\Lab3JFX\\src\\salary.txt");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file,false));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert bufferedWriter != null;
            bufferedWriter.write(s.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s.toString();
    }

    protected String gehaltAusgewehlterNiveau(Integer niveau)
    /**
     * - Gehalte nur für eine ausgewählte Niveau (z.B. Salaries für alle Mitarbeiter
     *   welche auf Niveau 3 sind);
     */
    {
        StringBuilder s= new StringBuilder(" ");
        for (Mitarbeiter mitarbeiter : personCrudRepository.findAll()) {
            if(mitarbeiter.getErfahrungsNiveau()==niveau) {
                s.append("\n Das Gehalt der Mitarbeiter mit Niveau ").append(niveau.toString()).append(" ist:").append(berechneLohn(mitarbeiter, 365));
            }
        }
        File file =new File("D:\\LabMAP\\Lab3JFX\\src\\salary.txt");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file,false));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert bufferedWriter != null;
            bufferedWriter.write(s.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    public CrudRepository<Mitarbeiter> getPersonCrudRepository() {
        return personCrudRepository;
    }

    public void setPersonCrudRepository(CrudRepository<Mitarbeiter> personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }
}



