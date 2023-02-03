package org.example;

public class MineSweeper {
    private final int WIDTH;
    private final int HEIGHT;
    private final Grille grid;
    
    public MineSweeper(Difficulty difficulty){
        this.WIDTH = difficulty.getX();
        this.HEIGHT = difficulty.getY();
        grid= new Grille();
    }

    public void gridInit(){
        grid.init(WIDTH, HEIGHT);
    }

    public void display() {
        //...
    }

}
