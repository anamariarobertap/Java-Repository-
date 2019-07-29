package beans.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@ManagedBean
@SessionScoped
public class CreateMatrix {
    public CreateMatrix() {

    }

    private String getDateiName() {
        return "C:\\Users\\Anamaria\\Desktop\\Lab9_JSF\\src\\board";
    }

    public static int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }


    BufferedReader br;

    {
        try {
            br = new BufferedReader(new FileReader(this.getDateiName()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> linie = br.lines().collect(Collectors.toList());
        matrix = linie.stream().map(charachter -> charachter.chars()
                .filter(ch -> (char) ch != ' ')
                .map(Character::getNumericValue)
                .toArray())
                .toArray(int[][]::new);
    }


}

