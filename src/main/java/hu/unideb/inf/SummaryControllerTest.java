package hu.unideb.inf;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SummaryControllerTest {

    private SummaryController summaryController;
    private Order order;
    private MainApp mainapp;

    @BeforeAll
    static void start(){System.out.println("Starting testing ...");}

    @BeforeEach
    void setup(){
        this.summaryController = new SummaryController() ;
        this.order = new Order();
        this.mainapp = new MainApp();
        mainapp.order.setFilm_cim("Deadpool");
    }


    @org.junit.jupiter.api.Test
    void backToMealPushed() {
    }

    @org.junit.jupiter.api.Test
    void nextToEndScenePushed() {
    }

    @org.junit.jupiter.api.Test
    void initialize() {
    }

    @org.junit.jupiter.api.Test
    void terem( ) {
        String expected = "1";
        String actual;
        actual = summaryController.Terem("Deadpool");
        System.out.println(actual+" "+expected);
        assertEquals(expected,actual);

    }
}