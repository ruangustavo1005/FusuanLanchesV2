import com.sun.deploy.util.StringUtils;
import controller.ControllerLogin;
import javafx.application.Application;
import javafx.stage.Stage;
import view.Index;

/**
 * Classe main do sistema
 * @author Ruan
 */
public class App extends Application {
    
    /**
     * Ao leozin.
     * 
     * Olá, você deve estar me xingando por causa desta classe extendida ali em cima.
     * Mas eu acabei fazendo este projeto como um JavaFX, ou seja, ele só mapeia esta classe como principal se for uma Application.
     * Eu tive que fazer assim por que tava cagando a tela de login e eu precisava limpar o projeto 
     * (o que exige uma classe principal extendendo Application)
     * 
     * Amplexos.
     */
    @Override
    public void start(Stage primaryStage) {
        Index index = new Index();
        index.setVisible(true);
        ControllerLogin controllerLogin = new ControllerLogin();
        controllerLogin.montaTela();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}