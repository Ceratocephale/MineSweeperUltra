package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {

    private CellState state;
    private int contains;

    public Cell(int contains){
        this.state = CellState.HIDDEN;
        this.contains = contains;
    }
}
