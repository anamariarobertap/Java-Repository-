package edu.lab3.test;

import edu.lab3.api.controller.PersonController;
import edu.lab3.api.domain.Mitarbeiter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonControllerTest {

    private PersonController personController = new PersonController();

    @Test
    void berechneLohn() {

        Mitarbeiter mitarbeiter1 = new Mitarbeiter();
        mitarbeiter1.setAdresse("Strada nr. 1");
        mitarbeiter1.setID((long) 1);
        mitarbeiter1.setNachName("Bob");
        mitarbeiter1.setVorName("Bobby");
        mitarbeiter1.setStundenLohn(12.5);
        mitarbeiter1.setErfahrungsNiveau(3);
        mitarbeiter1.setStundenProTag(6);
        mitarbeiter1.setBerufPosition(Mitarbeiter.berufsPosition.Tester);

       double gehalt;
       gehalt = personController.berechneLohn(mitarbeiter1,(int)300);

       assertEquals(22500,gehalt);

    }

    @Test
    void gehaltBerufsPosition() {
    }

    @Test
    void gehaltAlleMitarbeitern() {
    }

    @Test
    void gehaltAusgewehlterNiveau() {
    }
}