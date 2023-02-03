package org.example;

public enum Difficulty {
    EASY(16,16),
    MEDIUM(30,20),
    HARD(50,50),
    EXPERT(100, 50);

    private final int x;
    private final int y;

    Difficulty(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
