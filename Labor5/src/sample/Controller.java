package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    Stage secondStage = new Stage();
    Stage thirdStage = new Stage();
    Stage fourthStage = new Stage();
    @FXML
    public RadioButton InDatabaseButton;
    public ToggleGroup FirstButtonGroup;

    @FXML
    public RadioButton InMemoryButton;

    @FXML
    public RadioButton InFileButton;

    public void wahlRepository(Event e) {
        if (InMemoryButton.isSelected()) {

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("controllerInMemory.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            secondStage.setTitle("Willkommen im InMemoryRepository");
            secondStage.setScene(new Scene(root, 600, 600));
            secondStage.show();
            InFileButton.setSelected(false);
            InDatabaseButton.setSelected(false);
            //PersonInMemoryRepository personCrudRepository = new PersonInMemoryRepository();
            thirdStage.hide();
            fourthStage.hide();


        }
         else if (InFileButton.isSelected()) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("controllerInFile.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            thirdStage.setTitle("Willkommen im InFileRepository");
            thirdStage.setScene(new Scene(root, 600, 600));
            thirdStage.show();
            InMemoryButton.setSelected(false);
            InDatabaseButton.setSelected(false);

             //personCrudRepository = new PersonFileRepository();
            secondStage.hide();
            fourthStage.hide();

        }
        else if (InDatabaseButton.isSelected()) {
            Parent root1 = null;
            try {
                root1=FXMLLoader.load(getClass().getResource("controllerInDatabase.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            fourthStage.setTitle("Willkommen im InDatabaseRepository");
            fourthStage.setScene(new Scene(root1, 600, 600));
            fourthStage.show();
            InMemoryButton.setSelected(false);
            InFileButton.setSelected(false);
            secondStage.hide();
            thirdStage.hide();

        }


    }
}