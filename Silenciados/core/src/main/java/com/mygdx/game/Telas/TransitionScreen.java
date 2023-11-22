package com.mygdx.game.Telas;

import com.badlogic.gdx.Game;
import com.mygdx.game.SilenciadosApp;
import com.mygdx.game.Telas.transition.effects.TransitionEffect;

import java.util.ArrayList;

public class TransitionScreen extends BaseScreen {

    private Game game;
    private BaseScreen current;
    private BaseScreen next;

    int currentTransitionEffect;
    ArrayList<TransitionEffect> transitionEffects;

    TransitionScreen(Game game, BaseScreen current, BaseScreen next, ArrayList<TransitionEffect> transitionEffects) {
        super((SilenciadosApp) game, null);
        this.current = current;
        this.next = next;
        this.transitionEffects = transitionEffects;
        this.currentTransitionEffect = 0;
        this.game = game;
    }

    @Override
    public void render(float delta) {


        if (currentTransitionEffect >= transitionEffects.size()) {
            game.setScreen(next);
            return;
        }

        transitionEffects.get(currentTransitionEffect).update(delta);
        transitionEffects.get(currentTransitionEffect).render(current, next);

        if (transitionEffects.get(currentTransitionEffect).isFinished()) {
            currentTransitionEffect++;
        }

    }

    @Override
    public void show() {
        // Nothing
    }

    @Override
    public void resize(int width, int height) {
        // Nothing
    }

    @Override
    public void pause() {
        // Nothing
    }

    @Override
    public void resume() {
        // Nothing
    }

    @Override
    public void hide() {
        // Nothing
    }

    @Override
    public void dispose() {
        current.dispose();
        next.dispose();
    }
}
