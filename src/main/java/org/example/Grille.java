package org.example;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;



@Getter
@Setter
public class Grille {

    private int[][] tab = Test.firstGrid;
    private Map<Integer, Cell> grid = new TreeMap<>();

    private int WIDTH;
    private int HEIGHT;

    public void init(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        for (int x = 0; x < WIDTH + 2; x++) {
            for (int y = 0; y < HEIGHT + 2; y++) {
                int key = x * (WIDTH + 2) + y;
                grid.put(key, new Cell(tab[x][y]));
                if((x == 0 || x == WIDTH + 2) || (y == 0 || y == WIDTH + 2)) {
                    grid.get(key).setState(CellState.VISIBLE);
                }
            }
        }
    }

    public boolean checkWin() {
        boolean result = true;
        for (Cell c : grid.values()) {
            if ((c.getContains() != 9 && c.getState() == CellState.HIDDEN) || (c.getContains() == 9 && (c.getState() == CellState.VISIBLE))) {
                result = false;
                break;
            }
        }

        return result;
    }


    
    



    public Map<Integer, Cell> getGrille() {
        return Map.copyOf(grid);
    }

}
