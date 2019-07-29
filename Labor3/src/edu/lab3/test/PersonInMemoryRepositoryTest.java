package edu.lab3.test;

import edu.lab3.api.domain.Mitarbeiter;
import edu.lab3.api.repository.PersonInMemoryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonInMemoryRepositoryTest {

    PersonInMemoryRepository personInMemoryRepository =new PersonInMemoryRepository();

    Mitarbeiter machMitarbeiter2()
    {
        Mitarbeiter mitarbeiter2 = new Mitarbeiter();
        mitarbeiter2.setAdresse("Strada nr. 2");
        mitarbeiter2.setID((long)2);
        mitarbeiter2.setStundenProTag(8);
        mitarbeiter2.setErfahrungsNiveau(1);
        mitarbeiter2.setStundenLohn(17.33);
        mitarbeiter2.setNachName("Bob2");
        mitarbeiter2.setVorName("Bobby2");
        mitarbeiter2.setBerufPosition(Mitarbeiter.berufsPosition.Entwickler);
        return mitarbeiter2;
    }

    Mitarbeiter machMitarbeiter1()
    {
        Mitarbeiter mitarbeiter1 = new Mitarbeiter();
        mitarbeiter1.setAdresse("Strada nr. 1");
        mitarbeiter1.setID((long) 1);
        mitarbeiter1.setNachName("Bob");
        mitarbeiter1.setVorName("Bobby");
        mitarbeiter1.setStundenLohn(12.5);
        mitarbeiter1.setErfahrungsNiveau(3);
        mitarbeiter1.setStundenProTag(6);
        mitarbeiter1.setBerufPosition(Mitarbeiter.berufsPosition.Tester);
        return mitarbeiter1;
    }

    Mitarbeiter machMitarbeiter3()

    {
        Mitarbeiter mitarbeiter3 = new Mitarbeiter();
        mitarbeiter3.setAdresse("Strada nr. 3");
        mitarbeiter3.setID((long) 3);
        mitarbeiter3.setStundenProTag(10);
        mitarbeiter3.setErfahrungsNiveau(4);
        mitarbeiter3.setStundenLohn(12.5);
        mitarbeiter3.setNachName("Bob3");
        mitarbeiter3.setVorName("Bobby3");
        mitarbeiter3.setBerufPosition(Mitarbeiter.berufsPosition.TeamLeader);
        return mitarbeiter3;
    }

    List<Mitarbeiter> machMitarbeiterListe()
    {
        List<Mitarbeiter> inMemoryListe = new ArrayList<>();

        Mitarbeiter mitarbeiter1 =machMitarbeiter1();
        Mitarbeiter mitarbeiter2 =machMitarbeiter2();
        Mitarbeiter mitarbeiter3= machMitarbeiter3();
        inMemoryListe.add(mitarbeiter1);
        inMemoryListe.add(mitarbeiter2);
        inMemoryListe.add(mitarbeiter3);

       personInMemoryRepository.setInMemoryListe(inMemoryListe);
       return inMemoryListe;

    }

    Mitarbeiter machMitarbeiterUpdate()
    {
        Mitarbeiter mitarbeiter7 = new Mitarbeiter();
        mitarbeiter7.setAdresse("Strada nr. 3");
        mitarbeiter7.setID((long) 3);
        mitarbeiter7.setStundenProTag(11);
        mitarbeiter7.setErfahrungsNiveau(4);
        mitarbeiter7.setStundenLohn(12.55);
        mitarbeiter7.setNachName("Bob33");
        mitarbeiter7.setVorName("Bobby33");
        mitarbeiter7.setBerufPosition(Mitarbeiter.berufsPosition.ProjectManager);
        return mitarbeiter7;
    }

    @org.junit.jupiter.api.Test
    void findOne() {
        machMitarbeiterListe();
        Mitarbeiter m2= machMitarbeiter2();
        assertEquals(m2,personInMemoryRepository.findOne((long) 2));
    }

    @org.junit.jupiter.api.Test
    void findAll() {
    List<Mitarbeiter> newInMemoryListe = machMitarbeiterListe();
    assertEquals(newInMemoryListe,personInMemoryRepository.getInMemoryListe());
    }

    @org.junit.jupiter.api.Test
    void save() {
        List<Mitarbeiter> newInMemoryListe = new ArrayList<>();
        Mitarbeiter mitarbeiter4 =machMitarbeiter1();
        newInMemoryListe.add(mitarbeiter4);
        personInMemoryRepository.setInMemoryListe(newInMemoryListe);
        personInMemoryRepository.save(mitarbeiter4);
        assertEquals(mitarbeiter4,personInMemoryRepository.findOne((long) 1));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        List<Mitarbeiter> newInMemoryListe = new ArrayList<>();
        Mitarbeiter mitarbeiter5 =machMitarbeiter1();
        newInMemoryListe.add(mitarbeiter5);
        personInMemoryRepository.setInMemoryListe(newInMemoryListe);
        personInMemoryRepository.delete((long)1);
        assertEquals(newInMemoryListe.size(),personInMemoryRepository.getInMemoryListe().size());
    }

    @org.junit.jupiter.api.Test
    void update() {
        machMitarbeiterListe();
        Mitarbeiter mitarbeiter7 =machMitarbeiterUpdate();
        personInMemoryRepository.update(mitarbeiter7);
        assertEquals(mitarbeiter7,personInMemoryRepository.findOne((long) 3));
    }
}