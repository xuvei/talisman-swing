package org.example;

import org.example.client.Display;
import org.example.client.GameEngine;
import org.example.client.View;

public class App {
    public static void main(String[] args) {
        Display display = new Display("Talisman");
        View view = new View();
        GameEngine gameEngine = new GameEngine(display, view);
        gameEngine.start();
    }
}