package eu.amiraxoba.gamelib.game;

import java.util.Arrays;
import java.util.HashMap;

public class Game {
    private HashMap<String, Cell> map;
    private int height;

    public Game() {
        this.map = new HashMap<>();
        height = 0;
    }

    public HashMap<String, Cell> getMap() {
        return map;
    }

    public void addCell(String pos, String content){
        Cell cell = new Cell(Integer.parseInt(pos.split("")[0]), Integer.parseInt(pos.split("")[1]), content, this);
        this.map.put(pos.split("")[0] + pos.split("")[1], cell);
        height++;
    }

    public void addRow(String row) {
        int x = 1;
        for(char cell : row.toCharArray()) {
            Cell cell1 = new Cell(x, (height +1), Character.toString(cell), this);
            this.map.put(Integer.toString(x) + (height + 1), cell1);
            x++;
        }
        height++;
    }

    public void render(){
        int y = 1;
        int x = 1;
        for(int i = 0; i <= this.getMap().keySet().size(); i++){
            Cell currCell = this.getMap().get("" + x + y);
            if(currCell == null){
                y++;
                x = 1;
                System.out.print("\n");
                currCell = this.getMap().get("" + x + y);
                if(currCell == null) return;
                System.out.print(currCell.getContent());
                x++;
            }else {
                currCell = this.getMap().get("" + x + y);
                System.out.print(currCell.getContent());
                x++;
            }
        }
    }
}

