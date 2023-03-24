package com.example.fbcasejava01energiebedrijftimbanh.controllers;

import com.example.fbcasejava01energiebedrijftimbanh.models.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class HelloController {
    private ArrayList<Klant>klantenLijst = new ArrayList<Klant>();
    private ArrayList<Energie> energieTarieven = new ArrayList<Energie>();
    private ArrayList<Verbruik> verbruikLijst = new ArrayList<Verbruik>();
    private double wekelijkVerbruik;

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

    public Stroom getStroomTariefByWeek(LocalDate begindatum, LocalDate eindDatum) {
        if (energieTarieven.isEmpty()) {
            System.out.println("Energie tarieven is leeg");
        }

        ArrayList<Stroom> stromen = new ArrayList<>();

        for (Energie energie: energieTarieven) {
            if (energie instanceof Stroom) {
                stromen.add((Stroom) energie);
            }
        }

        for (Stroom stroom: stromen) {
            if (stroom.getBeginDatum().equals(begindatum) && stroom.getEindDatum().equals(eindDatum)) {
                return stroom;
            }
        }

        System.out.println("Niet gevonden");
        return null;
    }

    public Verbruik getVerbruikByWeek(LocalDate beginDatum, LocalDate eindDatum) {
        if (verbruikLijst.isEmpty()) {
            System.out.println("Verbruik is leeg");
        }

        for (Verbruik verbruik: verbruikLijst) {
            if (verbruik.getBegindatum().equals(beginDatum) && verbruik.getEindDatum().equals(eindDatum)) {
                return verbruik;
            }
        }

        System.out.println("Verbruik niet gevonden");
        return null;
    }

    public double calculateWekelijksVerbruik (LocalDate beginDatum, LocalDate eindDatum, int klantNummer) {
        Verbruik verbruik = getVerbruikByWeek(beginDatum,eindDatum);
        Gas gas = getGasTariefByWeek(beginDatum,eindDatum);
        Stroom stroom = getStroomTariefByWeek(beginDatum,eindDatum);
        Klant klant = getKlantByNumber(klantNummer);
        double klantJaOverschot = klant.getJaOverschot();
        double wekelijkGasVerbruik = verbruik.getGasPerM3() * gas.getTarief();
        double wekelijkStroomVerbruik = verbruik.getStroomPerkwh() * stroom.getTarief();

        wekelijkVerbruik = klantJaOverschot - (wekelijkGasVerbruik + wekelijkStroomVerbruik);

        if (wekelijkVerbruik <= klant.getJaOverschot()) {
            System.out.println("Klant verbruik is onder het jaar overschot");
            return wekelijkVerbruik;
        }

        System.out.println("Klant verbruik is hoger dan het jaar overschot");
        return wekelijkVerbruik;
    }
}