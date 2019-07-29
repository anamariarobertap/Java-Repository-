package berti.api.lab4.model;


import berti.api.lab4.controller.GeistRunnable;

public class Pacman {


    public static void setGefangen(boolean gefangen) {
        GeistRunnable.machNeueSzene();
        Pacman.gefangen = gefangen;
    }

    public static boolean gefangen=false;
    /*
    startPosition = 0;
    */
    private Lage2D lage=new Lage2D(0,0);

    public Pacman(Lage2D lage) {
        this.lage = lage;
    }
    public Pacman(){}

    public Lage2D getLage() {
        return lage;
    }

    public void setLage(Lage2D lage) {
        this.lage = lage;
    }



}
