package hu.unideb.inf;

import hu.unideb.inf.MealSelectController;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MealSelectControllerTest {

    private MealSelectController mealSelectController;


    @BeforeAll
    static void start(){System.out.println("Starting testing ...");}

    @BeforeEach
    void setup(){

        this.mealSelectController = new MealSelectController() ;
        mealSelectController.Cola_nagy();

    }

    @Test
    void ALL_Items_DEL() {

        boolean expected =true;
        boolean actual = mealSelectController.ALL_Items_DEL();
        assertEquals(expected,actual);
    }

    @Test
    void last_item_DEL() {
    }
}