package com.mygdx.game.Telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Manager.ResourceManager;
import com.mygdx.game.SilenciadosApp;
import com.mygdx.game.Telas.transition.effects.FadeOutTransitionEffect;
import com.mygdx.game.Telas.transition.effects.TransitionEffect;

import java.util.ArrayList;


public class MenuScreen extends BaseScreen {
    private Table loadTable;
    private Table topTable;
    private Table bottomTable;
    private BaseScreen previousScreen;
    private float stateTime;

    private Stage loadStage = new Stage();

    public MenuScreen(SilenciadosApp gdxGame, ResourceManager resourceManager) {
        super(gdxGame, resourceManager);
        resourceManager.setMenuLoadGameScreen(true);

        loadTable = createTable();

        topTable = createTable();
        topTable.center();
        topTable.setFillParent(true);

        bottomTable = createTable();
        bottomTable.setWidth(Gdx.graphics.getWidth());
        bottomTable.setHeight(Gdx.graphics.getHeight()/2f);
        bottomTable.center();


        handleNewButton();  // Adicione esta linha para criar e adicionar o botão à tabela
    }

    /**
     * Método para lidar com a criação de um novo botão.
     * Este método cria um botão "Play" e adiciona um ouvinte de clique para transição de tela.
     */
    private void handleNewButton() {
        // Cria um botão "Play" na tabela de carregamento
        createButton("Play", 0, loadTable.getHeight() / 9, loadTable);

        // Obtém a referência para o botão recém-criado na tabela de carregamento
        Actor loadButton = loadTable.getCells().get(0).getActor();

        // Ajusta a margem inferior da tabela superior para acomodar o botão
        topTable.padBottom(loadButton.getHeight());

        // Adiciona o botão à tabela inferior com uma margem à direita
        bottomTable.add(loadButton).padRight(50);

        // Adiciona um ouvinte de clique ao botão
        loadButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Define a tela do jogo para a nova tela do jogo
                gdxGame.setGameScreen(new GameScreen(gdxGame, resourceManager));

                // Cria uma lista de efeitos de transição para a troca de tela
                ArrayList<TransitionEffect> effects = new ArrayList<>();
                effects.add(new FadeOutTransitionEffect(1f));

                // Realiza a troca de tela com efeitos de transição
                setScreenWithTransition((BaseScreen) gdxGame.getScreen(), gdxGame.getGameScreen(), effects);
            }
        });
    }



    @Override
    public void show() {
        loadStage.addActor(loadTable);
        loadStage.addActor(topTable);
        loadStage.addActor(bottomTable);
        Gdx.input.setInputProcessor(loadStage);
    }

    /**
     * Método chamado para renderizar a tela. Atualiza o tempo do estado, renderiza a tela anterior (se houver),
     * exibe as tabelas na cena e desenha a cena de carregamento.
     * @param delta O tempo entre os quadros (em segundos).
     */
    @Override
    public void render(float delta) {
        // Atualiza o tempo do estado
        stateTime += Gdx.graphics.getDeltaTime();

        // Renderiza a tela anterior (se houver)
        if (previousScreen != null) {
            previousScreen.render(stateTime);
        }

        // Chama o método show() para adicionar elementos à cena
        show();

        // Atualiza e desenha a cena de carregamento
        loadStage.act(delta);
        loadStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        loadTable.remove();
        topTable.remove();
        bottomTable.remove();
    }

    @Override
    public void hide() {
        resourceManager.setMenuLoadGameScreen(false);
    }
}

