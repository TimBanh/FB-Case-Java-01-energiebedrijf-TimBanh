package com.example.fbcasejava01energiebedrijftimbanh.screens;

import com.example.fbcasejava01energiebedrijftimbanh.HelloApplication;
import com.example.fbcasejava01energiebedrijftimbanh.controllers.HelloController;
import com.example.fbcasejava01energiebedrijftimbanh.models.Energie;
import com.example.fbcasejava01energiebedrijftimbanh.models.Klant;
import com.example.fbcasejava01energiebedrijftimbanh.models.Verbruik;
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
    private final Scene wekelijkVerbruikScene; // De scene wordt aangemaakt
    private HelloController controller = HelloApplication.controller; //Shortcut naar de controller die gemaakt is in de HelloAplication class

    public WekelijkVerbruikScreen () {
        //        Container wordt gemaakt om content er in te zetten.
        Pane container = new Pane();
        container.setPrefWidth(1200);
        container.setPrefHeight(650);
        container.setStyle("-fx-background-color: Orange");
//      Gridpane wordt gemaakt voor de layout
        GridPane gridPane = new GridPane();
        gridPane.setId("wekelijkGrid");
        gridPane.setPrefWidth(HelloApplication.globalWidth-15);
        gridPane.setPrefHeight(HelloApplication.globalHeight-30);
//      Alle labels om het WekelijkVerbruik te berekenen worden aangemaakt.
        Label lblBeginDatum = new Label("Begin Datum: ");
        DatePicker tfBeginDatum = new DatePicker();

        Label lblEindDatum = new Label("Eind Datum: ");
        DatePicker tfEindDatum = new DatePicker();

        Label lblGetKlant = new Label("Kies een klantnummer: ");
        TextField tfGetKlant = new TextField();

        Label lblKlantNaam = new Label("Klantnaam: ");
        Label lblKlantNaamResult = new Label();

        Label lblKlantVoorschot = new Label("Voorschot");
        Label lblKlantVoorschotResult = new Label();

        Label lblGasTarief = new Label("Gas Tarief: ");
        Label lblGasTariefResult = new Label();

        Label lblStroomTarief = new Label("Stroom Tarief: ");
        Label lblStroomTariefResult = new Label();

        Label lblVerbruikGas = new Label("Verbruik gas: ");
        Label lblVerbruikGasResult = new Label();

        Label lblVerbruikStroom = new Label("Verbruik gas: ");
        Label lblVerbruikStroomResult = new Label();

        Label lblWekelijkVerbruik = new Label("Wekelijk Verbruik: ");
        Label lblWekelijkVerbruikResult = new Label();

        Label lblStatusWekelijkVerbruik = new Label();
        lblStatusWekelijkVerbruik.setId("status");
//      Buttons om een klant te vinden en te navigeren tussen schermen
        Button btnGetWeek = new Button("Kies Week");
        Button btnKlantRegScreen = new Button("Klanten");
        Button btnTariefScreen = new Button("Tarieven");
        Button btnVebruikScreen = new Button("Verbruik");
//       Button om het WekelijkVerbruik te berekenen.
        Button btnCalcWekelijkVerbruik = new Button("Calculate");
//      Alle labels en buttons worden aan de GridPane toegevoegd
        gridPane.add(lblBeginDatum,0,0);
        gridPane.add(tfBeginDatum,1,0);
        gridPane.add(lblEindDatum,0,1);
        gridPane.add(tfEindDatum,1,1);
        gridPane.add(lblGetKlant,0,2);
        gridPane.add(tfGetKlant,1,2);
        gridPane.add(btnGetWeek,0,3);
        gridPane.add(lblKlantNaam,0,4);
        gridPane.add(lblKlantNaamResult,1,4);
        gridPane.add(lblVerbruikGas,2,4);
        gridPane.add(lblVerbruikGasResult,3,4);
        gridPane.add(lblKlantVoorschot,0,5);
        gridPane.add(lblKlantVoorschotResult,1,5);
        gridPane.add(lblVerbruikStroom,2,5);
        gridPane.add(lblVerbruikStroomResult,3,5);
        gridPane.add(lblGasTarief,0,6);
        gridPane.add(lblGasTariefResult,1,6);
        gridPane.add(lblWekelijkVerbruik,2,6);
        gridPane.add(lblWekelijkVerbruikResult,3,6);
        gridPane.add(lblStroomTarief,0,7);
        gridPane.add(lblStroomTariefResult,1,7);
        gridPane.add(lblStatusWekelijkVerbruik,2,7);
        gridPane.add(btnKlantRegScreen,0,8);
        gridPane.add(btnTariefScreen,1,8);
        gridPane.add(btnVebruikScreen,2,8);
        gridPane.add(btnCalcWekelijkVerbruik,0,9);
//      Alle content in de GridPane wordt gecentreerd.
        gridPane.setAlignment(Pos.CENTER);
//      btnGetWeek checkt eerst of alle velden ingevuld zijn, zo ja worden de Klant, Tarieven en Verbruik displayed op de Scene
        btnGetWeek.setOnAction(getClasses -> {
            if (tfGetKlant.getText().isEmpty()
                    || tfBeginDatum.getValue().toString().isEmpty()
                    || tfEindDatum.getValue().toString().isEmpty()) {
                ErrorScreen.display("Velden", "Niet alle velden zijn ingevuld");
            } else {
                int klantNummer = Integer.parseInt(tfGetKlant.getText());
                Klant selectedKlant = controller.getKlantByNumber(klantNummer);
                lblKlantNaamResult.setText(selectedKlant.getVoornaam() + " " + selectedKlant.getAchternaam());
                lblKlantVoorschotResult.setText(Double.toString(selectedKlant.getJaOverschot()));

                LocalDate begindatum = tfBeginDatum.getValue();
                LocalDate eindatum = tfEindDatum.getValue();

                Energie stroom = HelloApplication.controller.getStroomTariefByWeek(begindatum, eindatum);
                System.out.println(stroom);
                lblStroomTariefResult.setText(String.valueOf(stroom.getTarief()));

                Energie gas = HelloApplication.controller.getGasTariefByWeek(begindatum, eindatum);
                System.out.println(gas);
                lblGasTariefResult.setText(String.valueOf(gas.getTarief()));

                Verbruik verbruik = controller.getVerbruikByWeek(begindatum, eindatum);

                lblVerbruikGasResult.setText(Double.toString(verbruik.getGasPerM3()));
                lblVerbruikStroomResult.setText(Double.toString(verbruik.getStroomPerkwh()));
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
//      btnVerbruikScreen navigeert naar het VerbruikScreen
        btnVebruikScreen.setOnAction(goToVerbuik -> {
            HelloApplication.stage.setScene(new VerbruikScreen().getVerbruikScreen());
        });
//      btnCalcWekelijkVerbruik haalt eerst de gegevens van de week op
        btnCalcWekelijkVerbruik.setOnAction(calcVerbruik -> {
            int klantNummer = Integer.parseInt(tfGetKlant.getText());
            Klant klant = controller.getKlantByNumber(klantNummer);

            LocalDate begindatum = tfBeginDatum.getValue();
            LocalDate eindatum = tfEindDatum.getValue();
//      Het wekelijk verbruik wordt berekent en meegegeven als double
            double wekelijkVerbruik = controller.calculateWekelijksVerbruik(begindatum,eindatum,klantNummer);

            lblWekelijkVerbruikResult.setText(Double.toString(wekelijkVerbruik));
//      Als het wekelijkVerbruik onder het jaar overschot zit van de Klant wordt dit displayed in het groen, zo niet wordt dit displayed in het rood.
            if (wekelijkVerbruik <= klant.getJaOverschot()) {
                lblStatusWekelijkVerbruik.setText("Het verbruik zit onder het jaar overschot");
                lblStatusWekelijkVerbruik.setStyle("-fx-text-fill: Green");
            } else {
                lblStatusWekelijkVerbruik.setText("Het verbruik zit over het jaar overschot");
                lblStatusWekelijkVerbruik.setStyle("-fx-text-fill: Red");
            }
        });
//      Scene wordt aangemaakt en de container met alle content wordt toegevoegd.
        wekelijkVerbruikScene = new Scene(container);
        //        Stylesheet wordt gekoppeld.
        wekelijkVerbruikScene.getStylesheets().add(HelloApplication.class.getResource("stylesheet/stylesheet.css").toString());
        //        container wordt gevuld met de GridPane met alle Labels en Buttons
        container.getChildren().add(gridPane);
    }
    //      De methode returned de WekelijkVerbruikScreen.
    public Scene getWekelijkVerbruik() {
        return wekelijkVerbruikScene;
    }
}
