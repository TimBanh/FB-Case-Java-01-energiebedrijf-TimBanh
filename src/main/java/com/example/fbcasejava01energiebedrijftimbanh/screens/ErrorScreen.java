package com.example.fbcasejava01energiebedrijftimbanh.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorScreen {
// Een popup screen om errors af te handelen
    public static void display(String title, String message) {
//        Een kleine stage wordt opgebouwd.

        Stage errorWindow = new Stage();

        errorWindow.initModality(Modality.APPLICATION_MODAL);
        errorWindow.setTitle(title);
        errorWindow.setMinWidth(250);
//      Een label voor de error message wordt aangemaakt.
        Label lblError = new Label();
        lblError.setText(message);
//        Een button om de stage weer te sluiten
        Button btnCloseError = new Button("Close");
        btnCloseError.setOnAction(e -> errorWindow.close());
//      Een VBox om de button en het label toe te voegen in een goeie layout.
        VBox errorLayout = new VBox();

        errorLayout.getChildren().addAll(lblError, btnCloseError);
        errorLayout.setAlignment(Pos.CENTER);
        errorLayout.setPrefSize(300, 200);
//      De VBox wordt toegevoegd aan de scene.
        Scene sceneError = new Scene(errorLayout);
        errorWindow.setScene(sceneError);
//      De stage wordt alleen gesloten als de button ingedrukt wordt.
        errorWindow.showAndWait();
    }
}