package data;

import java.util.Date;

public class masterclassRegisteren {

    private String naam, begin_tijd , eind_tijd ;
    private int niveau , class_nr , rating, locatie_id;
    private double prijs;
    private Date datum;

    public masterclassRegisteren(int class_nr, int rating, String naam, double prijs, Date datum, String begin_tijd, String eind_tijd, int locatie_id) {
        this.naam = naam;
        this.begin_tijd = begin_tijd;
        this.eind_tijd = eind_tijd;
        this.class_nr = class_nr;
        this.rating = rating;
        this.locatie_id = locatie_id;
        this.prijs = prijs;
        this.datum = datum;
    }

    public String getNaam() {
        return naam;
    }

    public String getBegin_tijd() {
        return begin_tijd;
    }

    public String getEind_tijd() {
        return eind_tijd;
    }


    public int getClass_nr() {
        return class_nr;
    }

    public int getRating() {
        return rating;
    }

    public int getLocatie_id() {
        return locatie_id;
    }

    public double getPrijs() {
        return prijs;
    }

    public Date getDatum() {
        return datum;
    }
}
