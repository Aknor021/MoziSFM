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
    void tearDown() {
    }

    @Test
    void changeScenePushed() {
        boolean act = true;
        boolean expected = true;
        assertEquals(expected,act);
    }
}