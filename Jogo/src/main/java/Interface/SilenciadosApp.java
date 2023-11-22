package Interface;


import Interface.Components.PlayerComponent;
import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.almasb.fxgl.dsl.FXGL.*;

public class SilenciadosApp extends GameApplication {

    private Text fpsText;
    private Text VelText;
    private Vec2 vel;

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
    protected void initUI() {
        // Cria os Text
        fpsText = new Text("FPS: 0");
        fpsText.setFont(Font.font(18));
        fpsText.setFill(Color.YELLOW);

        VelText = new Text("Vel: x = ; y =");
        VelText.setFont(Font.font(18));
        VelText.setFill(Color.YELLOW);

        // Adiciona os Text à cena do jogo
        addUINode(fpsText, 10, 30);
        addUINode(VelText, 10, 60);
    }

    @Override
    protected void initGame() {

        FXGL.getGameWorld().addEntityFactory(new SilenciadosFactory());

        // Inicializar o mapa atual
        Gameplay.currentMap = new GameMap();

        // Entrar no portal
        Gameplay.currentMap.enter("Mansao", 500, 600);

        //Spawnar um NPC
        spawn("NPC", 500, 500);
    }


    @Override
    protected void initInput() {
        Input input = getInput();

        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                GameMap.getPlayer().getComponent(PlayerComponent.class).moveRight();
            }

            @Override
            protected void onActionEnd() {
                GameMap.getPlayer().getComponent(PlayerComponent.class).stopMoveRight();
            }
        }, KeyCode.D);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                GameMap.getPlayer().getComponent(PlayerComponent.class).moveLeft();
            }

            @Override
            protected void onActionEnd() {
                GameMap.getPlayer().getComponent(PlayerComponent.class).stopMoveLeft();
            }
        }, KeyCode.A);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                GameMap.getPlayer().getComponent(PlayerComponent.class).moveUp();
            }

            @Override
            protected void onActionEnd() {
                GameMap.getPlayer().getComponent(PlayerComponent.class).stopMoveUp();
            }
        }, KeyCode.W);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                GameMap.getPlayer().getComponent(PlayerComponent.class).moveDown();
            }

            @Override
            protected void onActionEnd() {
                GameMap.getPlayer().getComponent(PlayerComponent.class).stopMoveDown();
            }
        }, KeyCode.S);
    }

    @Override
    protected void onUpdate(double tpf) {
        fpsText.setText("FPS: " + Math.round(1.0 / tpf));
        VelText.setText("Vel: x = " + GameMap.getPlayer().getComponent(PlayerComponent.class).MOVE.x + "; y = " + GameMap.getPlayer().getComponent(PlayerComponent.class).MOVE.y);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
