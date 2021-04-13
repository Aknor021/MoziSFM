package hu.unideb.inf;

import java.util.Date;

public class Order {
    public String ID;
    public String FILM;
    public String ULO_HELY;
    public Date DATE ;
    public String MEAL;

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getFILM() {
        return FILM;
    }

    public void setFILM(String FILM) {
        this.FILM = FILM;
    }

    public String getULO_HELY() {
        return ULO_HELY;
    }

    public void setULO_HELY(String ULO_HELY) {
        this.ULO_HELY = ULO_HELY;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    public String getMEAL() {
        return MEAL;
    }

    public void setMEAL(String MEAL) {
        this.MEAL = MEAL;
    }

    public Order(String ID, String FILM, String ULO_HELY, Date DATE, String MEAL) {
        this.ID = ID;
        this.FILM = FILM;
        this.ULO_HELY = ULO_HELY;
        this.DATE = DATE;
        this.MEAL = MEAL;
    }
}
