package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    TextField nameTF;

    @FXML
    Label resultLabel;

    @FXML
    public void callThisMethod (Event e){
        resultLabel.setText("Hello"+nameTF.getText() + "!");
    }
}
