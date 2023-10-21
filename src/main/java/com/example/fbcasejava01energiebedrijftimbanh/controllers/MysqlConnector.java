package com.example.fbcasejava01energiebedrijftimbanh.controllers;

import com.example.fbcasejava01energiebedrijftimbanh.models.Energie;
import com.example.fbcasejava01energiebedrijftimbanh.models.Gas;
import com.example.fbcasejava01energiebedrijftimbanh.models.Klant;
import com.example.fbcasejava01energiebedrijftimbanh.models.Stroom;

import java.sql.*;
import java.util.ArrayList;

public class MysqlConnector {
    private Connection connection;

    public MysqlConnector() {
        String user = "root";
        String pass = "";
        String cString = "jdbc:mysql://localhost:3306/energiebedrijf?user=" + user + "&password="+ pass;

        try {
            this.connection = DriverManager.getConnection(cString);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Kan geen verbinding maken");
        }
    }

    public void addKlant(Klant klant) {
        String query =  "INSERT INTO klant VALUES ("+klant.getKlantnummer()+", '"+klant.getVoornaam()+"', '"+klant.getAchternaam()+"', "+klant.getJaOverschot()+")";

        try {
            Statement stm = connection.createStatement();
            stm.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Klant> getAllKlanten() {
        String query = "SELECT * FROM klant";
        ArrayList<Klant> klantenLijst = new ArrayList<>();

        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                Klant klant = new Klant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
                klantenLijst.add(klant);
            }
            System.out.println(klantenLijst);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return klantenLijst;
    }

    public void deleteKlant(Klant klant) {
        String query = "DELETE FROM klant WHERE klantnummer = " +klant.getKlantnummer();

        try {
            Statement stm = connection.createStatement();
            stm.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEnergie(Energie energie, String energyType) {
        Date fBeginDatum = Date.valueOf(energie.getBeginDatum());
        Date fEindDatum = Date.valueOf(energie.getEindDatum());
        String query =  "INSERT INTO energie (tarief, begin_datum, eind_datum, soort) VALUES ("+energie.getTarief()+", '"+fBeginDatum+"', '"+fEindDatum+"', '"+energyType+"')";

        try {
            Statement stm = connection.createStatement();
            stm.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Energie> getAllEnergie() {
        String query = "SELECT * FROM energie";
        ArrayList<Energie> energieLijst = new ArrayList<>();

        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
               if (resultSet.getString(5).equals("gas")) {
                   Gas gas = new Gas(resultSet.getDouble(2), resultSet.getDate(3).toLocalDate(), resultSet.getDate(4).toLocalDate());
                   energieLijst.add(gas);
               } else if (resultSet.getString(5).equals("stroom")) {
                   Stroom stroom = new Stroom(resultSet.getDouble(2), resultSet.getDate(3).toLocalDate(), resultSet.getDate(4).toLocalDate());
                   energieLijst.add(stroom);
               }
            }
            System.out.println(energieLijst);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return energieLijst;
    }
}
