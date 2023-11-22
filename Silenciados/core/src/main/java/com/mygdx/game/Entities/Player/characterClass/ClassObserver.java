package com.mygdx.game.Entities.Player.characterClass;

public interface ClassObserver {

    enum ClassEvent {
        CHECK_UPGRADE_TREE_CLASS
    }

    void onNotify(String value, ClassEvent event);
}
