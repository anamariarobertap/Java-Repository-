package beans.controller;

import beans.model.CreateMatrix;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Random;

@ManagedBean
@SessionScoped
public class ManageMatrix extends CreateMatrix {

    private String out = "";

    public String getOut1() {
        return out1;
    }

    public void setOut1(String out1) {
        this.out1 = out1;
    }

    private String out1="";

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }


    private static void transpose() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = x;
            }
        }
    }
    public static void swapRows(){
        for (int  i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int x = matrix[i][j];
                matrix[i][j] = matrix[matrix.length -1 -i][j];
                matrix[matrix.length -1 -i][j] = x;
            }
        }
    }

    public void gameOver()
    {
        int size=0;
        for (int  i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
            if(!validPositionMatrix(i,j))
                size++;}
                if (size==16)
                    setOut1("Game over");
        }
    }
    public void moveLeft() {

        /*
        Stack overflow inspiration
         */
        int[][] copy = matrix.clone();
        for (int x = 0; x < copy.length; x++) {
            int[] row = new int[4];
            for (int y = 0; y < copy[x].length; y++) {
                if (copy[x][y] != 0) {
                    int temp = 0;
                    while (row[temp] != 0) {
                        temp++;
                    }
                    row[temp] = copy[x][y];
                }
            }
            for (int k = 0; k < row.length - 1; k++) {
                if (row[k] == row[k + 1]) {
                    row[k] = row[k] + row[k + 1];
                    row[k + 1] = 0;
                }
            }
            copy[x] = row;
        }
        for (int x = 0; x < copy.length; x++) {
            int[] row = new int[4];
            for (int y = 0; y < copy[x].length; y++) {
                if (copy[x][y] != 0) {
                    int temp = 0;
                    while (row[temp] != 0) {
                        temp++;
                    }
                    row[temp] = copy[x][y];
                }
            }
            copy[x] = row;
        }
        matrix = copy;
        win();
        gameOver();
        generateNewCast();
    }


    public void moveRight() {
        transpose();
        swapRows();
        transpose();
        swapRows();
       moveLeft();
        swapRows();
        transpose();
        swapRows();
        transpose();
        win();
        gameOver();
       generateNewCast();
    }
    public void moveUp() {
        transpose();
        swapRows();
        moveLeft();
        swapRows();
        transpose();
        win();
        gameOver();
      generateNewCast();
    }

    public void moveDown(){
        swapRows();
        transpose();
        moveLeft();
        transpose();
        swapRows();
        win();
        gameOver();
        generateNewCast();
    }

    public void win() {
        for (int x=0;x<matrix.length;x++){
            for (int y = 0; y < matrix.length; y++)
                if (matrix[x][y] == 2048){
                    setOut("Sie haben den Spiel gewohnnen!");
                break;
                }
        }
    }
    public int generateRandomFirstValue() {
        int[] list = new int[2];
        list[0] = 2;
        list[1] = 4;
        Random rand = new Random();
        return list[rand.nextInt(2)];
    }

    public boolean validPositionMatrix(int x, int y) {
        return matrix[x][y] == 0;
    }

    public void generatFirstBoard() {
        Random rand = new Random();
        int len = 0;
        matrix[rand.nextInt(3)][rand.nextInt(3)] = generateRandomFirstValue();
        matrix[rand.nextInt(3)][rand.nextInt(3)] = generateRandomFirstValue();
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++)
                if (matrix[x][y] != 0)
                    len++;
        }
        if (len == 1) {
            matrix[rand.nextInt(3)][rand.nextInt(3)] = generateRandomFirstValue();
        } else if (len == 0) {
            matrix[rand.nextInt(3)][rand.nextInt(3)] = generateRandomFirstValue();
            matrix[rand.nextInt(3)][rand.nextInt(3)] = generateRandomFirstValue();
        }
    }

    public void generateNewCast() {
        Random rand = new Random();
        int x = rand.nextInt(3);
        int y = rand.nextInt(3);
       if (validPositionMatrix(x, y))
        matrix[x][y] = generateRandomFirstValue();
        else
       {
           do{
                x = rand.nextInt(3);
               y = rand.nextInt(3);
           } while (!validPositionMatrix(x,y));
           matrix[x][y] = generateRandomFirstValue();
       }

    }
}

