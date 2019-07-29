package edu.lab3FX.api.model;

import java.util.Objects;

public class Person {
    private Long ID;
    private String vorName;
    private String nachName;
    private String adresse;

    public Person(Long ID, String vorName, String nachName, String adresse) {
        this.ID = ID;
        this.vorName = vorName;
        this.nachName = nachName;
        this.adresse = adresse;
    }

    public Person() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(ID, person.ID) &&
                Objects.equals(vorName, person.vorName) &&
                Objects.equals(nachName, person.nachName) &&
                Objects.equals(adresse, person.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, vorName, nachName, adresse);
    }

    @Override
    public String toString() {
        return ID +
                "," + vorName +
                "," + nachName +
                ","+ adresse
                ;
    }
}
