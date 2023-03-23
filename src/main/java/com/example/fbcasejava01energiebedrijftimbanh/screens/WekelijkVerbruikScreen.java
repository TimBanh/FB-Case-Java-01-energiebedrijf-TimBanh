package com.example.fbcasejava01energiebedrijftimbanh.screens;

import com.example.fbcasejava01energiebedrijftimbanh.HelloApplication;
import com.example.fbcasejava01energiebedrijftimbanh.controllers.HelloController;
import com.example.fbcasejava01energiebedrijftimbanh.models.Energie;
import com.example.fbcasejava01energiebedrijftimbanh.models.Klant;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class WekelijkVerbruikScreen {
    private final Scene wekelijkVerbruikScene;
    private HelloController controller = HelloApplication.controller;

    public WekelijkVerbruikScreen () {
        Pane container = new Pane();
        container.setPrefWidth(1200);
        container.setPrefHeight(650);
        container.setStyle("-fx-background-color: lime");

        GridPane gridPane = new GridPane();
        gridPane.setId("wekelijkGrid");
        gridPane.setPrefWidth(HelloApplication.globalWidth-15);
        gridPane.setPrefHeight(HelloApplication.globalHeight-30);

        Label lblBeginDatum = new Label("Begin Datum: ");
        DatePicker tfBeginDatum = new DatePicker();

        Label lblEindDatum = new Label("Eind Datum: ");
        DatePicker tfEindDatum = new DatePicker();

        Label lblGetKlant = new Label("Kies een klantnummer: ");
        TextField tfGetKlant = new TextField();

        Label lblKlantNaam = new Label("Klantnaam: ");
        Label lblKlantNaamResult = new Label();

        Label gasTarief = new Label("Gas Tarief: ");
        Label gasTariefResult = new Label();

        Label stroomTarief = new Label("Stroom Tarief: ");
        Label stroomTariefResult = new Label();

        Button btnGetWeek = new Button("Kies Week");


        gridPane.add(lblBeginDatum,0,0);
        gridPane.add(tfBeginDatum,1,0);
        gridPane.add(lblEindDatum,0,1);
        gridPane.add(tfEindDatum,1,1);
        gridPane.add(lblGetKlant,0,2);
        gridPane.add(tfGetKlant,1,2);
        gridPane.add(btnGetWeek,0,3);
        gridPane.add(lblKlantNaam,0,4);
        gridPane.add(lblKlantNaamResult,1,4);
        gridPane.add(gasTarief,0,5);
        gridPane.add(gasTariefResult,1,5);
        gridPane.add(stroomTarief,0,6);
        gridPane.add(stroomTariefResult,1,6);

        gridPane.setAlignment(Pos.CENTER);

        btnGetWeek.setOnAction(getClasses -> {
            int klantNummer = Integer.parseInt(tfGetKlant.getText());
            Klant selectedKlant = controller.getKlantByNumber(klantNummer);
            lblKlantNaamResult.setText(selectedKlant.getVoornaam() + " " + selectedKlant.getAchternaam());

            LocalDate begindatum = tfBeginDatum.getValue();
            LocalDate eindatum = tfEindDatum.getValue();

            Energie gas = HelloApplication.controller.getGasTariefByWeek(begindatum,eindatum);
            System.out.println(gas);
            gasTariefResult.setText(String.valueOf(gas.getTarief()));
        });

        wekelijkVerbruikScene = new Scene(container);
        wekelijkVerbruikScene.getStylesheets().add(HelloApplication.class.getResource("stylesheet/stylesheet.css").toString());
        container.getChildren().add(gridPane);
    }

    public Scene getWekelijkVerbruik() {
        return wekelijkVerbruikScene;
    }
}
