package com.example.fbcasejava01energiebedrijftimbanh.screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorScreen {

    public static void display(String title, String message) {
        Stage errorWindow = new Stage();

        errorWindow.initModality(Modality.APPLICATION_MODAL);
        errorWindow.setTitle(title);
        errorWindow.setMinWidth(250);

        Label lblError = new Label();
        lblError.setText(message);
        Button btnCloseError = new Button("Close");
        btnCloseError.setOnAction(e -> errorWindow.close());

        VBox errorLayout = new VBox();

        errorLayout.getChildren().addAll(lblError, btnCloseError);
        errorLayout.setAlignment(Pos.CENTER);
        errorLayout.setPrefSize(300, 200);

        Scene sceneError = new Scene(errorLayout);
        errorWindow.setScene(sceneError);
        errorWindow.showAndWait();
    }
}