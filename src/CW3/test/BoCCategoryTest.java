import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;

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

    @Test
    void setCategoryBudget() {
    }

    @Test
    void addExpense() {
    }

    @Test
    void removeExpense() {
    }

    //Author:LinCHEN(biylc2)
    //Last Modify:2021/04/21
    @Test
    void resetBudgetSpend() throws NoSuchFieldException, IllegalAccessException {
        BoCCategory reset1= new BoCCategory("Reset");
        Field field1=reset1.getClass().getDeclaredField("CategorySpend");
        field1.setAccessible(true);
        field1.set(reset1,new BigDecimal("20000.0292"));
        reset1.resetBudgetSpend();
        BigDecimal result1= (BigDecimal) field1.get(reset1);
        assertEquals(new BigDecimal("0.00"),result1);

    }

    @Test
    void getRemainingBudget() {
    }

    @Test
    void testToString() {
    }
}