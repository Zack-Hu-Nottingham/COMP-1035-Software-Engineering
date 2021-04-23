import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class BoCCategoryTest {

    @Test
    void categoryName() {
    }

    @Test
    void categoryBudget() {
    }

    @Test
    void categorySpend() {
    }

    @Test
    void setCategoryName() {
    }

    // Author: Ziyi Wang
    // Last modified: 2021/4/23 19:11
    @Test
    void setCategoryBudget1(){
        final BoCCategory stest = new BoCCategory();    //new object

        float input = 20.00F;
        //argument passed to setCategoryBudget is incompatible with the type expected
        stest.setCategoryBudget(input);    // set the budget with float type
    }


    @Test
    void addExpense() {
    }

    @Test
    void removeExpense() {
    }

    @Test
    void resetBudgetSpend() {
    }

    @Test
    void getRemainingBudget() {
    }

    @Test
    void testToString() {
    }
}