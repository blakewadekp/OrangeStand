package edu.tridenttech.cpt237.orangestand;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
    	StartupWindow win = new StartupWindow(stage);
        Scene scene = new Scene(win.getMainPane(), 400, 200);
        stage.setTitle("Olivia's Orange Outlet");
        stage.setScene(scene);
        stage.show();
    }
}