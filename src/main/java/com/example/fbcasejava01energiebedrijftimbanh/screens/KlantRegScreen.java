package com.example.fbcasejava01energiebedrijftimbanh.screens;

import com.example.fbcasejava01energiebedrijftimbanh.HelloApplication;
import com.example.fbcasejava01energiebedrijftimbanh.controllers.HelloController;
import com.example.fbcasejava01energiebedrijftimbanh.models.Klant;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KlantRegScreen {
    private final Scene klantRegScene;
    private HelloController controller = HelloApplication.controller;

    public KlantRegScreen (Stage stage) {
        Pane container = new Pane();
        container.setPrefWidth(1200);
        container.setPrefHeight(650);
        container.setStyle("-fx-background-color: grey");

        GridPane gridPane = new GridPane();
        gridPane.setId("gridPane");
        gridPane.setPrefWidth(HelloApplication.globalWidth-15);
        gridPane.setPrefHeight(HelloApplication.globalHeight-30);

        Label lblKlantNumer = new Label("Klantnummer: ");
        TextField tfKlantNummer = new TextField();

        Label lblVoornaam = new Label("Voornaam: ");
        TextField tfVoornaam = new TextField();

        Label lblAchternaam = new Label("Achternaam: ");
        TextField tfAchternaam = new TextField();

        Label lblJaVoorschot = new Label("Jaar voorschot: ");
        TextField tfJaVoorschot = new TextField();

        Button sendKlantInfo = new Button("Zend");
        Button btnTariefScreen = new Button("Tarieven");

        gridPane.add(lblKlantNumer,0,0);
        gridPane.add(tfKlantNummer,1,0);
        gridPane.add(lblVoornaam,0,1);
        gridPane.add(tfVoornaam,1,1);
        gridPane.add(lblAchternaam,0,2);
        gridPane.add(tfAchternaam,1,2);
        gridPane.add(lblJaVoorschot,0,3);
        gridPane.add(tfJaVoorschot,1,3);
        gridPane.add(sendKlantInfo,0,4);
        gridPane.add(btnTariefScreen,1,4);

        gridPane.setAlignment(Pos.CENTER);

        sendKlantInfo.setOnAction(regKlant-> {
            int klantNr =  Integer.parseInt(tfKlantNummer.getText());
            String voorNm = tfVoornaam.getText();
            String achterNm = tfAchternaam.getText();
            double jaarlijkVoorschot = Double.parseDouble(tfJaVoorschot.getText());

            Klant klant = new Klant(klantNr,voorNm,achterNm,jaarlijkVoorschot);
            controller.addKlantToList(klant);
        });

        btnTariefScreen.setOnAction(goToTarief -> {
            HelloApplication.stage.setScene(new TarievenScreen().getTarievenScene());
        });

        klantRegScene = new Scene(container);
        klantRegScene.getStylesheets().add(HelloApplication.class.getResource("stylesheet/stylesheet.css").toString());
        container.getChildren().add(gridPane);
    }

    public Scene getKlantReg() {
        return klantRegScene;
    }
}


