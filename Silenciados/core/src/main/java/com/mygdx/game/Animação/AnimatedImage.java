package com.mygdx.game.Animação;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.mygdx.game.Entities.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Ótimo uso de pacotes para manter as coisas organizadas!

public class AnimatedImage extends Image {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnimatedImage.class);
    private float frameTime = 0;
    protected Entity entity;
    private Entity.AnimationType currentAnimationType = Entity.AnimationType.IDLE;

    // Construtor padrão
    public AnimatedImage() {
        super();
    }

    // Método para obter a entidade associada a esta imagem animada
    public Entity getEntity() {
        return entity;
    }

    // Método para definir a entidade associada a esta imagem animada
    public void setEntity(Entity entity) {
        this.entity = entity;
        // Configuração padrão da animação
        setCurrentAnimation(Entity.AnimationType.IDLE);
    }

    // Método para obter o tipo de animação atual
    public Entity.AnimationType getCurrentAnimationType() {
        return this.currentAnimationType;
    }

    // Método para definir a animação atual
    public void setCurrentAnimation(Entity.AnimationType animationType){
        Animation<TextureRegion> animation = entity.getAnimation(animationType);
        if ( animation == null ){
            LOGGER.debug("Animation type {} does not exist!", animationType.toString());
            return;
        }

        this.currentAnimationType = animationType;
        this.setDrawable(new TextureRegionDrawable(animation.getKeyFrame(0)));
        this.setScaling(Scaling.stretch);
        this.setAlign(Align.center);
    }

    // Sobrescreve o método act para atualizar a imagem animada
    @Override
    public void act(float delta) {
        super.act(delta);

        Drawable drawable = getDrawable();
        if (drawable == null) {
            // Evita problemas se o desenho for nulo
            return;
        }
        frameTime = (frameTime + delta)%5;
        TextureRegion currentRegion = entity.getAnimation(currentAnimationType).getKeyFrame(frameTime, true);
        ((TextureRegionDrawable) drawable).setRegion(currentRegion);

        // Atualiza todas as ações associadas à imagem
        for (Action action : getActions()) {
            action.act(delta);
        }
    }
}
