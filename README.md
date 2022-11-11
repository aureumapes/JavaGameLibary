# Java Game Libary
#### by AureumApes

## First SetUp
1. Create a Game variable: `Game game = new Game();`
2. Add every Cell you want in the game to it: `game.addCell(<coord>, <value>)`
    * You can also use `game.addRow(<entire row)` to add an entire row

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
        Game game = new Game(); // Creates a new Instance of the Class Game
        String playerPos = "11"; // Creates the Player Positon, so we can use it later for movement
        // Build the Map Row by Row (Can't be bigger than 9*9)
        game.addRow("⬛⬛⬛⬛⬛");
        game.addRow("⬛⬛⬛⬛⬛");
        game.addRow("⬛⬛⬛⬛⬛");
        game.addRow("⬛⬛⬛⬛⬛");
        game.addRow("⬛⬛⬛⬛⬛");
        game.addCell(playerPos, "\uD83D\uDD34"); // Create the player-cell
        
        // This Code will run until the game is closed
        while (true) {
            game.render(); // Render the map
            char input = Listener.getInput("Input > "); // ASks the Player for the action they wan't to do
            Cell newCell; // Create the Variable for later
            String oldPos; // Create the Variable for later
            switch (input) {
                case 'd': // The following code will be pretty the same, just different directions
                    oldPos = playerPos; // get The current Position of the player
                    newCell = game.getMap().get(playerPos).getRightCell(); // Get the Cell, the player wants to move to
                    if (newCell == null) break; // Cancel, if it is out of bounce
                    playerPos = "" + newCell.getX() + newCell.getY(); // Calculate the new Position of the player
                    game.addCell(playerPos, "\uD83D\uDD34"); // Add the new Player-Cell to the Game
                    game.addCell(oldPos, "⬛"); // Clear the Cell, the player left
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
            System.out.print("\033[H\033[2J"); // This is for clearing the console
        }
    }
}

```
