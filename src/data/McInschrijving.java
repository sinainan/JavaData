package data;

public class McInschrijving {
    private int inschrijving_nr, speler_nr, class_nr;
    private boolean betaald;

    public McInschrijving(int inschrijving_nr, boolean betaald, int speler_nr, int class_nr){

        this.inschrijving_nr = inschrijving_nr;
        this.speler_nr = speler_nr;
        this.class_nr = class_nr;
        this.betaald = betaald;

    }

    public int getInschrijving_nr() {
        return inschrijving_nr;
    }

    public int getSpeler_nr() {
        return speler_nr;
    }

    public int getClass_nr() {
        return class_nr;
    }

    public boolean isBetaald() {
        return betaald;
    }
}
