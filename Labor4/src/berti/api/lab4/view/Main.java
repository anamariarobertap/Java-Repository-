package berti.api.lab4.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;



public class Main extends Application {

    public Main() throws FileNotFoundException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pacman.fxml"));
        primaryStage.setTitle("PACMAN SPIEL");
        primaryStage.setScene(new Scene(root, 682, 682));
        primaryStage.show();


    }

}
