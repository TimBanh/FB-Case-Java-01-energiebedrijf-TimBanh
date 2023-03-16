package com.example.fbcasejava01energiebedrijftimbanh;

import com.example.fbcasejava01energiebedrijftimbanh.screens.KlantRegScreen;
import com.example.fbcasejava01energiebedrijftimbanh.screens.VerbruikScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage stage;
    public static int globalWidth = 1200;
    public static int globalHeight = 650;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("Current Energiebedrijf");
        stage.setWidth(globalWidth);
        stage.setHeight(globalHeight);
        stage.setResizable(false);
        stage.setScene(new KlantRegScreen(stage).getKlantReg());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}