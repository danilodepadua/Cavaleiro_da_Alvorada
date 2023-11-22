package com.mygdx.game.Components;

import com.badlogic.gdx.utils.Array;

// Classe para objetos que podem ser observados por observadores de componentes
public class ComponentSubject {

    // Lista de observadores de componentes
    private Array<ComponentObserver> observers;

    // Construtor que inicializa a lista de observadores
    public ComponentSubject() {
        observers = new Array<>();
    }

    // Adiciona um observador à lista
    public void addObserver(ComponentObserver componentObserver) {
        observers.add(componentObserver);
    }

    // Remove um observador da lista
    public void removeObserver(ComponentObserver componentObserver) {
        observers.removeValue(componentObserver, true);
    }

    // Remove todos os observadores da lista
    public void removeAllObservers() {
        observers.clear();
    }

    // Notifica todos os observadores sobre um evento de componente
    protected void notify(final String value, ComponentObserver.ComponentEvent event) {
        for (ComponentObserver observer : observers) {
            observer.onNotify(value, event);
        }
    }
}
