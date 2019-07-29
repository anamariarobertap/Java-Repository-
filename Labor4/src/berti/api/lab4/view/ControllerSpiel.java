package berti.api.lab4.view;


import berti.api.lab4.controller.Service;
import berti.api.lab4.model.Geist;
import berti.api.lab4.model.Lage2D;
import berti.api.lab4.model.Pacman;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ControllerSpiel {
    private static final File PACMAN_IMAGE = new File("D:\\LabMAP\\Labor4\\pacman1.gif");
    private static final File GEIST_IMAGE = new File("D:\\LabMAP\\Labor4\\src\\sample\\fantomitaBefore.jpg");
    public Group groupLabyrinth;
    public static AnchorPane anchorPaneSpiel;
    public Label scoreLabel;
    public Label scoreErgebnisLabel;
    private Service service = new Service();
    private static Pacman pacman = new Pacman();

    private static int scoreNumber =0;

    public static List<Geist> geister = new ArrayList<>();


    public Rectangle[][] getLabyrinthRectangle() {
        return labyrinthRectangle;
    }

    public static List<Lage2D> listLeereLagen = new ArrayList<>();

    public static Rectangle[][] labyrinthRectangle = new Rectangle[10][10];


    public EventHandler<KeyEvent> keyListenerPacman = new EventHandler<KeyEvent>() {
        @Override

        /*
        verwende EventHandler so dass

        der Benutzer den PACMAN beherrscht
         */
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.UP) {
                if (service.freieLage(new Lage2D(pacman.getLage().getX() - 1, pacman.getLage().getY()))) {
                    labyrinthRectangle[pacman.getLage().getX()][pacman.getLage().getY()].setFill(Color.web("#7d7be0"));
                    pacman.getLage().setX(pacman.getLage().getX() - 1);
                    labyrinthRectangle[pacman.getLage().getX()][pacman.getLage().getY()].setFill(new ImagePattern(new Image(PACMAN_IMAGE.toURI().toString())));
                    scoreNumber++;
                    scoreErgebnisLabel.setText(String.valueOf(scoreNumber));
                }
            } else if (event.getCode() == KeyCode.DOWN) {
                if (service.freieLage(new Lage2D(pacman.getLage().getX() + 1, pacman.getLage().getY()))) {
                    labyrinthRectangle[pacman.getLage().getX()][pacman.getLage().getY()].setFill(Color.web("#7d7be0"));
                    pacman.getLage().setX(pacman.getLage().getX() + 1);
                    labyrinthRectangle[pacman.getLage().getX()][pacman.getLage().getY()].setFill(new ImagePattern(new Image(PACMAN_IMAGE.toURI().toString())));
                    scoreNumber++;
                    scoreErgebnisLabel.setText(String.valueOf(scoreNumber));
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                if (service.freieLage(new Lage2D(pacman.getLage().getX(), pacman.getLage().getY() - 1))) {
                    labyrinthRectangle[pacman.getLage().getX()][pacman.getLage().getY()].setFill(Color.web("#7d7be0"));
                    pacman.getLage().setY(pacman.getLage().getY() - 1);
                    labyrinthRectangle[pacman.getLage().getX()][pacman.getLage().getY()].setFill(new ImagePattern(new Image(PACMAN_IMAGE.toURI().toString())));
                    scoreNumber++;
                    scoreErgebnisLabel.setText(String.valueOf(scoreNumber));
                }
            } else if (event.getCode() == KeyCode.RIGHT) {
                if (service.freieLage(new Lage2D(pacman.getLage().getX(), pacman.getLage().getY() + 1))) {
                    labyrinthRectangle[pacman.getLage().getX()][pacman.getLage().getY()].setFill(Color.web("#7d7be0"));
                    pacman.getLage().setY(pacman.getLage().getY() + 1);
                    labyrinthRectangle[pacman.getLage().getX()][pacman.getLage().getY()].setFill(new ImagePattern(new Image(PACMAN_IMAGE.toURI().toString())));
                    scoreNumber++;
                    scoreErgebnisLabel.setText(String.valueOf(scoreNumber));
                }
            }

            event.consume();
        }

    };


    public void bildeLabyrinth() {

        /*
        Labyrinth wird bestimmt

        labyrinthRectangle
         */

        service.liesVonDatei();
        IntStream.range(0, 10).forEach(x -> {
            IntStream.range(0, 10).forEach(y -> {
                Rectangle rectangle = new Rectangle(45, 45);
                rectangle.setX(45 * y);
                rectangle.setY(45 * x);
                rectangle.setStroke(Color.web("#f7ec27"));
                rectangle.setFill(Color.web("#7d7be0"));
                groupLabyrinth.getChildren().add(rectangle);
                labyrinthRectangle[x][y] = rectangle;
            });
        });

    }

    public static void zeigePacman(int x, int y) {
        pacman.setLage(new Lage2D(x, y));
        labyrinthRectangle[x][y].setFill(new ImagePattern(new Image(PACMAN_IMAGE.toURI().toString())));
    }

    public static void zeigeGeist(Geist geist) {
        labyrinthRectangle[geist.getLage2D().getX()][geist.getLage2D().getY()].setFill(new ImagePattern(new Image(GEIST_IMAGE.toURI().toString())));
    }

    public static boolean kollesion(Geist geist) {
        /*
        stop Bedingung für meinen Spiel
         */
        return pacman.getLage().getX() == geist.getLage2D().getX() && pacman.getLage().getY() == geist.getLage2D().getY() ;
    }

    public static List<Lage2D> findeLeereLagen() {

        /*
        eine Liste von Nullen
         */
        IntStream.range(0, 10).forEach(x -> {
            IntStream.range(0, 10).forEach(y -> {
                if (Service.labyrinth[x][y] == 0)
                    listLeereLagen.add(new Lage2D(x, y));
            });
        });
        return listLeereLagen;
    }

    public static Lage2D gebeGeistLage()
    {
        /*
        wähle die günstige Lage
         */
        Random rand = new Random();
        return listLeereLagen.remove(rand.nextInt(listLeereLagen.size()));
    }


        public static Geist machGeister () {
            Geist geist = new Geist();
            geist.setLage2D(gebeGeistLage());
            return geist;

        }
    }

