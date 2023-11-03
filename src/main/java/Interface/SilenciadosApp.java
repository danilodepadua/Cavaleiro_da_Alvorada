package Interface;

import Interface.Components.InvisibleObjectComponent;
import Interface.Components.PlayerComponent;
import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;


import static com.almasb.fxgl.dsl.FXGL.*;

public class SilenciadosApp extends GameApplication {
    private final int mapWidth = 80; // Quantidade de blocos
    private final int mapHeight = 45; // Quantidade de blocos na altura
    private final int tileSize = 32; // cada bloco tem 32x32
    private Entity player;
    private Entity invisivel;

    // Variáveis de dimensões do mapa e tamanho do azulejo
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setTitle("Silenciados");
        settings.setVersion("0.1");
        settings.setDeveloperMenuEnabled(true);
        settings.setFullScreenAllowed(true);
        settings.setApplicationMode(ApplicationMode.DEVELOPER);
    }

    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new SilenciadosFactory());

        // Carrega o mapa inicial
        setLevelFromMap("level0.tmx");

        invisivel = spawn("objetoInvisivel");
        invisivel.addComponent(new InvisibleObjectComponent());

        player = spawn("player");  // spawna o player
        set("player", player);

        // Adiciona o componente PlayerComponent
        player.addComponent(new PlayerComponent());

        GameManager.setPlayer(player);
        //Focar a câmera no jogador
        getGameScene().getViewport().bindToEntity(player, getAppWidth() / 2.0, getAppHeight() / 2.0);}

    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                player.getComponent(PlayerComponent.class).moveRight();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerComponent.class).stopMoveRight();
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                player.getComponent(PlayerComponent.class).moveLeft();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerComponent.class).stopMoveLeft();
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                player.getComponent(PlayerComponent.class).moveUp();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerComponent.class).stopMoveUp();
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                player.getComponent(PlayerComponent.class).moveDown();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(PlayerComponent.class).stopMoveDown();
            }
        }, KeyCode.S);
    }

    @Override
    protected void onUpdate(double tpf) {
        // Coordenadas atuais do jogador
        double playerX = player.getX();
        double playerY = player.getY();

        // Coordenadas mínimas e máximas do mapa
        double mapMinX = 0;
        double mapMinY = 0;
        double mapMaxX = mapWidth * tileSize - getAppWidth();
        double mapMaxY = mapHeight * tileSize - getAppHeight();

        // Define as dimensões da câmera
        getGameScene().getViewport().setBounds((int) mapMinX, (int) mapMinY, (int) mapMaxX, (int) mapMaxY);

        // Atualiza a posição do jogador, garantindo que ele permaneça dentro dos limites do mapa
        player.setX(Math.min(Math.max(playerX, mapMinX), mapMaxX));
        player.setY(Math.min(Math.max(playerY, mapMinY), mapMaxY));
    }

    // Método para mudar de mapa
    public void changeMap(String mapName) {
        // Remova as entidades do mapa atual
        getGameWorld().getEntitiesCopy().forEach(Entity::removeFromWorld);

        // Remova os objetos do layout do mapa anterior
        getGameWorld().getEntitiesByType(EntityType.PLATFORM).forEach(Entity::removeFromWorld);

        // Carregue o novo mapa
        setLevelFromMap(mapName);

        // Spawne novamente o jogador no novo ponto de spawn
        player = spawn("player", 600, 500);

        // Atualize a referência do jogador no GameManager
        GameManager.setPlayer(player);

        // Foca a câmera no jogador
        getGameScene().getViewport().bindToEntity(player, getAppWidth() / 2.0, getAppHeight() / 2.0);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
