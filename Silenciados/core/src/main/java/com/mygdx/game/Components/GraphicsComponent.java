package com.mygdx.game.Components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Mapa.MapManager;
import com.mygdx.game.Manager.ResourceManager;

import java.util.Hashtable;

public abstract class GraphicsComponent extends ComponentSubject implements Component {
    // Região de textura atualmente em exibição
    protected TextureRegion currentFrame = null;

    // Tempo de quadro para controlar a animação
    protected float frameTime = 0f;

    // Estado e direção atuais da entidade
    protected Entity.State currentState;
    protected Entity.Direction currentDirection;

    // Utilizado para serialização/desserialização de dados
    protected Json json;

    // Posição atual da entidade
    protected Vector2 currentPosition;

    // Tabela de animações associadas aos tipos de animação
    protected Hashtable<Entity.AnimationType, Animation<TextureRegion>> animations;

    // Renderizador de formas para debug (se necessário)
    protected ShapeRenderer shapeRenderer;

    // Construtor padrão inicializando variáveis
    protected GraphicsComponent() {
        currentPosition = new Vector2(0, 0);
        currentState = Entity.State.WALKING;
        currentDirection = Entity.Direction.DOWN;
        json = new Json();
        animations = new Hashtable<>();
        shapeRenderer = new ShapeRenderer();
    }

    // Método para obter a posição atual da entidade
    public Vector2 getCurrentPosition() {
        return currentPosition;
    }

    // Método abstrato para atualizar o componente gráfico
    public abstract void update(Entity entity, MapManager mapManager, Batch batch, float delta);

    protected void updateAnimations(float delta) {
        frameTime = (frameTime + delta)%5; //Want to avoid overflow

        //Look into the appropriate variable when changing position
        switch(currentDirection) {
            case DOWN -> {
                if (currentState == Entity.State.WALKING) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.WALK_DOWN);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if (currentState == Entity.State.IDLE) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.WALK_DOWN);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrames()[0];
                } else if (currentState == Entity.State.IMMOBILE) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.IMMOBILE);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrame(frameTime);
                }
            }
            case LEFT -> {
                if (currentState == Entity.State.WALKING) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.WALK_LEFT);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if (currentState == Entity.State.IDLE) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.WALK_LEFT);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrames()[0];
                } else if (currentState == Entity.State.IMMOBILE) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.IMMOBILE);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrame(frameTime);
                }
            }
            case UP -> {
                if (currentState == Entity.State.WALKING) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.WALK_UP);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if (currentState == Entity.State.IDLE) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.WALK_UP);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrames()[0];
                } else if (currentState == Entity.State.IMMOBILE) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.IMMOBILE);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrame(frameTime);
                }
            }
            case RIGHT -> {
                if (currentState == Entity.State.WALKING) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.WALK_RIGHT);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrame(frameTime);
                } else if (currentState == Entity.State.IDLE) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.WALK_RIGHT);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrames()[0];
                } else if (currentState == Entity.State.IMMOBILE) {
                    Animation<TextureRegion> animation = animations.get(Entity.AnimationType.IMMOBILE);
                    if (animation == null) {
                        return;
                    }
                    currentFrame = animation.getKeyFrame(frameTime);
                }
            }
            default -> {
            }
        }
    }

    // Métodos específicos para carregar animações a partir de texturas
    protected Animation<TextureRegion> loadAnimation(String firstTexture, String secondTexture, Array<GridPoint2> points, float frameDuration) {
        // Carrega a primeira textura do ResourceManager
        ResourceManager.loadTextureAsset(firstTexture);
        Texture texture1 = ResourceManager.getTextureAsset(firstTexture);

        // Carrega a segunda textura do ResourceManager
        ResourceManager.loadTextureAsset(secondTexture);
        Texture texture2 = ResourceManager.getTextureAsset(secondTexture);

        // Divide as texturas em regiões de textura
        TextureRegion[][] texture1Frames = TextureRegion.split(texture1, Entity.FRAME_WIDTH, Entity.FRAME_HEIGHT);
        TextureRegion[][] texture2Frames = TextureRegion.split(texture2, Entity.FRAME_WIDTH, Entity.FRAME_HEIGHT);

        // Obtém o primeiro ponto da lista de pontos
        GridPoint2 point = points.first();

        // Criação da animação com as regiões de textura da primeira e segunda texturas
        Animation<TextureRegion> animation = new Animation<>(frameDuration, texture1Frames[point.x][point.y], texture2Frames[point.x][point.y]);

        // Define o modo de reprodução da animação para LOOP
        animation.setPlayMode(Animation.PlayMode.LOOP);

        // Retorna a animação criada
        return animation;
    }


    // Método para carregar uma animação a partir de uma única textura
    protected Animation<TextureRegion> loadAnimation(String textureName, Array<GridPoint2> points, float frameDuration) {
        // Carrega a textura do ResourceManager
        ResourceManager.loadTextureAsset(textureName);
        Texture texture = ResourceManager.getTextureAsset(textureName);

        // Divide a textura em regiões de textura
        TextureRegion[][] textureFrames = TextureRegion.split(texture, Entity.FRAME_WIDTH, Entity.FRAME_HEIGHT);

        // Cria um array para armazenar as regiões de textura correspondentes aos pontos fornecidos
        TextureRegion[] animationKeyFrames = new TextureRegion[points.size];

        // Preenche o array de regiões de textura usando os pontos fornecidos
        for (int i = 0; i < points.size; i++) {
            animationKeyFrames[i] = textureFrames[points.get(i).x][points.get(i).y];
        }

        // Criação da animação com as regiões de textura fornecidas
        Animation<TextureRegion> animation = new Animation<>(frameDuration, animationKeyFrames);

        // Define o modo de reprodução da animação para LOOP
        animation.setPlayMode(Animation.PlayMode.LOOP);

        // Retorna a animação criada
        return animation;
    }


    // Método para obter uma animação com base no tipo
    public Animation<TextureRegion> getAnimation(Entity.AnimationType type) {
        return animations.get(type);
    }}
