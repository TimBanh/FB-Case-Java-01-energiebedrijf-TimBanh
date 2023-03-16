package com.example.fbcasejava01energiebedrijftimbanh.screens;

import com.example.fbcasejava01energiebedrijftimbanh.HelloApplication;
import com.example.fbcasejava01energiebedrijftimbanh.controllers.HelloController;
import com.example.fbcasejava01energiebedrijftimbanh.models.Gas;
import com.example.fbcasejava01energiebedrijftimbanh.models.Stroom;
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

public class TarievenScreen {

    private final Scene tarievenScene;
    private HelloController controller = new HelloController();

    public TarievenScreen() {
        Pane tariefContainer = new Pane();
        tariefContainer.setStyle("-fx-background-color: yellow");
        tariefContainer.setPrefWidth(1200);
        tariefContainer.setPrefHeight(650);

        GridPane tariefGrid = new GridPane();
        tariefGrid.setId("tariefGrid");
        tariefGrid.setPrefWidth(HelloApplication.globalWidth-15);
        tariefGrid.setPrefHeight(HelloApplication.globalHeight-30);

        Label lblTariefStroom = new Label("Tarief Stroom: ");
        TextField tfTariefStroom = new TextField();

        Label lblTariefGas = new Label("Tarief Gas: ");
        TextField tfTariefGas = new TextField();

        Label lblBeginDatum = new Label("Begin Datum: ");
        DatePicker tfBeginDatum = new DatePicker();

        Label lblEindDatum = new Label("Eind Datum: ");
        DatePicker tfEindDatum = new DatePicker();

        Button sendTarief = new Button("Zend");
        Button btnVebruikScreen = new Button("Verbruik");

        tariefGrid.add(lblTariefStroom, 0,0);
        tariefGrid.add(tfTariefStroom,1,0);
        tariefGrid.add(lblTariefGas,0,1);
        tariefGrid.add(tfTariefGas,1,1);
        tariefGrid.add(lblBeginDatum,0,2);
        tariefGrid.add(tfBeginDatum, 1,2);
        tariefGrid.add(lblEindDatum,0,3);
        tariefGrid.add(tfEindDatum,1,3);
        tariefGrid.add(sendTarief,0,4);
        tariefGrid.add(btnVebruikScreen,1,4);

        tariefGrid.setAlignment(Pos.CENTER);

        sendTarief.setOnAction(regTarief -> {
            double stroomTarief = Double.parseDouble(tfTariefStroom.getText());
            double gasTarief = Double.parseDouble(tfTariefGas.getText());
            LocalDate tariefBeginDatum = tfBeginDatum.getValue();
            LocalDate tariefEindDatum = tfEindDatum.getValue();

            Stroom stroom = new Stroom(stroomTarief, tariefBeginDatum, tariefEindDatum);
            Gas gas = new Gas(gasTarief,tariefBeginDatum,tariefEindDatum);

            controller.addEnegieToList(stroom);
            controller.addEnegieToList(gas);
        });

        btnVebruikScreen.setOnAction(goToVerbuik -> {
            HelloApplication.stage.setScene(new VerbruikScreen().getVerbruikScreen());
        });

        tarievenScene = new Scene(tariefContainer);
        tarievenScene.getStylesheets().add(HelloApplication.class.getResource("stylesheet/stylesheet.css").toString());
        tariefContainer.getChildren().add(tariefGrid);

    }

    public Scene getTarievenScene() {
        return tarievenScene;
    }

}
