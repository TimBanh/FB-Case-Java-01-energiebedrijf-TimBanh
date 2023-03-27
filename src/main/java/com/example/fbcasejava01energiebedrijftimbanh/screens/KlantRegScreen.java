package com.example.fbcasejava01energiebedrijftimbanh.screens;

import com.example.fbcasejava01energiebedrijftimbanh.HelloApplication;
import com.example.fbcasejava01energiebedrijftimbanh.controllers.HelloController;
import com.example.fbcasejava01energiebedrijftimbanh.models.Klant;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KlantRegScreen {
    private final Scene klantRegScene; // De scene wordt aangemaakt;
    private HelloController controller = HelloApplication.controller; //Shortcut naar de controller die gemaakt is in de HelloAplication class

    public KlantRegScreen (Stage stage) {
//        Container wordt gemaakt om content er in te zetten.
        Pane container = new Pane();
        container.setPrefWidth(1200);
        container.setPrefHeight(650);
        container.setStyle("-fx-background-color: grey");
//      Gridpane wordt gemaakt voor de layout
        GridPane gridPane = new GridPane();
        gridPane.setId("gridPane");
        gridPane.setPrefWidth(HelloApplication.globalWidth-15);
        gridPane.setPrefHeight(HelloApplication.globalHeight-30);
//      Alle labels om een klant te maken worden aangemaakt.
        Label lblKlantNumer = new Label("Klantnummer: ");
        TextField tfKlantNummer = new TextField();

        Label lblVoornaam = new Label("Voornaam: ");
        TextField tfVoornaam = new TextField();

        Label lblAchternaam = new Label("Achternaam: ");
        TextField tfAchternaam = new TextField();

        Label lblJaVoorschot = new Label("Jaar voorschot: ");
        TextField tfJaVoorschot = new TextField();
//      Buttons om een klant aan te maken en te navigeren tussen schermen
        Button sendKlantInfo = new Button("Zend");
        Button btnTariefScreen = new Button("Tarieven");
        Button btnVebruikScreen = new Button("Verbruik");
        Button btnWekelijksVerbruik = new Button("Wekelijks Verbruik");
//      Alle labels en buttons worden aan de GridPane toegevoegd
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
        gridPane.add(btnVebruikScreen,2,4);
        gridPane.add(btnWekelijksVerbruik,3,4);
//      Alle content in de GridPane wordt gecentreerd.
        gridPane.setAlignment(Pos.CENTER);
//      Button sendKlantInfo checkt of alle velden ingevuld zijn en voegt een klant toe in een ArrayList als alle gegevens ingevuld zijn.
        sendKlantInfo.setOnAction(regKlant-> {
            if (tfKlantNummer.getText().isEmpty()
                    || tfVoornaam.getText().isEmpty()
                    || tfAchternaam.getText().isEmpty()
                    || tfJaVoorschot.getText().isEmpty()) {
                ErrorScreen.display("Velden", "Niet alle velden zijn ingevuld");
            } else {
                int klantNr = Integer.parseInt(tfKlantNummer.getText());
                String voorNm = tfVoornaam.getText();
                String achterNm = tfAchternaam.getText();
                double jaarlijkVoorschot = Double.parseDouble(tfJaVoorschot.getText());

                Klant klant = new Klant(klantNr, voorNm, achterNm, jaarlijkVoorschot);
                controller.addKlantToList(klant);
            }
        });
//      btnTariefScreen navigeert naar het TarievenScreen
        btnTariefScreen.setOnAction(goToTarief -> {
            HelloApplication.stage.setScene(new TarievenScreen().getTarievenScene());
        });
//      btnVerbruikScreen navigeert naar het VerbruikScreen
        btnVebruikScreen.setOnAction(goToVerbuik -> {
            HelloApplication.stage.setScene(new VerbruikScreen().getVerbruikScreen());
        });
//        btnWekelijksVerbruikScreen navigeert naar het WekelijkVerbruikScreen
        btnWekelijksVerbruik.setOnAction(wekelijkVerbruikScreen -> {
            HelloApplication.stage.setScene(new WekelijkVerbruikScreen().getWekelijkVerbruik());
        });
//      Scene wordt aangemaakt en de container met alle content wordt toegevoegd.
        klantRegScene = new Scene(container);
//        Stylesheet wordt gekoppeld.
        klantRegScene.getStylesheets().add(HelloApplication.class.getResource("stylesheet/stylesheet.css").toString());
//        container wordt gevuld met de GridPane met alle Labels en Buttons
        container.getChildren().add(gridPane);
    }
//      De methode returned de klantRegScene.
    public Scene getKlantReg() {
        return klantRegScene;
    }
}


