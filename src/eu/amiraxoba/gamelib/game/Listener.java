package eu.amiraxoba.gamelib.game;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Scanner;

public class Listener {
    public static char getInput(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        return sc.next().toCharArray()[0];
    }
}
