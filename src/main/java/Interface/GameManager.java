package Interface;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.geometry.Point2D;

public class GameManager {

    private static Entity player;
    private static Point2D newSpawnPosition;

    public static Entity getPlayer() {
        return player;
    }

    public static void setPlayer(Entity playerEntity) {
        player = playerEntity;
    }

    public static void setNewSpawnPosition(Point2D position) {
        newSpawnPosition = position;
    }

    public static Point2D getNewSpawnPosition() {
        return newSpawnPosition;
    }

    // Método para salvar o estado do jogador
    static void saveSpawnPosition() {
        if (player != null) {
            setNewSpawnPosition(player.getPosition());
            // Salve outras informações do jogador, se necessário
        }
    }

    // Método para carregar o estado do jogador
    private static void loadSpawnPosition() {
        if (player != null) {
            player.getComponent(PhysicsComponent.class).overwritePosition(getNewSpawnPosition());
            // Restaure outras informações do jogador
        }
    }
}
