package ca.ood._01_gomoku;

public class Player {
    private String name;
//    private int score;
    private Cell piece;

    public Player() {}
    public Player(String name, Cell piece) {

    }

    public String getName() {
        return name;
    }
    public Cell getPieceColor() {
        return piece;
    }
    public void setPieceColor(Cell piece) {
        this.piece = piece;
    }
    public void setName(String name) {
        this.name = name;
    }
}


