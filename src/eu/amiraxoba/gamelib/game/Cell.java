package eu.amiraxoba.gamelib.game;

public class Cell {
    private int x;
    private int y;
    private String content;
    private Game game;

    public Cell(int x, int y, String content, Game game) {
        this.x = x;
        this.y = y;
        this.content = content;
        this.game = game;
    }

    // Getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getContent() {
        return content;
    }

    public Cell getLeftCell() {
            return this.game.getMap().get("" + (this.x - 1) + this.y);
    }

    public Cell getRightCell() {
        return this.game.getMap().get("" + (this.x + 1) + this.y);
    }

    public Cell getUpperCell() {
        return this.game.getMap().get("" + this.x + (this.y - 1));
    }

    public Cell getLowerCell() {
        return this.game.getMap().get("" + this.x + (this.y + 1));
    }
}
