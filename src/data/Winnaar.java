package data;

public class Winnaar {
    private int winnaar_id , tafel_nr , ronde_nr , speler_nr , toernooi_nr ;
    private double gewonnen_prijs ;

    public Winnaar(int winnaar_id, double gewonnen_prijs, int tafel_nr, int ronde_nr, int speler_nr, int toernooi_nr) {
        this.winnaar_id = winnaar_id;
        this.tafel_nr = tafel_nr;
        this.ronde_nr = ronde_nr;
        this.speler_nr = speler_nr;
        this.toernooi_nr = toernooi_nr;
        this.gewonnen_prijs = gewonnen_prijs;
    }

    public int getWinnaar_id() {
        return winnaar_id;
    }

    public int getTafel_nr() {
        return tafel_nr;
    }

    public int getRonde_nr() {
        return ronde_nr;
    }

    public int getSpeler_nr() {
        return speler_nr;
    }

    public int getToernooi_nr() {
        return toernooi_nr;
    }

    public double getGewonnen_prijs() {
        return gewonnen_prijs;
    }
}
