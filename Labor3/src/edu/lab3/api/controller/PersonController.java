package edu.lab3.api.controller;

import edu.lab3.api.domain.Mitarbeiter;
import edu.lab3.api.repository.CrudRepository;
import edu.lab3.api.repository.PersonFileRepository;
import edu.lab3.api.repository.PersonInMemoryRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonController {
   private CrudRepository<Mitarbeiter> personCrudRepository;
  public PersonController(){}

    public PersonController(CrudRepository<Mitarbeiter> personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }

    public void wahlRepository(Boolean wahl)
   {
       if(wahl)
       personCrudRepository = new PersonInMemoryRepository();
        else
            personCrudRepository = new PersonFileRepository();

   }


    public Mitarbeiter findMitarbeiterbyID(Long id)
    {
        return personCrudRepository.findOne(id);
    }

    List<Mitarbeiter> findAll()
    {
        List<Mitarbeiter> result = new ArrayList<>();
        personCrudRepository.findAll().forEach(result::add);
        return result;
    }

    Mitarbeiter updateMitarbeiter (Mitarbeiter m)
    {
        return personCrudRepository.update(m);
    }
    Mitarbeiter deleteMitarbeiter(Long id)

    {
        return personCrudRepository.delete(id);
    }

    Mitarbeiter saveMitarbeiter (Mitarbeiter m)
    {
        return personCrudRepository.save(m);
    }

    public double berechneLohn(Mitarbeiter m, Integer numberOfDays)
    {

        return numberOfDays*m.getStundenLohn()*m.getStundenProTag();
    }


    public void gehaltBerufsPosition (Mitarbeiter.berufsPosition berufsPosition)
    {
        /**
         * - Gehalte nur für ein ausgewähltes berufsPosition (z.B. Salaries für alle
         *  Entwicklern);
         */
        double gehalt = 0;
        for(Mitarbeiter mitarbeiter : personCrudRepository.findAll())
        {
            if(mitarbeiter.getBerufPosition().equals(berufsPosition)) {
                gehalt= berechneLohn(mitarbeiter,365);
                System.out.println("Das Gehalt der "+berufsPosition+" ist: "+gehalt+'\n');
            }
        }
    }

    public void gehaltAlleMitarbeitern ()
    {
        /**
         * - Gehalte für alle Mitarbeitern;
         */
        for (Mitarbeiter mitarbeiter : personCrudRepository.findAll())
        {
            System.out.println("Das Gehalt der Mitarbeiter ist:" + berechneLohn(mitarbeiter,365));
        }
    }

    public void gehaltAusgewehlterNiveau (Integer niveau)
    /**
     * - Gehalte nur für eine ausgewählte Niveau (z.B. Salaries für alle Mitarbeiter
     *   welche auf Niveau 3 sind);
     */
    {
        for (Mitarbeiter mitarbeiter : personCrudRepository.findAll()) {
            System.out.println("Das Gehalt der Mitarbeiter mit Niveau " + niveau.toString() + " ist:"
                    + berechneLohn(mitarbeiter, 365));
        }
    }

    public CrudRepository<Mitarbeiter> getPersonCrudRepository() {
        return personCrudRepository;
    }

    public void setPersonCrudRepository(CrudRepository<Mitarbeiter> personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }
}


