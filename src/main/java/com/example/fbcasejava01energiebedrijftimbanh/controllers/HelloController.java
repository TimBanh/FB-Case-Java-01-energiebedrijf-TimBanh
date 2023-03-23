package com.example.fbcasejava01energiebedrijftimbanh.controllers;

import com.example.fbcasejava01energiebedrijftimbanh.models.Energie;
import com.example.fbcasejava01energiebedrijftimbanh.models.Gas;
import com.example.fbcasejava01energiebedrijftimbanh.models.Klant;
import com.example.fbcasejava01energiebedrijftimbanh.models.Verbruik;

import java.time.LocalDate;
import java.util.ArrayList;

public class HelloController {
    private ArrayList<Klant>klantenLijst = new ArrayList<Klant>();
    private ArrayList<Energie> energieTarieven = new ArrayList<Energie>();
    private ArrayList<Verbruik> verbruikLijst = new ArrayList<Verbruik>();

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

    public void addEnergieToList(Energie energie){
        if (energieTarieven.isEmpty()) {
            energieTarieven.add(energie);
            System.out.println(energieTarieven);
            return;
        }

        for (Energie energies: energieTarieven) {
            if (energie.getBeginDatum() == energies.getBeginDatum() && energie.getEindDatum() == energies.getEindDatum()) {
                System.out.println("Energie bestaat al");
            } else {
                energieTarieven.add(energie);
                System.out.println(energieTarieven);
                break;
            }
        }
    }

    public void addVerbruikToList(Verbruik verbruik){
        if (verbruikLijst.isEmpty()) {
            verbruikLijst.add(verbruik);
            System.out.println(verbruikLijst);
            return;
        }

        for (Verbruik verbruiken: verbruikLijst) {
            if (verbruik.getBegindatum() == verbruiken.getBegindatum() && verbruik.getEindDatum() == verbruiken.getEindDatum()) {
                System.out.println("Verbruik bestaat al");
            } else {
                verbruikLijst.add(verbruik);
                System.out.println(verbruikLijst);
                break;
            }
        }
    }

    public Klant getKlantByNumber(int klantNummer) {
        if (klantenLijst.isEmpty()) {
            System.out.println("Klantenlijst is leeg");
        } else {
            for (Klant klant : klantenLijst) {
                if (klant.getKlantnummer() == klantNummer) {
                    return klant;
                } else {
                    System.out.println("Klant niet gevonden");
                }
            }
        }
        return null;
    }

    public Energie getGasTariefByWeek(LocalDate begindatum, LocalDate eindDatum) {
        if (energieTarieven.isEmpty()) {
            System.out.println("Klantenlijst is leeg");
        } else {
            for (Energie energie : energieTarieven) {
                if (energie.getBeginDatum().equals(begindatum) && energie.getEindDatum().equals(eindDatum)) {
                    Gas gas = energie;
                    return energie;
                } else {
                    System.out.println("Niet gevonden");
                }
            }
        }
        return null;
    }
}