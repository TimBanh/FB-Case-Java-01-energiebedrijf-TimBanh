package com.example.fbcasejava01energiebedrijftimbanh.controllers;

import com.example.fbcasejava01energiebedrijftimbanh.models.*;

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

    public void addGasToEnergyTarieven(Gas gas) {
        if (energieTarieven.isEmpty()) {
            energieTarieven.add(gas);
            System.out.println(energieTarieven);
            return;
        }

        for (Energie energies : energieTarieven) {
            if (energies instanceof Gas && gas.getBeginDatum().equals(energies.getBeginDatum()) && gas.getEindDatum().equals(energies.getEindDatum())) {
                System.out.println("Gas bestaat al");
                return;
            }
        }

        energieTarieven.add(gas);
        System.out.println(energieTarieven);
    }

    public void addStroomToEnergyTarieven(Stroom stroom) {
        if (energieTarieven.isEmpty()) {
            energieTarieven.add(stroom);
            System.out.println(energieTarieven);
            return;
        }

        for (Energie energies : energieTarieven) {
            if (energies instanceof Gas && stroom.getBeginDatum().equals(energies.getBeginDatum()) && stroom.getEindDatum().equals(energies.getEindDatum())) {
                System.out.println("Stroom bestaat al");
                return;
            }
        }

        energieTarieven.add(stroom);
        System.out.println(energieTarieven);
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



    public Gas getGasTariefByWeek(LocalDate begindatum, LocalDate eindDatum) {
        if (energieTarieven.isEmpty()) {
            System.out.println("Energie tarieven is leeg");
        }

        ArrayList<Gas> gases = new ArrayList<>();

        for (Energie energie: energieTarieven) {
            if (energie instanceof Gas) {
                gases.add((Gas)energie);
            }
        }

        for (Gas gas: gases) {
            if (gas.getBeginDatum().equals(begindatum) && gas.getEindDatum().equals(eindDatum)) {
                return gas;
            }
        }

        System.out.println("Niet gevonden");
        return null;
    }

    public Energie getStroomTariefByWeek(LocalDate begindatum, LocalDate eindDatum) {
        if (energieTarieven.isEmpty()) {
            System.out.println("Energie tarieven is leeg");
        } else {
            for (Energie energie : energieTarieven) {
                if (energie instanceof Stroom && energie.getBeginDatum().equals(begindatum) && energie.getEindDatum().equals(eindDatum)) {
                    return energie;
                }
            }
        }
        System.out.println("Niet gevonden");
        return null;
    }
}