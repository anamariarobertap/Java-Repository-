package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    Stage secondStage = new Stage();
    Stage thirdStage = new Stage();
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
            //PersonInMemoryRepository personCrudRepository = new PersonInMemoryRepository();
            thirdStage.hide();


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
            //personCrudRepository = new PersonFileRepository();
            secondStage.hide();


        }

    }
}