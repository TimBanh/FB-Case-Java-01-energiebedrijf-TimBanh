package com.example.fbcasejava01energiebedrijftimbanh.controllers;

import com.example.fbcasejava01energiebedrijftimbanh.models.Energie;
import com.example.fbcasejava01energiebedrijftimbanh.models.Klant;
import com.example.fbcasejava01energiebedrijftimbanh.models.Verbruik;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {
    private ArrayList<Klant>klantenLijst = new ArrayList<Klant>();
    private ArrayList<Energie> energieTarieven = new ArrayList<Energie>();
    private ArrayList<Verbruik> verbuikLijst = new ArrayList<Verbruik>();

    public void addKlantToList(Klant klant){
        if (klantenLijst.isEmpty()) {
            klantenLijst.add(klant);
            System.out.println(klantenLijst);
            return;
        }

        for (Klant klanten: klantenLijst) {
            if (klant.getKlantnummer() == klanten.getKlantnummer()) {
                System.out.println("Klant bestaat al");
            } else {
                klantenLijst.add(klant);
                System.out.println(klantenLijst);
                break;
            }
        }
    }

    public void addEnegieToList(Energie energie){
        if (energieTarieven.isEmpty()) {
            energieTarieven.add(energie);
            System.out.println(energieTarieven);
            return;
        }

        for (Energie energies: energieTarieven) {
            if (energie.getBeginDatum() == energies.getBeginDatum() && energie.getEindDatum() ==energies.getEindDatum()) {
                System.out.println("Energie bestaat al");
            } else {
                energieTarieven.add(energie);
                System.out.println(energieTarieven);
                break;
            }
        }
    }
}