package data;

public class Locatie {
    private String zaal_naam , adres , postcode, plaats ;
    private int Locatie_id , aantal_stoelen , aantal_tafels;

    public Locatie(int locatie_id, String zaal_naam, String adres, String postcode, String plaats, int aantal_stoelen, int aantal_tafels) {
        this.zaal_naam = zaal_naam;
        this.adres = adres;
        this.postcode = postcode;
        this.plaats = plaats;
        this.Locatie_id = locatie_id;
        this.aantal_stoelen = aantal_stoelen;
        this.aantal_tafels = aantal_tafels;

    }

    public String getZaal_naam() {
        return zaal_naam;
    }

    public String getAdres() {
        return adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPlaats() {
        return plaats;
    }

    public int getLocatie_id() {
        return Locatie_id;
    }

    public int getAantal_stoelen() {
        return aantal_stoelen;
    }

    public int getAantal_tafels() {
        return aantal_tafels;
    }
}
