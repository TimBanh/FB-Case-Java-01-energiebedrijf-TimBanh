package com.example.fbcasejava01energiebedrijftimbanh.controllers;

import com.example.fbcasejava01energiebedrijftimbanh.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
// Controller klasse die alle logica en berekeningen handelt.
public class HelloController {
    // Arraylist van objecten om de objecten op te slaan.
    private ArrayList<Klant>klantenLijst = new ArrayList<Klant>();
    private ArrayList<Energie> energieTarieven = new ArrayList<Energie>();
    private ArrayList<Verbruik> verbruikLijst = new ArrayList<Verbruik>();
    private double wekelijkVerbruik;
    //Methode om Klant objecten toe te voegen aan de "klantelijst" ArrayList
    public void addKlantToList(Klant klant){
        // Checkt of de klantenlijst leeg is. Zo ja, wordt het Klant object gelijk toegevoegd
        if (klantenLijst.isEmpty()) {
            klantenLijst.add(klant);
            System.out.println(klantenLijst);
            return;
        }
        // Checkt alle Klant objecten in de klantenlijst op Klantnummer om te kijken of de klant al bestaat. Zo niet, wordt deze toegevoegd aan de ArrayList.
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
    // Methode om Gas objecten toe te voegen aan de "energieTarieven" ArrayList
    public void addGasToEnergyTarieven(Gas gas) {
        // Checkt of de energieTarieven ArrayList leeg. Zo ja, wordt het Gas object gelijk toegevoegd
        if (energieTarieven.isEmpty()) {
            energieTarieven.add(gas);
            System.out.println(energieTarieven);
            return;
        }
        //Checkt alle Energie objecten in energieTarieven of het een Gas object is en of de datums overeen komen. Zo ja, worden er aangegeven dat het Gas object al bestaat.
        for (Energie energies : energieTarieven) {
            if (energies instanceof Gas && gas.getBeginDatum().equals(energies.getBeginDatum()) && gas.getEindDatum().equals(energies.getEindDatum())) {
                System.out.println("Gas bestaat al");
                return;
            }
        }
        // Als het Gas object nog niet bestaat, wordt het toegevoegd aan energieTarieven.
        energieTarieven.add(gas);
        System.out.println(energieTarieven);
    }
    // Methode om Stroom objecten toe te voegen aan de "energieTarieven" ArrayList
    public void addStroomToEnergyTarieven(Stroom stroom) {
        // Checkt of de energieTarieven ArrayList leeg. Zo ja, wordt het Stroom object gelijk toegevoegd
        if (energieTarieven.isEmpty()) {
            energieTarieven.add(stroom);
            System.out.println(energieTarieven);
            return;
        }
        //Checkt alle Energie objecten in energieTarieven of het een Stroom object is en of de datums overeen komen. Zo ja, worden er aangegeven dat het Stroom object al bestaat.
        for (Energie energies : energieTarieven) {
            if (energies instanceof Gas && stroom.getBeginDatum().equals(energies.getBeginDatum()) && stroom.getEindDatum().equals(energies.getEindDatum())) {
                System.out.println("Stroom bestaat al");
                return;
            }
        }
        // Als het Stroom object nog niet bestaat, wordt het toegevoegd aan energieTarieven.
        energieTarieven.add(stroom);
        System.out.println(energieTarieven);
    }
    // Methode om Verbruik objecten toe te voegen aan de verbruikLijst ArrayList.
    public void addVerbruikToList(Verbruik verbruik){
        // Checkt of de verberuikLijst ArrayList leeg. Zo ja, wordt het Verbruik object gelijk toegevoegd
        if (verbruikLijst.isEmpty()) {
            verbruikLijst.add(verbruik);
            System.out.println(verbruikLijst);
            return;
        }
        //Checkt alle Verbruik objecten in de verbruikLijst op beginDatum en eindDatum om te kijken of het object al bestaat. Zo ja, worden er aangegeven dat het Stroom object al bestaat.
        for (Verbruik verbruiken: verbruikLijst) {
            if (verbruik.getBegindatum() == verbruiken.getBegindatum() && verbruik.getEindDatum() == verbruiken.getEindDatum()) {
                System.out.println("Verbruik bestaat al");
            } else {
                // Als het object nog niet bestaat, wordt het toegevoegd aan de verbruikLijst
                verbruikLijst.add(verbruik);
                System.out.println(verbruikLijst);
                break;
            }
        }
    }
    // Methode om Klant objecten te vinden door te filteren op klantnummer
    public Klant getKlantByNumber(int klantNummer) {
        // Als de klantenLijst leeg is, wordt dit aangegeven.
        if (klantenLijst.isEmpty()) {
            System.out.println("Klantenlijst is leeg");
        } else {
            // klantenLijst wordt gefilterd op klantNummer en returned de klant als die gevonden is.
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


    // Methode om Gas objecten te filteren op beginDatum en eindDatum
    public Gas getGasTariefByWeek(LocalDate begindatum, LocalDate eindDatum) {
        // Als energieTarieven leeg is, wordt dit aangegeven.
        if (energieTarieven.isEmpty()) {
            System.out.println("Energie tarieven is leeg");
        }
        // Er wordt een nieuwe ArrayList gemaakt voor alleen Gas objecten.
        ArrayList<Gas> gases = new ArrayList<>();
        // Er wordt gefilterd op Gas objecten en die worden aan de nieuwe ArrayList toegevoegd
        for (Energie energie: energieTarieven) {
            if (energie instanceof Gas) {
                gases.add((Gas)energie);
            }
        }
        // Er wordt gefilterd door de nieuwe ArrayList op beginDatum en eindDatum om het juiste object te vinden en die wordt dan returned.
        for (Gas gas: gases) {
            if (gas.getBeginDatum().equals(begindatum) && gas.getEindDatum().equals(eindDatum)) {
                return gas;
            }
        }

        System.out.println("Niet gevonden");
        return null;
    }
    // Zelfde methode als getGasTariefByWeek maar dan voor Stroom objecten.
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
    // Methode om Verbruik objecten te vinden in de verbruikLijst op basis van beginDatum en eindDatum.
    public Verbruik getVerbruikByWeek(LocalDate beginDatum, LocalDate eindDatum) {
        // Als verbruikLijst leeg is,wordt dit aangegeven.
        if (verbruikLijst.isEmpty()) {
            System.out.println("Verbruik is leeg");
        }
        // Er wordt door de verbruikLijst gefilterd op beginDatum en eindDatum en dat Verbruik object wordt returned.
        for (Verbruik verbruik: verbruikLijst) {
            if (verbruik.getBegindatum().equals(beginDatum) && verbruik.getEindDatum().equals(eindDatum)) {
                return verbruik;
            }
        }
        // Als he Verbruik object niet gevonden is, wordt dit aangegeven.
        System.out.println("Verbruik niet gevonden");
        return null;
    }
    // Methode om het wekelijks Verbruik te berekenen van de klant.
    public double calculateWekelijksVerbruik (LocalDate beginDatum, LocalDate eindDatum, int klantNummer) {
        // Alle objecten en attributen worden eerst aangemaakt.
        Verbruik verbruik = getVerbruikByWeek(beginDatum,eindDatum);
        Gas gas = getGasTariefByWeek(beginDatum,eindDatum);
        Stroom stroom = getStroomTariefByWeek(beginDatum,eindDatum);
        Klant klant = getKlantByNumber(klantNummer);
        double klantJaOverschot = klant.getJaOverschot();
        double wekelijkGasVerbruik = verbruik.getGasPerM3() * gas.getTarief();
        double wekelijkStroomVerbruik = verbruik.getStroomPerkwh() * stroom.getTarief();
        // Het wekelijkVerbruik wordt hier berekent.
        wekelijkVerbruik = wekelijkGasVerbruik + wekelijkStroomVerbruik;
        // Als het wekelijkVerbruik onder het jaar overschot van de Klant zit, wordt dit aangeven.
        if (wekelijkVerbruik <= klant.getJaOverschot()) {
            System.out.println("Klant verbruik is onder het jaar overschot");
            return wekelijkVerbruik;
        }
        // Als het wekelijkVerbruik boven het jaar overschot zit, wordt dit aangegeven.
        System.out.println("Klant verbruik is hoger dan het jaar overschot");
        return wekelijkVerbruik;
    }
}