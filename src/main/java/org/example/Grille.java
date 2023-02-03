package org.example;


import java.util.Map;
import java.util.TreeMap;

public class Grille {

    private int[][] tab = Test.firstGrid;
    private Map<Integer, Cell> grid = new TreeMap<>();

    public void init(int WIDTH, int HEIGHT) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
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
        Cell cell = grid.get(key);
        if (cell.getContains() == 0)
            revealArea(cell);
        return cell.getContains() == 9;


    }

    public void revealArea(Cell cell) {



        cell.setState(CellState.VISIBLE);
    }

    public Map<Integer, Cell> getGrille() {
        return Map.copyOf(grid);
    }

}
