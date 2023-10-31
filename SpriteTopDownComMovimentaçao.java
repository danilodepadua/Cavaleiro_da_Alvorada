package Interface;

import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;

public class PlayerComponent extends Component {

    private Vec2 MOVE = new Vec2();
    private int speed = 300;
    private PhysicsComponent physics;
    private AnimatedTexture texture;
    private AnimationChannel  animWalkUp, animWalkDown, animWalkLeft, animWalkRight, channelIdleUp, channelIdleDown, channelIdleLeft, channelIdleRight;

    public PlayerComponent() {
        // Carrega a imagem do jogador
        Image image = image("dev_player.png");

        // Define canais de animação para o jogador parado em diferentes direções
        channelIdleDown = new AnimationChannel(image, 9, 64, 64, Duration.seconds(1.2), 9 * 10, 9 * 10);
        channelIdleRight = new AnimationChannel(image, 9, 64, 64, Duration.seconds(1.2), 9 * 11, 9 * 11);
        channelIdleUp = new AnimationChannel(image, 9, 64, 64, Duration.seconds(1.2), 9 * 8, 9 * 8);
        channelIdleLeft = new AnimationChannel(image, 9, 64, 64, Duration.seconds(1.2), 9 * 9, 9 * 9);

        // Define canais de animação para o jogador em movimento em diferentes direções
        animWalkDown = new AnimationChannel(image, 9, 64, 64, Duration.seconds(0.4), 9 * 10, 9 * 10 + 9 - 1);
        animWalkRight = new AnimationChannel(image, 9, 64, 64, Duration.seconds(0.5), 9 * 11, 9 * 11 + 9 - 1);
        animWalkUp = new AnimationChannel(image, 9, 64, 64, Duration.seconds(0.4), 9 * 8, 9 * 8 + 9 - 1);
        animWalkLeft = new AnimationChannel(image, 9, 64, 64, Duration.seconds(0.5), 9 * 9, 9 * 9 + 9 - 1);

        // Inicializa a textura com a animação ociosa
        texture = new AnimatedTexture(channelIdleDown);
        texture.loop();
    }

    @Override
    public void onAdded() {
        // Adiciona a textura à visualização da entidade
        entity.getViewComponent().addChild(texture);

        // Obtém o componente de física da entidade
        physics = entity.getComponent(PhysicsComponent.class);
    }

    @Override
    public void onUpdate(double tpf) {
        // Verifica se o jogador está se movendo
        if (MOVE.x != 0 || MOVE.y != 0) {
            // Verifica a direção do movimento e define a animação apropriada
            if (MOVE.x > 0) {
                if (texture.getAnimationChannel() != animWalkRight) {
                    texture.loopAnimationChannel(animWalkRight);
                }
            } else if (MOVE.x < 0) {
                if (texture.getAnimationChannel() != animWalkLeft) {
                    texture.loopAnimationChannel(animWalkLeft);
                }
            } else if (MOVE.y > 0) {
                if (texture.getAnimationChannel() != animWalkDown) {
                    texture.loopAnimationChannel(animWalkDown);
                }
            } else if (MOVE.y < 0) {
                if (texture.getAnimationChannel() != animWalkUp) {
                    texture.loopAnimationChannel(animWalkUp);
                }
            }
        } else {
            // Jogador parado, escolhe a animação ociosa apropriada
            if (texture.getAnimationChannel() == animWalkDown) {
                texture.loopAnimationChannel(channelIdleDown);
            } else if (texture.getAnimationChannel() == animWalkRight) {
                texture.loopAnimationChannel(channelIdleRight);
            } else if (texture.getAnimationChannel() == animWalkUp) {
                texture.loopAnimationChannel(channelIdleUp);
            } else if (texture.getAnimationChannel() == animWalkLeft) {
                texture.loopAnimationChannel(channelIdleLeft);
            }
        }

        // Define a velocidade linear com base na entrada do jogador
        physics.setLinearVelocity(MOVE.x * speed, MOVE.y * speed);
    }

    // Métodos que ajustam o vetor de movimento com base nas teclas pressionadas ou soltas

    public void moveRight() {
        MOVE.x = 1;
    }

    public void stopMoveRight() {
        MOVE.x = 0;
    }

    public void moveLeft() {
        MOVE.x = -1;
    }

    public void stopMoveLeft() {
        MOVE.x = 0;
    }

    public void moveUp() {
        MOVE.y = -1;
    }

    public void stopMoveUp() {
        MOVE.y = 0;
    }

    public void moveDown() {
        MOVE.y = 1;
    }

    public void stopMoveDown() {
        MOVE.y = 0;
    }
}

//Lembrar de colocar a textura 
//Caminho que eu utilizei
//resourcers -> assets -> textures -> dev_player.png

//Na hora de criar o Factory, lembrar de colocar
// .with(new PlayerComponent()); 


//Chamar as animações na classe aplicativo : 

// @Override
// protected void initInput() {
//     // Obtém o objeto de entrada para configurar ações do usuário
//     Input input = getInput();

//     // Configuração da ação de mover para a direita (tecla D)
//     input.addAction(new UserAction("Move Right") {
//         @Override
//         protected void onAction() {
//             player.getComponent(PlayerComponent.class).moveRight(); // Define a direção para a direita quando a tecla é pressionada
//         }

//         @Override
//         protected void onActionEnd() {
//             player.getComponent(PlayerComponent.class).stopMoveRight(); // Define a direção como 0 quando a tecla é solta
//         }
//     }, KeyCode.D);

//     // Configuração da ação de mover para a esquerda (tecla A)
//     input.addAction(new UserAction("Move Left") {
//         @Override
//         protected void onAction() {
//             player.getComponent(PlayerComponent.class).moveLeft(); // Define a direção para a esquerda quando a tecla é pressionada
//         }

//         @Override
//         protected void onActionEnd() {
//             player.getComponent(PlayerComponent.class).stopMoveLeft(); // Define a direção como 0 quando a tecla é solta
//         }
//     }, KeyCode.A);

//     // Configuração da ação de mover para cima (tecla W)
//     input.addAction(new UserAction("Move Up") {
//         @Override
//         protected void onAction() {
//             player.getComponent(PlayerComponent.class).moveUp(); // Define a direção para cima quando a tecla é pressionada
//         }

//         @Override
//         protected void onActionEnd() {
//             player.getComponent(PlayerComponent.class).stopMoveUp(); // Define a direção como 0 quando a tecla é solta
//         }
//     }, KeyCode.W);

//     // Configuração da ação de mover para baixo (tecla S)
//     input.addAction(new UserAction("Move Down") {
//         @Override
//         protected void onAction() {
//             player.getComponent(PlayerComponent.class).moveDown(); // Define a direção para baixo quando a tecla é pressionada
//         }

//         @Override
//         protected void onActionEnd() {
//             player.getComponent(PlayerComponent.class).stopMoveDown(); // Define a direção como 0 quando a tecla é solta
//         }
//     }, KeyCode.S);
// }
