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
        for (int x = 1; x < WIDTH + 1; x++) {
            for (int y = 1; y < HEIGHT + 1; y++) {
                grid.put(x * WIDTH + y, new Cell(tab[x][y]));
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

    public boolean click(int key) {
        if (grid.get(key).getContains() == 0)
            flood(key);
        return grid.get(key).getContains() == 9;
    }
    
    

    public void flood(int key){
        int x = key % WIDTH;
        int y = key / HEIGHT;
        if( y != 0 && x != 0 && y != HEIGHT + 1 && x != WIDTH + 1) {
        int tab[] = {(HEIGHT * (y-1) + x-1), (HEIGHT * (y-1) + x), (HEIGHT * (y-1) + x+1), (HEIGHT * (y) + x-1), (HEIGHT * (y-1) + x+1), (HEIGHT * (y+1) + x-1), (HEIGHT * (y+1) + x), (HEIGHT * (y+1) + x+1)};
        for(int i : tab) {
//                if( && grid.get(i).getState() == CellState.HIDDEN) {
//                    grid.get(i).setState(CellState.VISIBLE);
//                    flood(i);
//                }
                if(grid.get(i).getContains() != 0 && grid.get(i).getState() == CellState.HIDDEN)
                    grid.get(i).setState(CellState.VISIBLE);
                else flood(i);

            }
        }


    }

    public Map<Integer, Cell> getGrille() {
        return Map.copyOf(grid);
    }

}
