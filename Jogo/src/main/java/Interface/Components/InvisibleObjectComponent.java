package Interface.Components;

import Interface.EntityType;
import Interface.SilenciadosApp;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class InvisibleObjectComponent extends Component {

    @Override
    public void onAdded() {
        entity.getViewComponent().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            // Verifica se o jogador está colidindo com o objeto invisível
            Entity player = FXGL.getGameWorld().getSingleton(EntityType.PLAYER);
            Entity arvore = entity.getWorld().getSingleton(EntityType.ARVORE);


            System.out.println("Player is colliding with the invisible object!");

            // Cria um alerta de confirmação
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Trocar de Mapa");
            alert.setHeaderText(null);
            alert.setContentText("Deseja ir ao banco? ");

            // Adiciona botões "Sim" e "Não"
            ButtonType buttonSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
            ButtonType buttonNao = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonSim, buttonNao);

            // Obtém a resposta do usuário
            ButtonType result = alert.showAndWait().orElse(buttonNao);

            // Se o usuário clicou em "Sim", carrega o novo mapa
            if (result == buttonSim) {
                SilenciadosApp app = (SilenciadosApp) FXGL.getApp();
                app.changeMap("level1.tmx", 10, 10);


                Entity portaVolta = FXGL.spawn("objetoInvisivel", 50, 50);
                portaVolta.addComponent(new VoltarComponent());

                Entity portaFloresta = FXGL.spawn("objetoInvisivel", 200, 200);
                portaFloresta.addComponent(new IrParaFlorestsComponent());

                System.out.println("Colliding with invisivel!");
            }

        });
    }
}