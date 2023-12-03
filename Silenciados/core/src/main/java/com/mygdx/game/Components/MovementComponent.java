package com.mygdx.game.Components;

import com.badlogic.ashley.core.Component;

public class MovementComponent implements Component {
    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;
    public float Speed;

    public MovementComponent(float speed){
        this.Speed = speed;
    }
}