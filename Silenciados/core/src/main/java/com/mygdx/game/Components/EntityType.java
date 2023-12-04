package com.mygdx.game.Components;

import com.badlogic.ashley.core.Component;

public class EntityType implements Component {
    public enum Types{
        Player,
        Enimy,
        Scenery,
        Other
    }

    public Types type;

    public EntityType(Types tipo){
        type = tipo;
    }

}
