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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.time.LocalDate;

public class TarievenScreen {

    private final Scene tarievenScene; // De scene wordt aangemaakt;
    private HelloController controller = HelloApplication.controller; //Shortcut naar de controller die gemaakt is in de HelloAplication class

    public TarievenScreen() {
        //        Container wordt gemaakt om content er in te zetten.
        Pane tariefContainer = new Pane();
        tariefContainer.setStyle("-fx-background-color: yellow");
        tariefContainer.setPrefWidth(1200);
        tariefContainer.setPrefHeight(650);
//        Gridpane wordt gemaakt voor de layout
        GridPane tariefGrid = new GridPane();
        tariefGrid.setId("tariefGrid");
        tariefGrid.setPrefWidth(HelloApplication.globalWidth-15);
        tariefGrid.setPrefHeight(HelloApplication.globalHeight-30);
//      Alle labels om Tarieven toe te voegen voor stroom en gas.
        Label lblTariefStroom = new Label("Tarief Stroom: ");
        TextField tfTariefStroom = new TextField();

        Label lblTariefGas = new Label("Tarief Gas: ");
        TextField tfTariefGas = new TextField();

        Label lblBeginDatum = new Label("Begin Datum: ");
        DatePicker tfBeginDatum = new DatePicker();

        Label lblEindDatum = new Label("Eind Datum: ");
        DatePicker tfEindDatum = new DatePicker();
//      Buttons om Tarieven toe te voegen en te navigeren tussen schermen
        Button sendTarief = new Button("Zend");
        Button btnVebruikScreen = new Button("Verbruik");
        Button btnKlantRegScreen = new Button("Klanten");
        Button btnWekelijksVerbruik = new Button("Wekelijks Verbruik");
//      Alle labels en buttons worden aan de GridPane toegevoegd
        tariefGrid.add(lblTariefStroom, 0,0);
        tariefGrid.add(tfTariefStroom,1,0);
        tariefGrid.add(lblTariefGas,0,1);
        tariefGrid.add(tfTariefGas,1,1);
        tariefGrid.add(lblBeginDatum,0,2);
        tariefGrid.add(tfBeginDatum, 1,2);
        tariefGrid.add(lblEindDatum,0,3);
        tariefGrid.add(tfEindDatum,1,3);
        tariefGrid.add(sendTarief,0,4);
        tariefGrid.add(btnKlantRegScreen,1,4);
        tariefGrid.add(btnVebruikScreen,2,4);
        tariefGrid.add(btnWekelijksVerbruik,3,4);
//      Alle content in de GridPane wordt gecentreerd.
        tariefGrid.setAlignment(Pos.CENTER);
//      Button sendTarief checkt of alle velden ingevuld zijn en voegt de Tarieven toe in een ArrayList als alle gegevens ingevuld zijn.
        sendTarief.setOnAction(regTarief -> {
            if (tfTariefGas.getText().isEmpty()
                || tfTariefStroom.getText().isEmpty()
                || tfBeginDatum.getValue().toString().isEmpty()
                || tfEindDatum.getValue().toString().isEmpty()) {
                ErrorScreen.display("Velden", "Niet alle velden zijn ingevuld");
            } else {

                double stroomTarief = Double.parseDouble(tfTariefStroom.getText());
                double gasTarief = Double.parseDouble(tfTariefGas.getText());
                LocalDate tariefBeginDatum = tfBeginDatum.getValue();
                LocalDate tariefEindDatum = tfEindDatum.getValue();

                Stroom stroom = new Stroom(stroomTarief, tariefBeginDatum, tariefEindDatum);
                controller.addStroomToEnergyTarieven(stroom);

                Gas gas = new Gas(gasTarief, tariefBeginDatum, tariefEindDatum);
                controller.addGasToEnergyTarieven(gas);
            }
        });
//      btnKlantRegScreen navigeert naar het KlantRegScreen
        btnKlantRegScreen.setOnAction(goToKlant -> {
            HelloApplication.stage.setScene(new KlantRegScreen(HelloApplication.stage).getKlantReg());
        });
//      btnVerbruikScreen navigeert naar het VerbruikScreen
        btnVebruikScreen.setOnAction(goToVerbuik -> {
            HelloApplication.stage.setScene(new VerbruikScreen().getVerbruikScreen());
        });
//        btnWekelijksVerbruikScreen navigeert naar het WekelijkVerbruikScreen
        btnWekelijksVerbruik.setOnAction(goToWekelijkVerbruik -> {
            HelloApplication.stage.setScene(new WekelijkVerbruikScreen().getWekelijkVerbruik());

        });
//      Scene wordt aangemaakt en de container met alle content wordt toegevoegd.
        tarievenScene = new Scene(tariefContainer);
        //        Stylesheet wordt gekoppeld.
        tarievenScene.getStylesheets().add(HelloApplication.class.getResource("stylesheet/stylesheet.css").toString());
        //        container wordt gevuld met de GridPane met alle Labels en Buttons
        tariefContainer.getChildren().add(tariefGrid);

    }
    //      De methode returned de tarievenScen.
    public Scene getTarievenScene() {
        return tarievenScene;
    }

}
