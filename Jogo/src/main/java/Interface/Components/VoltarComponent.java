package Interface.Components;

import Interface.SilenciadosApp;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class VoltarComponent extends Component {

    @Override
    public void onAdded() {
        entity.getViewComponent().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {

            // Cria um alerta de confirmação
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Voltar para o Mapa Anterior");
            alert.setHeaderText(null);
            alert.setContentText("Deseja voltar para o castelo?");

            // Adiciona botões "Sim" e "Não"
            ButtonType buttonSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
            ButtonType buttonNao = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonSim, buttonNao);

            // Obtém a resposta do usuário
            ButtonType result = alert.showAndWait().orElse(buttonNao);

            // Se o usuário clicou em "Sim", volta para o mapa anterior
            if (result == buttonSim) {
                SilenciadosApp app = (SilenciadosApp) FXGL.getApp();
                app.changeMap("level0.tmx", 50, 50);
            }
        });
    }
}
