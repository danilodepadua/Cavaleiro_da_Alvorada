package com.mygdx.game.Camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

// Classe utilitária para aplicar estilos específicos à câmera
public class CameraStyles {

    // Construtor privado para garantir que a classe não seja instanciada
    private CameraStyles() {
    }

    // Método para limitar a posição da câmera dentro de certos limites
    public static void boundaries(OrthographicCamera camera, float startX, float startY, float width, float height) {
        Vector3 position = camera.position;

        // Limita a posição da câmera no eixo x
        if (position.x < startX) {
            position.x = startX;
        }
        if (position.x > startX + width) {
            position.x = startX + width;
        }

        // Limita a posição da câmera no eixo y
        if (position.y < startY) {
            position.y = startY;
        }
        if (position.y > startY + height) {
            position.y = startY + height;
        }

        // Atualiza a posição da câmera e aplica as mudanças
        camera.position.set(position);
        camera.update();
    }
}
