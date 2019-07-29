package edu.lab3FX.api.repository;

import edu.lab3FX.api.model.Mitarbeiter;

import java.util.ArrayList;
import java.util.List;

public class PersonInMemoryRepository implements CrudRepository<Mitarbeiter> {

    public PersonInMemoryRepository(List<Mitarbeiter> inMemoryListe) {
        this.inMemoryListe = inMemoryListe;
    }

    public PersonInMemoryRepository() {
    }


    public List<Mitarbeiter> getInMemoryListe() {
        return inMemoryListe;
    }

    public void setInMemoryListe(List<Mitarbeiter> inMemoryListe) {
        this.inMemoryListe = inMemoryListe;
    }

    private List<Mitarbeiter> inMemoryListe = new ArrayList<>();

    @Override
    public Mitarbeiter findOne(Long id) {
        for (Mitarbeiter mitarbeiter : inMemoryListe) {
            if (mitarbeiter.getID().equals(id))
                return mitarbeiter;
        }
        return null;
    }

    @Override
    public Iterable<Mitarbeiter> findAll() {
        return inMemoryListe;
    }

    @Override
    public Mitarbeiter save(Mitarbeiter entity) {
        boolean valid = true;
        for (Mitarbeiter mitarbeiter : inMemoryListe) {
            if (mitarbeiter.getID().equals(entity.getID())) {
                valid = false;
            }
        }
        if (!valid)
            return null;
        else {
            inMemoryListe.add(entity);

            return entity;
        }
    }

    @Override
    public Mitarbeiter delete(Long id) {


        Mitarbeiter deleteMitarbeiter = new Mitarbeiter();

        for (Mitarbeiter mitarbeiter : inMemoryListe) {
            if (mitarbeiter.getID().equals(id)) {
                inMemoryListe.remove(mitarbeiter);

                deleteMitarbeiter = mitarbeiter;
                break;
            }
        }
        return deleteMitarbeiter;

    }

    @Override
    public Mitarbeiter update(Mitarbeiter entity) {

        boolean verify = false;

        for (Mitarbeiter mitarbeiter : inMemoryListe) {
            if (mitarbeiter.getID().equals(entity.getID())) {
                mitarbeiter.setErfahrungsNiveau(entity.getErfahrungsNiveau());
                mitarbeiter.setStundenLohn(entity.getStundenLohn());
                mitarbeiter.setStundenProTag(entity.getStundenProTag());
                mitarbeiter.setBerufPosition(entity.getBerufPosition());
                mitarbeiter.setVorName(entity.getVorName());
                mitarbeiter.setNachName(entity.getNachName());
                mitarbeiter.setAdresse(entity.getAdresse());
                verify = true;
            }
        }
        if (!verify)
            return null;
        else return entity;
    }

}