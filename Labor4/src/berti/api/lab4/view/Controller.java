package berti.api.lab4.view;

import berti.api.lab4.controller.GeistRunnable;
import berti.api.lab4.controller.Service;
import berti.api.lab4.model.Geist;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.stream.IntStream;

public class Controller {
    public AnchorPane anchorPane;
    public Button startButton;
    public ImageView welcomeImageView;
    public Slider geschwindigkeitSlider;
    public Label geschwindigkeitLabel;
    public ImageView geisterImageView;
    public Label anzahlGeisterLabel;
    public TextField geisterTextView;
    public Button playButton;
    public static String anzahlGeister;
    public static List<Timer> timerListe = new ArrayList<>();


    public void hideFirstScene(ActionEvent actionEvent) {
        startButton.setVisible(false);
        welcomeImageView.setVisible(false);
        geschwindigkeitSlider.setVisible(true);
        geschwindigkeitLabel.setVisible(true);
        anzahlGeisterLabel.setVisible(true);
        geisterImageView.setVisible(true);
        geisterTextView.setVisible(true);
        playButton.setVisible(true);

    }

    public void playButonPressed(ActionEvent actionEvent) {
        Stage secondStage = new Stage();
        Parent root1 = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pacmanGame.fxml"));
        try {
            root1 = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ControllerSpiel controllerSpiel = fxmlLoader.<ControllerSpiel>getController();
        controllerSpiel.bildeLabyrinth();

        anzahlGeister = geisterTextView.getText();


        IntStream.range(0, Integer.parseInt(anzahlGeister)).forEach(x -> {

            Geist geist = ControllerSpiel.machGeister();
            ControllerSpiel.zeigeGeist(geist);
            GeistRunnable geistRunnable = new GeistRunnable();
            geistRunnable.geist=geist;
            Timer timer = new Timer();
            timerListe.add(timer);
            timer.scheduleAtFixedRate(geistRunnable.timerTask,1000, (long) (geschwindigkeitSlider.getValue()*100));

        });
        Service.labyrinthBestimmen();

        secondStage.setTitle("PACMAN SPIEL");
        Scene scene = new Scene(root1, 682, 682);
        scene.setOnKeyPressed(controllerSpiel.keyListenerPacman);
        secondStage.setScene(scene);


        secondStage.show();
        anchorPane.setVisible(false);


    }
}
