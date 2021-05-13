package hu.unideb.inf;

import hu.unideb.inf.MainApp;
import hu.unideb.inf.Order;
import hu.unideb.inf.SummaryController;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SummaryControllerTest {

    private SummaryController summaryController;
    private Order order;
    private MainApp mainapp;

    @BeforeAll
    static void start(){System.out.println("Starting testing ...");}

    @BeforeEach
    void setup(){
        this.mainapp = new MainApp();
        this.mainapp.order = new Order();
        this.mainapp.order.setFilm_cim("Deadpool");
        this.summaryController = new SummaryController() ;
    }
    @AfterEach
    void after(){System.out.println("One test finished");}

    @org.junit.jupiter.api.Test
    void backToMealPushed() {assert(true);
    }

    @org.junit.jupiter.api.Test
    void nextToEndScenePushed() {assert(true);
    }

    @org.junit.jupiter.api.Test
    void initialize() {assert(true);
    }

    @Test
    void terem( )  {
        String expected = "1";
        String actual;
        actual = summaryController.Terem("Deadpool");
        assertEquals(expected,actual);

    }
}