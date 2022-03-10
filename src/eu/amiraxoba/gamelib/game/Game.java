package eu.amiraxoba.gamelib.game;

import java.util.Arrays;
import java.util.HashMap;

public class Game {
    private HashMap<String, Cell> map;

    public Game() {
        this.map = new HashMap<>();
    }


    public HashMap<String, Cell> getMap() {
        return map;
    }

    public void addCell(String pos, String content){
        Cell cell = new Cell(Integer.parseInt(pos.split("")[0]), Integer.parseInt(pos.split("")[1]), content, this);
        this.map.put(pos.split("")[0] + pos.split("")[1], cell);
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

