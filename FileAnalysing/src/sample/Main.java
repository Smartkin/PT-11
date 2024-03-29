package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage curStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("File Analyzer");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
        curStage = primaryStage;
        primaryStage.show();
    }

    public static Stage getStage(){
        return curStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
