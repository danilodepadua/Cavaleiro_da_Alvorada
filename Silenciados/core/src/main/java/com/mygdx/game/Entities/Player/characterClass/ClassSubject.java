package com.mygdx.game.Entities.Player.characterClass;

public interface ClassSubject {

    void addObserver(ClassObserver classObserver);
    void removeObserver(ClassObserver classObserver);
    void removeAllObservers();
    void notify(String value, ClassObserver.ClassEvent event);
}
