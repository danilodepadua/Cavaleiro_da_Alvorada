package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Manejar.ManejarRecursos;
import com.mygdx.game.Telas.TelaJogo;

public class Silenciados extends Game {
	SpriteBatch batch;
	private ManejarRecursos manejarRecursos;
	private TelaJogo telaJogo;

	@Override
	public void create () {
		batch = new SpriteBatch();
		manejarRecursos = new ManejarRecursos();

		telaJogo = new TelaJogo(this, manejarRecursos);
		this.setScreen(telaJogo);

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
