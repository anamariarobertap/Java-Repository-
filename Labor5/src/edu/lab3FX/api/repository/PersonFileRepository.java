package edu.lab3FX.api.repository;

import edu.lab3FX.api.model.Mitarbeiter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonFileRepository implements CrudRepository<Mitarbeiter> {

    public void setDateiName(String dateiName) {
        this.dateiName = dateiName;
    }

    public String getDateiName() {
        return dateiName;
    }

    private String dateiName;

    private List<Mitarbeiter> inMemoryFileListe = new ArrayList<>();


    public PersonFileRepository(String dateiName) {
        this.dateiName = dateiName;
        readFromFile();
    }

    public PersonFileRepository() {
    }


    private void readFromFile() {
        inMemoryFileListe.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(this.dateiName))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                Mitarbeiter entity = machEntitet(linie);
                inMemoryFileListe.add(entity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Mitarbeiter machEntitet(String line) {
        String[] teile = line.split(",");
        return new Mitarbeiter(Long.parseLong(teile[0]), teile[1], teile[2], teile[3],
                Mitarbeiter.berufsPosition.valueOf(teile[4]),
                Integer.parseInt(teile[5]),
                Double.parseDouble(teile[6]),
                Integer.parseInt(teile[7]));
    }

    private void writeToFile(Mitarbeiter entity) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.dateiName, true))) {
            bw.write(entity.toString() + "\n");
            //bw.newLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void schriebAlles() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.dateiName))) {
            for (Mitarbeiter entity : inMemoryFileListe) {
                writeToFile(entity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mitarbeiter findOne(Long id) {
        for (Mitarbeiter mitarbeiter : inMemoryFileListe) {
            if (mitarbeiter.getID().equals(id))
                return mitarbeiter;
        }
        return null;
    }

    @Override
    public Iterable<Mitarbeiter> findAll() {
        readFromFile();
        return inMemoryFileListe;
    }

    @Override
    public Mitarbeiter save(Mitarbeiter entity) {
        boolean valid = true;
        for (Mitarbeiter mitarbeiter : inMemoryFileListe) {
            if (!mitarbeiter.getID().equals(entity.getID())) {
                valid = false;
                break;
            }
        }

        if (!valid)
            return null;
        else {
            inMemoryFileListe.add(entity);
            writeToFile(entity);
            return entity;
        }
    }


    @Override
    public Mitarbeiter delete(Long id) {
        Mitarbeiter deleteMitarbeiter = new Mitarbeiter();

        for (Mitarbeiter mitarbeiter : inMemoryFileListe) {
            if (mitarbeiter.getID().equals(id)) {
                inMemoryFileListe.remove(mitarbeiter);
                schriebAlles();
                deleteMitarbeiter = mitarbeiter;
                break;
            }
        }
        return deleteMitarbeiter;
    }

    @Override
    public Mitarbeiter update(Mitarbeiter entity) {
        boolean verify = false;

        for (Mitarbeiter mitarbeiter : inMemoryFileListe) {
            if (mitarbeiter.getID().equals(entity.getID())) {
                mitarbeiter.setErfahrungsNiveau(entity.getErfahrungsNiveau());
                mitarbeiter.setStundenLohn(entity.getStundenLohn());
                mitarbeiter.setStundenProTag(entity.getStundenProTag());
                mitarbeiter.setBerufPosition(entity.getBerufPosition());
                mitarbeiter.setVorName(entity.getVorName());
                mitarbeiter.setNachName(entity.getNachName());
                mitarbeiter.setAdresse(entity.getAdresse());
                verify = true;
                schriebAlles();
            }
        }
        if (!verify)
            return null;
        else {
            return entity;
        }
    }
}