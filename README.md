# Java Game Libary
#### by AureumApes

## First SetUp
1. Create a Game variable: `Game game = new Game();`
2. Add every Cell you want in the game to it: `game.addCell(<coord>, <value>)`

## Handle Input
To Get User Input use `Listener.getInput(<message>);`. It will return a char which is the first given by the User

## Full Example Game:
```java
package eu.amiraxoba.gamelib.example;

import eu.amiraxoba.gamelib.game.Cell;
import eu.amiraxoba.gamelib.game.Game;
import eu.amiraxoba.gamelib.game.Listener;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String playerPos = "11";
        for(int iy = 0; iy <= 7; iy++){
            for(int ix = 0; ix <= 7; ix++){
                game.addCell("" + ix + iy, "⬛");
            }
        }
        game.addCell(playerPos, "\uD83D\uDD34");

        while (true) {
            game.render();
            char input = Listener.getInput("Input > ");
            Cell newCell;
            String oldPos;
            switch (input) {
                case 'd':
                    oldPos = playerPos;
                    newCell = game.getMap().get(playerPos).getRightCell();
                    if (newCell == null) break;
                    playerPos = "" + newCell.getX() + newCell.getY();
                    game.addCell(playerPos, "\uD83D\uDD34");
                    game.addCell(oldPos, "⬛");
                    break;
                case 'a':
                    oldPos = playerPos;
                    newCell = game.getMap().get(playerPos).getLeftCell();
                    if (newCell == null) break;
                    playerPos = "" + newCell.getX() + newCell.getY();
                    game.addCell(playerPos, "\uD83D\uDD34");
                    game.addCell(oldPos, "⬛");
                    break;
                case 's':
                    oldPos = playerPos;
                    newCell = game.getMap().get(playerPos).getLowerCell();
                    if (newCell == null) break;
                    playerPos = "" + newCell.getX() + newCell.getY();
                    game.addCell(playerPos, "\uD83D\uDD34");
                    game.addCell(oldPos, "⬛");
                    break;
                case 'w':
                    oldPos = playerPos;
                    newCell = game.getMap().get(playerPos).getUpperCell();
                    if (newCell == null) break;
                    playerPos = "" + newCell.getX() + newCell.getY();
                    game.addCell(playerPos, "\uD83D\uDD34");
                    game.addCell(oldPos, "⬛");
                    break;
            }
            System.out.print("\033[H\033[2J");
        }
    }
}

```