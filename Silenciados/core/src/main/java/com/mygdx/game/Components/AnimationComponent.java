package com.mygdx.game.Components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimationComponent implements Component {
    public Array<Animation<TextureRegion>> animations;
    public float Time;
    public int currentAnimationIndex = 0;
    public AnimationComponent(Array<Animation<TextureRegion>> anims){
        animations = anims;
    }
    public Animation<TextureRegion> getCurrentAnimation() {
        return animations.get(currentAnimationIndex);
    }
    public void ChangeAnimation(int i){
        if(i>=0 && i< animations.size && i!= currentAnimationIndex){
            currentAnimationIndex = i;
            Time = 0f;
            System.out.println("Animação: " + i);
            System.out.println("Atual: " + currentAnimationIndex);
        }
    }
}
