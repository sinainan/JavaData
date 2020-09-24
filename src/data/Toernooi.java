package data;

import org.omg.CORBA.DATA_CONVERSION;

import java.util.Date;

public class Toernooi{

    public String naam;
    public double toernooi_prijs;
    public String thema, begin_tijd, zaalNaam;
    public Date datum;
    public int max_aantalspeler;
    public int type;
    public int toernooi_nr;
    public String eind_tijd;


    public Toernooi(int toernooi_nr, String naam, double toernooi_prijs, int type, int max_aantalspeler, String thema, Date datum, String begin_tijd, String eind_tijd, String zaalNaam){

        this.toernooi_nr = toernooi_nr;
        this.naam = naam;
        this.toernooi_prijs = toernooi_prijs;
        this.type = type;
        this.max_aantalspeler = max_aantalspeler;
        this.thema = thema;
        this.datum = datum;
        this.begin_tijd = begin_tijd;
        this.zaalNaam = zaalNaam;
        this.eind_tijd = eind_tijd;

    }

    public String getNaam() {
        return naam;
    }

    public double getToernooi_prijs() {
        return toernooi_prijs;
    }

    public String getThema() {
        return thema;
    }

    public String getBegin_tijd() {
        return begin_tijd;
    }

    public String getZaalNaam() {
        return zaalNaam;
    }

    public Date getDatum() {
        return datum;
    }

    public int getMax_aantalspeler() {
        return max_aantalspeler;
    }

    public int getType() {
        return type;
    }

    public int getToernooi_nr() {
        return toernooi_nr;
    }

    public String getEind_tijd() {
        return eind_tijd;
    }
}
