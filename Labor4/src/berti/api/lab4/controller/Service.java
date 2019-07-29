package berti.api.lab4.controller;

import berti.api.lab4.model.Lage2D;
import berti.api.lab4.view.ControllerSpiel;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * CRUD Operationen + aus dem Datei lesen
 */

public class Service {


    public Service(int[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public Service() {
    }

    private String getDateiName() {
        return "D:\\LabMAP\\Labor4\\src\\berti\\api\\lab4\\controller\\labyrinth.txt";
    }


    public static int[][] labyrinth = new int[10][10];



    public void liesVonDatei() {
        /*
        ich lese eine Matrix vom Datei und bilde damit ein Labyrinth
        # 0 = freieLage
        # 1 = wand
         */

        try (BufferedReader br = new BufferedReader(new FileReader(this.getDateiName()))) {
            List<String> linie = br.lines().collect(Collectors.toList());
            labyrinth = linie.stream().map(charachter -> charachter.chars()
                    .filter(ch -> (char) ch != ' ')
                    .map(Character::getNumericValue)
                    .toArray())
                    .toArray(int[][]::new);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ControllerSpiel.findeLeereLagen();
    }

    public static void labyrinthBestimmen() {
        IntStream.range(0, 10).forEach(x -> {
            IntStream.range(0, 10).forEach(y -> {
                if (labyrinth[x][y] == 1)
                    ControllerSpiel.labyrinthRectangle[x][y].setFill(new ImagePattern(new Image(new File("D:\\LabMAP\\Labor4\\src\\sample\\wall.jpg").toURI().toString())));
                else if (labyrinth[x][y] == 2)
                    ControllerSpiel.zeigePacman(x, y);
                });
            });
    }

    public static boolean freieLage(Lage2D lage2D) {
        /*
        bestimme ob ich keinen Wand ( 1 ) oder kein Geist ( 3 ) habe

        freieLage ist für den Pacman benutzt
         */
        return labyrinth[lage2D.getX()][lage2D.getY()] != 1 && labyrinth[lage2D.getX()][lage2D.getY()] != 3;
    }

    public static boolean freieLageGeist(Lage2D lage2D) {
        /*
        bestimme ob ich keinen Wand ( 1 ) oder kein Geist ( 3 ) habe

        freieLage ist für den Pacman benutzt
         */
        if (labyrinth[lage2D.getX()][lage2D.getY()] == 0 || labyrinth[lage2D.getX()][lage2D.getY()] == 3)
            return true;
        else
            return false;
    }



}