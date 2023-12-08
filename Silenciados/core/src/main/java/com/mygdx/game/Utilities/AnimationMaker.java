package com.mygdx.game.Utilities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationMaker {
    public static Animation<TextureRegion> MakeAnim(float Duration, Texture texture, int Rows, int Cols, int num){
        TextureRegion[] frames = new TextureRegion[num];
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/Cols, texture.getHeight()/Rows);
        int index = 0;
        for(int i =0; i<Rows;i++){
            for(int j =0; j<Cols; j++){
                frames[index] = tmp[i][j];
                index++;
                if(index>=num){
                    break;
                }
            }
        }
        Animation<TextureRegion> Anim = new Animation<TextureRegion>(Duration,frames);
        Anim.setPlayMode(Animation.PlayMode.LOOP);
        return Anim;
    }
}
