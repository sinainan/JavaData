package data;

public class Inschrijvingen {

    private int inschrijving_nr, speler_nr, toernooi_nr;
    private boolean betaald;

    public Inschrijvingen(int inschrijving_nr, int speler_nr, int toernooi_nr, boolean betaald){
        this.inschrijving_nr = inschrijving_nr;
        this.speler_nr = speler_nr;
        this.toernooi_nr = toernooi_nr;
        this.betaald = betaald;

    }

    public int getInschrijving_nr() {
        return inschrijving_nr;
    }

    public int getSpeler_nr() {
        return speler_nr;
    }

    public int getToernooi_nr() {
        return toernooi_nr;
    }

    public boolean isBetaald() {
        return betaald;
    }
}
