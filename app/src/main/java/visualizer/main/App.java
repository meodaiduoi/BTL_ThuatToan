package visualizer.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //loader

        // fallback code incase fuck you
        // FXMLLoader loader = new FXMLLoader();
        // loader.setLocation(getClass().getResource("/fxml/hello.fxml"));
        // Parent root = loader.load();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));

        //Window configuration
        stage.setTitle("Algorithm speed visuallizer");
        stage.getIcons().add(new Image("/icon/icon.png"));
        stage.setMinHeight(540);
        stage.setMinWidth(960);

        //stage show
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}