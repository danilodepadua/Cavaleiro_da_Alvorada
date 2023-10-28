package Interface;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.views.ScrollingBackgroundView;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class SilenciadosFactory implements EntityFactory {

    @Spawns("background")
    public Entity newBackground(SpawnData data) {
        return FXGL.entityBuilder()
                .view(new ScrollingBackgroundView(texture("background/fundinho.png").getImage(), getAppWidth(), getAppHeight()))
                .zIndex(-1)
                .with(new IrremovableComponent())
                .build();
    }
}

//Caminho : resources/assets/textures/background/nomeDaImagem.png 


//Mudar o module info java para /**
//  * @author Almas Baimagambetov (almaslvl@gmail.com)
//  */
// open module zephyria.main {
//     requires kotlin.stdlib;
//     requires com.almasb.fxgl.all;
//     requires javafx.media;
// }
