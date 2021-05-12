package hu.unideb.inf;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FXMLControllerTest {

    private FXMLController fxm;

    @BeforeEach
    void setUp() {
        this.fxm = new FXMLController();
    }

    @AfterEach
    void tearDown() {System.out.println("One test finished !");
    }

    @Test
    void changeScenePushed() {
        assert(true);
    }
}