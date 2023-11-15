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
    public static void handlePortalInteraction() {

    }


    public static GameMap getCurrentMap() {
        return currentMap;
    }

    public static void showAlert(String map, String texto, double playerX, double playerY){
        // Cria um alerta de confirmação
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Trocar de Mapa");
        alert.setHeaderText(null);
        alert.setContentText(texto);

        // Adiciona botões "Sim" e "Não"
        ButtonType buttonSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonNao = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonSim, buttonNao);

        // Obtém a resposta do usuário
        ButtonType result = alert.showAndWait().orElse(buttonNao);
        if(result == buttonSim){
            // Lógica para trocar de mapa
            enterPortal(map, playerX, playerY);
        }
    }

    public static void spawnEntity(String entityType, int cellX, int cellY) {
        currentMap.spawn(entityType, cellX, cellY);
    }

    public static void spawnTextBox(String text, int cellX, int cellY) {
        currentMap.spawnTextBox(text, cellX, cellY);
    }

}