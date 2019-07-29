package edu.lab3FX.test;

import edu.lab3FX.api.model.Mitarbeiter;
import edu.lab3FX.api.repository.PersonFileRepository;
import org.junit.jupiter.api.Test;

import static edu.lab3FX.api.model.Mitarbeiter.berufsPosition.Entwickler;
import static edu.lab3FX.api.model.Mitarbeiter.berufsPosition.ProjectManager;
import static org.junit.jupiter.api.Assertions.*;

class PersonFileRepositoryTest {

    private PersonFileRepository personFileRepository = new PersonFileRepository("D:\\LabMAP\\Lab3JFX\\src\\personsTest.txt");



    @Test
    void findOne() {

        assertEquals(new Mitarbeiter((long)1,"Peter","Johnson","Klausenburg", Entwickler,3,12.5,8),personFileRepository.findOne((long) 1));
    }


    @Test
    void findAll() {
        int size = 0;
        for (Mitarbeiter m:personFileRepository.findAll()
        ) {
            size++;
        }
        assertEquals(15,size);
    }

    @Test
    void save() {

        Mitarbeiter mitarbeiter6 = new Mitarbeiter((long)6, "Phillipe","Johannson","Mediasch",ProjectManager,4,16.4,4);
        personFileRepository.save(mitarbeiter6);
        int size = 0;
        for (Mitarbeiter m:personFileRepository.findAll()
        ) {
            size++;
        }
        assertEquals(6,size);
        personFileRepository.delete((long) 6);
    }


    @Test
    void delete() {
        int size = 0;
        for (Mitarbeiter m:personFileRepository.findAll()
        ) {
            size++;
        }
        personFileRepository.delete((long)1);
        assertEquals(14,size);

    }

    @Test
    void update() {
        personFileRepository.update(new Mitarbeiter((long)2, "Phillipe","Johannson","Mediasch",ProjectManager,4,16.4,4));
        assertEquals("Phillipe",personFileRepository.findOne((long)2).getVorName());
    }
}