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
    private final Scene verbruikScene; // De scene wordt aangemaakt

    private HelloController controller = HelloApplication.controller;//Shortcut naar de controller die gemaakt is in de HelloAplication class

    public VerbruikScreen() {
        //        Container wordt gemaakt om content er in te zetten.
        Pane container = new Pane();
        container.setPrefWidth(1200);
        container.setPrefHeight(650);
        container.setStyle("-fx-background-color: pink");
//      Gridpane wordt gemaakt voor de layout
        GridPane verbruikGrid = new GridPane();
        verbruikGrid.setId("verbruikGrid");
        verbruikGrid.setPrefWidth(HelloApplication.globalWidth-15);
        verbruikGrid.setPrefHeight(HelloApplication.globalHeight-30);
//      Alle labels om het Verbruik te maken worden aangemaakt.
        Label lblStroomPerKwh = new Label("Stroom in kwh: ");
        TextField tfStroomPerkwh = new TextField();

        Label lblGasPerM3 = new Label("Gas per m3: ");
        TextField tfGasPerM3 = new TextField();

        Label lblDatumStart = new Label("Datum startperiode: ");
        DatePicker tfDatumStart = new DatePicker();

        Label lblDatumEind = new Label("Datum eindperiode: ");
        DatePicker tfDatumEind = new DatePicker();
//      Buttons om het Verbruik toe te voegen en te navigeren tussen schermen
        Button sendVebruikInfo = new Button("Zend");
        Button btnKlantRegScreen = new Button("Klanten");
        Button btnTariefScreen = new Button("Tarieven");
        Button btnWekelijksVerbruik = new Button("Wekelijks Verbruik");
//      Alle labels en buttons worden aan de GridPane toegevoegd
        verbruikGrid.add(lblStroomPerKwh,0,0);
        verbruikGrid.add(tfStroomPerkwh,1,0);
        verbruikGrid.add(lblGasPerM3,0,1);
        verbruikGrid.add(tfGasPerM3,1,1);
        verbruikGrid.add(lblDatumStart,0,2);
        verbruikGrid.add(tfDatumStart,1,2);
        verbruikGrid.add(lblDatumEind,0,3);
        verbruikGrid.add(tfDatumEind,1,3);
        verbruikGrid.add(sendVebruikInfo,0,4);
        verbruikGrid.add(btnKlantRegScreen,1,4);
        verbruikGrid.add(btnTariefScreen,2,4);
        verbruikGrid.add(btnWekelijksVerbruik,3,4);
//      Alle content in de GridPane wordt gecentreerd.
        verbruikGrid.setAlignment(Pos.CENTER);
//      Button sendVerbruikInfo checkt of alle velden ingevuld zijn en voegt het Verbruik toe in een ArrayList als alle gegevens ingevuld zijn.
        sendVebruikInfo.setOnAction(verbruikReg-> {
            if (tfGasPerM3.getText().isEmpty()
                    || tfStroomPerkwh.getText().isEmpty()
                    || tfDatumStart.getValue().toString().isEmpty()
                    || tfDatumEind.getValue().toString().isEmpty()) {
                ErrorScreen.display("Velden", "Niet alle velden zijn ingevuld");
            } else {

                double stroomInKwh = Double.parseDouble(tfStroomPerkwh.getText());
                double gasPerM3 = Double.parseDouble(tfGasPerM3.getText());
                LocalDate startPeriode = tfDatumStart.getValue();
                LocalDate eindPeriode = tfDatumEind.getValue();

                Verbruik verbruik = new Verbruik(stroomInKwh, gasPerM3, startPeriode, eindPeriode);

                controller.addVerbruikToDB(verbruik);
            }
        });
//      btnKlantRegScreen navigeert naar het KlantRegScreen
        btnKlantRegScreen.setOnAction(goToKlant -> {
            HelloApplication.stage.setScene(new KlantRegScreen(HelloApplication.stage).getKlantReg());
        });
//      btnTariefScreen navigeert naar het TarievenScreen
        btnTariefScreen.setOnAction(goToTarief -> {
            HelloApplication.stage.setScene(new TarievenScreen().getTarievenScene());
        });
//      btnWekelijksVerbruik navigeert naar het WekelijkVerbruikScreen
        btnWekelijksVerbruik.setOnAction(wekelijkVerbruikScreen -> {
            HelloApplication.stage.setScene(new WekelijkVerbruikScreen().getWekelijkVerbruik());
        });
//      Scene wordt aangemaakt en de container met alle content wordt toegevoegd.
        verbruikScene = new Scene(container);
        //        Stylesheet wordt gekoppeld.
        verbruikScene.getStylesheets().add(HelloApplication.class.getResource("stylesheet/stylesheet.css").toString());
        //        container wordt gevuld met de GridPane met alle Labels en Buttons
        container.getChildren().add(verbruikGrid);
    }
    //      De methode returned de verbruikScene.
    public Scene getVerbruikScreen() {
        return verbruikScene;
    }
}


