package com.example.fbcasejava01energiebedrijftimbanh.models;

import java.time.LocalDate;
import java.util.Date;

public class Gas extends Energie {

    public Gas(double tarief, LocalDate beginDatum, LocalDate eindDatum) {
        super(tarief, beginDatum, eindDatum);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
