package hu.unideb.inf;

import javax.persistence.*;

@Entity
@Table(name = "orders") //tábla nevének megváltoztatása
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //az id generálás egyesével növekszik
    public int id;

    //@Column(nullable = false) //nem lehet NULL érték(muszáj filmet választani a hitelesítéshez)
    public String film_cim;
    public String ulo_hely;
    public String dp;
    public String idopont;
    public String etel_ital;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilm_cim() {
        return film_cim;
    }

    public void setFilm_cim(String film_cim) {
        this.film_cim = film_cim;
    }

    public String getUlo_hely() {
        return ulo_hely;
    }

    public void setUlo_hely(String ulo_hely) {
        this.ulo_hely = ulo_hely;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getIdopont() {
        return idopont;
    }

    public void setIdopont(String idopont) {
        this.idopont = idopont;
    }

    public String getEtel_ital() {
        return etel_ital;
    }

    public void setEtel_ital(String etel_ital) {
        this.etel_ital = etel_ital;
    }

    public Order(String film_cim, String ulo_hely, String dp, String idopont, String etel_ital) {
        this.film_cim = film_cim;
        this.ulo_hely = ulo_hely;
        this.dp = dp;
        this.idopont = idopont;
        this.etel_ital = etel_ital;
    }

    public Order() {

    }
}
