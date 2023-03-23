package com.example.fbcasejava01energiebedrijftimbanh.screens;

import com.example.fbcasejava01energiebedrijftimbanh.HelloApplication;
import com.example.fbcasejava01energiebedrijftimbanh.controllers.HelloController;
import com.example.fbcasejava01energiebedrijftimbanh.models.Klant;
import com.example.fbcasejava01energiebedrijftimbanh.models.Verbruik;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class VerbruikScreen {
    private final Scene verbruikScene;

    private HelloController controller = HelloApplication.controller;

    public VerbruikScreen() {
        Pane container = new Pane();
        container.setPrefWidth(1200);
        container.setPrefHeight(650);
        container.setStyle("-fx-background-color: pink");

        GridPane verbruikGrid = new GridPane();
        verbruikGrid.setId("verbruikGrid");
        verbruikGrid.setPrefWidth(HelloApplication.globalWidth-15);
        verbruikGrid.setPrefHeight(HelloApplication.globalHeight-30);

        Label lblStroomPerKwh = new Label("Stroom in kwh: ");
        TextField tfStroomPerkwh = new TextField();

        Label lblGasPerM3 = new Label("Gas per m3: ");
        TextField tfGasPerM3 = new TextField();

        Label lblDatumStart = new Label("Datum startperiode: ");
        DatePicker tfDatumStart = new DatePicker();

        Label lblDatumEind = new Label("Datum eindperiode: ");
        DatePicker tfDatumEind = new DatePicker();

        Button sendKlantInfo = new Button("Zend");
        Button btnWekelijksVerbruik = new Button("Wekelijks Verbruik");

        verbruikGrid.add(lblStroomPerKwh,0,0);
        verbruikGrid.add(tfStroomPerkwh,1,0);
        verbruikGrid.add(lblGasPerM3,0,1);
        verbruikGrid.add(tfGasPerM3,1,1);
        verbruikGrid.add(lblDatumStart,0,2);
        verbruikGrid.add(tfDatumStart,1,2);
        verbruikGrid.add(lblDatumEind,0,3);
        verbruikGrid.add(tfDatumEind,1,3);
        verbruikGrid.add(sendKlantInfo,0,4);
        verbruikGrid.add(btnWekelijksVerbruik,1,4);

        verbruikGrid.setAlignment(Pos.CENTER);

        sendKlantInfo.setOnAction(regKlant-> {
            double stroomInKwh =  Double.parseDouble(tfStroomPerkwh.getText());
            double gasPerM3 = Double.parseDouble(tfGasPerM3.getText());
            LocalDate startPeriode = tfDatumStart.getValue();
            LocalDate eindPeriode = tfDatumEind.getValue();

            Verbruik verbruik = new Verbruik(stroomInKwh,gasPerM3,startPeriode,eindPeriode);

            controller.addVerbruikToList(verbruik);

        });

        btnWekelijksVerbruik.setOnAction(wekelijkVerbruikScreen -> {
            HelloApplication.stage.setScene(new WekelijkVerbruikScreen().getWekelijkVerbruik());
        });

        verbruikScene = new Scene(container);
        verbruikScene.getStylesheets().add(HelloApplication.class.getResource("stylesheet/stylesheet.css").toString());
        container.getChildren().add(verbruikGrid);
    }

    public Scene getVerbruikScreen() {
        return verbruikScene;
    }
}


