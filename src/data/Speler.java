package data;

public class Speler {

    public String naam, adres, woonplaats, postcode, tel_nrm, geb_datum, geslacht, email;
    public int speler_nr, rating;
    public boolean mc_leraar;

    public Speler(int speler_nr, String naam, String adres, String woonplaats, String postcode, String tel_nrm, String email, String geb_datum, int rating, String geslacht, boolean mc_leraar){

        this.speler_nr = speler_nr;
        this.naam = naam;
        this.adres = adres;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
        this.tel_nrm = tel_nrm;
        this.email = email;
        this.geb_datum = geb_datum;
        this.geslacht = geslacht;
        this.rating = rating;
        this.mc_leraar =mc_leraar;

    }

    public int getSpeler_nr(){
        return this.speler_nr;
    }

    public String getNaam(){
        return this.naam;
    }

    public String getAdres(){
        return this.adres;
    }

    public String getWoonplaats() {
        return this.woonplaats;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getTel_nrm() {
        return this.tel_nrm;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGeb_datum() {
        return this.geb_datum;
    }

    public String getGeslacht() {
        return this.geslacht;
    }

    public int getRating() {
        return this.rating;
    }

    public boolean isMc_leraar() {
        return mc_leraar;
    }
}
