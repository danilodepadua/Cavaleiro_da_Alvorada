package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Manager.ResourceManager;
import com.mygdx.game.Telas.GameScreen;
import com.mygdx.game.Telas.MenuScreen;

public class SilenciadosApp extends Game {
	private SpriteBatch batch;
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	private ResourceManager resourceManager;


	@Override
	public void create() {
		batch = new SpriteBatch();
		resourceManager = new ResourceManager();

		// Certifique-se de reinicializar as telas
		menuScreen = new MenuScreen(this, resourceManager);
		this.setScreen(menuScreen);
	}


	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		menuScreen.dispose();
		gameScreen.dispose();
		resourceManager.dispose();
	}
	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public GameScreen getTelaJogo() {
		return gameScreen;
	}

	public void setTelaJogo(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
}
