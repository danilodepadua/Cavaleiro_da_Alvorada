package Interface;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class Gameplay {
    static GameMap currentMap;

    public static void enterPortal(String destinationMap, double playerX, double playerY) {
        // Lógica de entrada em portais com base no mapa de destino
        Gameplay.currentMap.enter(destinationMap, playerX, playerY);
    }

    public static GameMap getCurrentMap() {
        return currentMap;
    }


    public static void spawnEntity(String entityType, int cellX, int cellY) {
        currentMap.spawn(entityType, cellX, cellY);
    }

    public static void spawnTextBox(String text, int cellX, int cellY) {
        currentMap.spawnTextBox(text, cellX, cellY);
    }

}