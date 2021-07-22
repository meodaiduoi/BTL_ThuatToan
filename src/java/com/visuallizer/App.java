//package java.com.visuallizer;

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
        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));

        //Window configuration
        stage.setTitle("Algorithm speed visuallizer");
        stage.getIcons().add(new Image("icon.png"));
        stage.setMinHeight(450);
        stage.setMinWidth(600);

        //stage show
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}