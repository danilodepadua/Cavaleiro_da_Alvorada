package com.mygdx.game;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Components.Systems.MovementSystem;
import com.mygdx.game.Components.Systems.RenderingSystem;
import com.mygdx.game.Entities.PlayerEntity;
import com.mygdx.game.Manejar.ManejarRecursos;
import com.mygdx.game.Telas.TelaJogo;

public class Silenciados extends Game {
	SpriteBatch batch;
	private ManejarRecursos manejarRecursos;
	private TelaJogo telaJogo;
	public Engine engine = new Engine();

	@Override
	public void create () {
		batch = new SpriteBatch();
		manejarRecursos = new ManejarRecursos();

		telaJogo = new TelaJogo(this, manejarRecursos);
		this.setScreen(telaJogo);
		engine.addSystem(new MovementSystem());
		engine.addSystem(new RenderingSystem(batch, telaJogo.camera));
	}
	@Override
	public void dispose () {
		batch.dispose();
		telaJogo.dispose();
		manejarRecursos.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public TelaJogo getTelaJogo() {
		return telaJogo;
	}

	public void setTelaJogo(TelaJogo telaJogo) {
		this.telaJogo = telaJogo;
	}
}
