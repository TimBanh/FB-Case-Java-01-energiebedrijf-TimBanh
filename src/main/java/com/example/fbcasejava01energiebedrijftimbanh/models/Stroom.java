package com.example.fbcasejava01energiebedrijftimbanh.models;

import java.time.LocalDate;
import java.util.Date;
    //Stroom is een subclass van Energie
public class Stroom extends Energie {
    // constructor die overgenomen is van de superclass Energie
    public Stroom(double tarief, LocalDate beginDatum, LocalDate eindDatum) {
        super(tarief, beginDatum, eindDatum);
    }
    // toString die overgenomen is van de superclass Energie
    @Override
    public String toString() {
        return super.toString();
    }
}
