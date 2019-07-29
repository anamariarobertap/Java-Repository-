package edu.lab3FX.api.model;
import java.util.Objects;

public class Mitarbeiter extends Person {


    public Mitarbeiter(Long ID, String vorName, String nachName, String adresse, berufsPosition berufPosition, Integer erfahrungsNiveau, Double stundenLohn, Integer stundenProTag) {
        super(ID, vorName, nachName, adresse);
        this.berufPosition = berufPosition;
        this.erfahrungsNiveau = erfahrungsNiveau;
        this.stundenLohn = stundenLohn;
        this.stundenProTag = stundenProTag;

    }

    public Mitarbeiter(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mitarbeiter)) return false;
        if (!super.equals(o)) return false;
        Mitarbeiter that = (Mitarbeiter) o;
        return erfahrungsNiveau == that.erfahrungsNiveau &&
                Double.compare(that.stundenLohn, stundenLohn) == 0 &&
                stundenProTag == that.stundenProTag &&
                berufPosition == that.berufPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), erfahrungsNiveau, stundenLohn, stundenProTag, berufPosition);
    }

    @Override
    public String toString() {
        return
                super.toString() + ","+ berufPosition +"," +
                        erfahrungsNiveau +
                        ","+ stundenLohn +
                        "," + stundenProTag ;
    }


    public enum berufsPosition {
        Entwickler, Tester, ProjectManager, TeamLeader
    }
    private int erfahrungsNiveau;
    private double stundenLohn;
    private int stundenProTag;
    private berufsPosition berufPosition;


    public berufsPosition getBerufPosition() {
        return berufPosition;
    }

    public void setBerufPosition(berufsPosition berufPosition) {
        this.berufPosition = berufPosition;
    }

    public int getErfahrungsNiveau() {
        return erfahrungsNiveau;
    }

    public void setErfahrungsNiveau(int erfahrungsNiveau) {
        this.erfahrungsNiveau = erfahrungsNiveau;
    }

    public double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public int getStundenProTag() {
        return stundenProTag;
    }

    public void setStundenProTag(int stundenProTag) {
        this.stundenProTag = stundenProTag;
    }
}
