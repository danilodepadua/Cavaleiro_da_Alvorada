package Interface;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityWorldListener;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.components.ViewComponent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;


public class GameMap implements EntityWorldListener {
    private final int mapWidth = 80; // Quantidade de blocos
    private final int mapHeight = 45; // Quantidade de blocos na altura
    private final int tileSize = 32; // cada bloco tem 32x32
    private String currentMapName;
    private static Entity player; // Campo para armazenar a entidade do jogador

    public void enter(String mapName, double playerX, double playerY) {
        currentMapName = mapName;

        // Carregar o nível a partir do mapa e definir como o nível atual
        FXGL.setLevelFromMap(mapName + ".tmx");

        FXGL.getGameScene().getViewport().setLazy(false);

        // Criar a instância do jogador no novo mapa
        player = FXGL.spawn("player", playerX, playerY);

        // Adicionar o jogador à GameWorld
        FXGL.getGameWorld().addEntity(player);

        // Focar a câmera no jogador
        FXGL.getGameScene().getViewport().bindToEntity(player, FXGL.getAppWidth() / 2, FXGL.getAppHeight() / 2);

        //Dar zoom na camera
        FXGL.getGameScene().getViewport().setZoom(1.2);

        // Ajustar manualmente a posição da câmera para garantir que não mostre além dos limites do mapa
        adjustCameraBounds();

        // Fazer spawns específicos de NPCs com base no nome do mapa usando switch
        switch (mapName) {
            case "Castelo2":
                spawnNPC(300, 400);
                break;
            case "":
                // Fazer spawns específicos para outro mapa, se necessário
                break;
            // Adicione mais casos conforme necessário
            default:
                // Lidar com casos não previstos, se houver
                break;
        }

    }


    private void adjustCameraBounds() {
        double mapMinX = 0;
        double mapMinY = 0;
        double mapMaxX = mapWidth * tileSize - FXGL.getAppWidth();
        double mapMaxY = mapHeight * tileSize - FXGL.getAppHeight();

        FXGL.getGameScene().getViewport().setBounds((int) mapMinX, (int) mapMinY, (int) mapMaxX, (int) mapMaxY);
    }



    public void spawnNPC(double x, double y) {
        FXGL.spawn("NPC", x, y); // Chama o método de spawn da classe FXGL
    }



    public void exit() {
        // Lógica para sair do mapa
    }

    public String getName() {
        return currentMapName;
    }

    @Override
    public void onEntityAdded(Entity entity) {
        // Lógica quando uma entidade é adicionada ao mapa
    }

    @Override
    public void onEntityRemoved(Entity entity) {
        // Lógica quando uma entidade é removida do mapa
    }

    public void spawnTextBox(String text, int cellX, int cellY) {
        // Implemente a lógica para criar uma caixa de texto
    }

    public Entity spawn(String entityType, int cellX, int cellY) {
        SpawnData data = new SpawnData(cellX * FXGL.getAppWidth() / 20.0, cellY * FXGL.getAppHeight() / 15.0);
        // Adicione outros dados necessários, se houver
        return FXGL.spawn(entityType, data);
    }

    public static Entity getPlayer() {
        return player;
    }
    public String getCurrentMapName() {
        return currentMapName;
    }

    public void setPlayer(Entity player) {
        this.player = player;
    }

    public void setCurrentMapName(String currentMapName) {
        this.currentMapName = currentMapName;
    }
}
