package berti.api.lab4.controller;

import berti.api.lab4.model.Geist;
import berti.api.lab4.model.Lage2D;
import berti.api.lab4.view.Controller;
import berti.api.lab4.view.ControllerSpiel;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static berti.api.lab4.view.ControllerSpiel.labyrinthRectangle;

public class GeistRunnable {


    public Geist geist = new Geist();



    public int wähleGeistLage() {
        Random rand = new Random();
        int nachsteLageWahl = rand.nextInt(4);


        if (nachsteLageWahl == 0) {
            if (Service.freieLageGeist(new Lage2D(geist.getLage2D().getX() - 1, geist.getLage2D().getY()))) {
                labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(Color.web("#7d7be0"));
                geist.getLage2D().setX(geist.getLage2D().getX() - 1);
                labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(new ImagePattern(new Image(new File("D:\\LabMAP\\Labor4\\src\\sample\\fantomitaBefore.jpg").toURI().toString())));

                if (ControllerSpiel.kollesion(geist))
                    return -1;


            }
        } else if (nachsteLageWahl == 1) {

            if (Service.freieLageGeist(new Lage2D(geist.getLage2D().getX() + 1, geist.getLage2D().getY()))) {
                labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(Color.web("#7d7be0"));
                geist.getLage2D().setX(geist.getLage2D().getX() + 1);
                labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(new ImagePattern(new Image(new File("D:\\LabMAP\\Labor4\\src\\sample\\fantomitaBefore.jpg").toURI().toString())));

                if (ControllerSpiel.kollesion(geist))
                    return -1;
            }
        } else if (nachsteLageWahl == 2) {
            if (Service.freieLageGeist(new Lage2D(geist.getLage2D().getX(), geist.getLage2D().getY() - 1))) {
                labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(Color.web("#7d7be0"));
                geist.getLage2D().setY(geist.getLage2D().getY() - 1);
                labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(new ImagePattern(new Image(new File("D:\\LabMAP\\Labor4\\src\\sample\\fantomitaBefore.jpg").toURI().toString())));

                if (ControllerSpiel.kollesion(geist))
                    return -1;
            }
        } else {
            if (Service.freieLageGeist(new Lage2D(geist.getLage2D().getX(), geist.getLage2D().getY() + 1))) {
                labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(Color.web("#7d7be0"));
                geist.getLage2D().setY(geist.getLage2D().getY() + 1);
                labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(new ImagePattern(new Image(new File("D:\\LabMAP\\Labor4\\src\\sample\\fantomitaBefore.jpg").toURI().toString())));

                if (ControllerSpiel.kollesion(geist))
                    return -1;
            }
        }

        return 1;

    }


    public static void machNeueSzene()
    {
        Stage thirdStage = new Stage();
        Parent root2 = null;
        FXMLLoader fxmlLoader = new FXMLLoader(GeistRunnable.class.getResource("endeSpiel.fxml"));
        try {
            root2 = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }
        thirdStage.setTitle("PACMAN ENDE");
        thirdStage.setScene(new Scene(root2, 682, 682));
        thirdStage.show();
    }

    public TimerTask timerTask=new TimerTask() {

        @Override
        public void run() {
            if(wähleGeistLage()==-1) {
                Controller.timerListe.forEach(Timer::cancel);
                Controller.timerListe.forEach(Timer::purge);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        machNeueSzene();
                    }
                });

            }

        }
    };


}
