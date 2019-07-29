package sample;


import edu.lab3FX.api.controller.PersonController;
import edu.lab3FX.api.model.Mitarbeiter;
import edu.lab3FX.api.repository.PersonFileRepository;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.text.DefaultCaret;
import java.util.ArrayList;
import java.util.List;

public class ControllerInFile extends PersonController {


    @FXML
    public TextField idSave;
    public TextField nachNameSave;
    public TextField vorNameSave;
    public TextField adresseSave;
    public TextField stundenProTagSave;
    public TextField stundenLohnSave;
    public ComboBox enumComboBox;
    public Slider erfahrungsNiveau;
    public Button berufsNiveau;
    public ComboBox enumComboBox2;
    @FXML
    Label listViewGehalt;
    @FXML
    ListView<Mitarbeiter> listView = new ListView<>() ;
    @FXML
    ComboBox<Long> comboBox = new ComboBox<>();
    @FXML
    Label labelFindById;
    @FXML
    ListView<Mitarbeiter> listViewShow2 =new ListView<>();
    @FXML
    ComboBox<Long> comboBox2 = new ComboBox<>();
    @FXML
    Button zeigeListe2;
    @FXML
    Button ersetzeButton;
    @FXML
    Button updateButton;
    @FXML
    ComboBox gehaltComboBox;


    private ListProperty<String> listProperty=new SimpleListProperty<>();
    private ListProperty<String> listProperty2 =new SimpleListProperty<>();



    public ControllerInFile() {
        listView.setVisible(false);
        wahlRepository(false);
        ((PersonFileRepository)getPersonCrudRepository()).setDateiName("D:\\LabMAP\\Lab3JFX\\src\\persons.txt");

    }

    public void showAll(MouseEvent mouseEvent) {
        listView.setVisible(true);
        ArrayList<String> newListeString = new ArrayList<>();


        for (Mitarbeiter m : findAll())
        {String mitarbeiterToString =m.getID().toString()+" "+
           m.getNachName()+" "+
            m.getVorName()+" "+
            m.getAdresse()+String.valueOf( m.getErfahrungsNiveau())+" "+ String.valueOf(m.getStundenLohn())+" "+
            String.valueOf(m.getStundenProTag());
            newListeString.add(mitarbeiterToString);
        }

        listView.getItems().clear();
        listProperty.set(FXCollections.observableList(newListeString));
        listView.getItems().addAll(FXCollections.observableArrayList(findAll()));

    }
    public void showById( Event event)
    {
        comboBox.getItems().clear();
        comboBox.setVisible(true);
        for (Mitarbeiter m : findAll())
        {
            comboBox.getItems().add(m.getID());
        }


    }
    public void comboBoxClicked (Event e){
        Mitarbeiter m= findMitarbeiterbyID(comboBox.getValue());
        labelFindById.setText(m.toString());
        labelFindById.setVisible(true);
        findAll().clear();
    }

    public void showAll2(Event event) {
        listViewShow2.getItems().clear();
        ArrayList<String> newListeString2 = new ArrayList<>();
        List<Mitarbeiter> newListFind2 = findAll();


        for (Mitarbeiter m : newListFind2)
        {String mitarbeiterToString = m.toString();
            newListeString2.add(mitarbeiterToString);
        }
        listViewShow2.getItems().clear();
        listProperty2.set(FXCollections.observableList(newListeString2));
        listViewShow2.getItems().addAll(FXCollections.observableArrayList(newListFind2));
    }

    public void showById2(Event event) {
        List<Mitarbeiter> newListFind2 = findAll();
        for (Mitarbeiter m : newListFind2)
        {
            comboBox2.getItems().add(m.getID());

        }
    }

    public void deleteButtonClicked(MouseEvent mouseEvent) {
        showById2(mouseEvent);
        listViewShow2.setVisible(true);
        comboBox2.setVisible(true);
        zeigeListe2.setVisible(true);
        listViewShow2.getItems().clear();

    }

    public void comboBoxClicked2(ActionEvent actionEvent) {
        deleteMitarbeiter(comboBox2.getValue());
    }


    public void hideAll(MouseEvent mouseEvent) {
        comboBox.setVisible(false);
        labelFindById.setVisible(false);
        listView.setVisible(false);
        listViewShow2.setVisible(false);
        comboBox2.setVisible(false);
        zeigeListe2.setVisible(false);
        ersetzeButton.setVisible(false);
        updateButton.setVisible(false);
        enumComboBox.setVisible(false);
        erfahrungsNiveau.setVisible(false);
        listViewGehalt.setText("");
        enumComboBox2.setVisible(false);

        idSave.setVisible(false);
        nachNameSave.setVisible(false);
        vorNameSave.setVisible(false);
        erfahrungsNiveau.setVisible(false);
        stundenLohnSave.setVisible(false);
        adresseSave.setVisible(false);
        stundenProTagSave.setVisible(false);
        enumComboBox.setVisible(false);
        ersetzeButton.setVisible(false);
        updateButton.setVisible(false);
    }

    public void displaySaveAttributes(MouseEvent mouseEvent) {
        idSave.setVisible(true);
        nachNameSave.setVisible(true);
        vorNameSave.setVisible(true);
        erfahrungsNiveau.setVisible(true);
        stundenLohnSave.setVisible(true);
        adresseSave.setVisible(true);
        stundenProTagSave.setVisible(true);
        enumComboBox.setVisible(true);
        ersetzeButton.setVisible(true);
        updateButton.setVisible(true);


    }

    public void showUpdatedAddFile(MouseEvent mouseEvent) {
        listViewShow2.setVisible(true);
        zeigeListe2.setVisible(true);
        idSave.setVisible(false);
        nachNameSave.setVisible(false);
        vorNameSave.setVisible(false);
        erfahrungsNiveau.setVisible(false);
        stundenLohnSave.setVisible(false);
        adresseSave.setVisible(false);
        stundenProTagSave.setVisible(false);
        enumComboBox.setVisible(false);
        Mitarbeiter neueMitarbeiter =new Mitarbeiter(Long.parseLong(idSave.getText()),nachNameSave.getText(),vorNameSave.getText(),adresseSave.getText(),
                Mitarbeiter.berufsPosition.valueOf(enumComboBox.getValue().toString()),(int)erfahrungsNiveau.getValue(),Double.parseDouble(stundenLohnSave.getText()),
                Integer.parseInt(stundenProTagSave.getText()));
        saveMitarbeiter(neueMitarbeiter);

    }


    public void onUpdateClicked(MouseEvent mouseEvent) {
        listViewShow2.setVisible(true);
        zeigeListe2.setVisible(true);
        idSave.setVisible(false);
        nachNameSave.setVisible(false);
        vorNameSave.setVisible(false);
        erfahrungsNiveau.setVisible(false);
        stundenLohnSave.setVisible(false);
        adresseSave.setVisible(false);
        stundenProTagSave.setVisible(false);
        enumComboBox.setVisible(false);
        updateButton.setVisible(false);


        Mitarbeiter neueMitarbeiter =new Mitarbeiter(Long.parseLong(idSave.getText()),nachNameSave.getText(),vorNameSave.getText(),adresseSave.getText(),
                Mitarbeiter.berufsPosition.valueOf(enumComboBox.getValue().toString()),(int)erfahrungsNiveau.getValue(),Double.parseDouble(stundenLohnSave.getText()),
                Integer.parseInt(stundenProTagSave.getText()));
        updateMitarbeiter(neueMitarbeiter);
    }

    public void showEnum(ActionEvent actionEvent) {
        if (gehaltComboBox.getValue().equals("Gehalt nach berufsPosition")) {
            enumComboBox2.setVisible(true);


        } else if (gehaltComboBox.getValue().equals("Gehalt aller Mitarbeiter")) {
            enumComboBox2.setVisible(false);
            erfahrungsNiveau.setVisible(false);
            listViewGehalt.setText(gehaltAlleMitarbeitern());
            listViewGehalt.setWrapText(true);

        } else if (gehaltComboBox.getValue().equals("Gehalt nach erfahrungsNiveau")) {
            erfahrungsNiveau.setVisible(true);
            berufsNiveau.setVisible(true);
        }
    }

    public void rechneGehalt(Event e) {
        if (gehaltComboBox.getValue().equals("Gehalt nach berufsPosition")) {

            listViewGehalt.setText(gehaltBerufsPosition(Mitarbeiter.berufsPosition.valueOf(enumComboBox2.getValue().toString())));


        } else if (gehaltComboBox.getValue().equals("Gehalt aller Mitarbeiter")) {

            listViewGehalt.setWrapText(true);
            listViewGehalt.setText(gehaltAlleMitarbeitern());


        } else if (gehaltComboBox.getValue().equals("Gehalt nach erfahrungsNiveau")) {

            listViewGehalt.setText(gehaltAusgewehlterNiveau((int) erfahrungsNiveau.getValue()));

        }
    }

    public void waehleBerufsNiveau(MouseEvent mouseEvent) {
        listViewGehalt.setText(gehaltAusgewehlterNiveau((int) erfahrungsNiveau.getValue()));
        berufsNiveau.setVisible(false);
        erfahrungsNiveau.setVisible(false);
    }
}
