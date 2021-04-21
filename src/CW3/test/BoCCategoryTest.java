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

    @Test
    void resetBudgetSpend() {
    }

    @Test
    void getRemainingBudget() {
    }


        //default constructor
        //Author:LinCHEN(biylc2)
        //Last Modify:2021/04/21
    @Test
    void testToString1() {
        BoCCategory boc1= new BoCCategory();
        String a="New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)";
        assertEquals(a,boc1.toString());
    }

        //constructor with parameter
        //Author:LinCHEN(biylc2)
        //Last Modify:2021/04/21
    @Test
    void testToString2() throws IllegalAccessException, NoSuchFieldException {
        BoCCategory boc1= new BoCCategory("Negative");
        Field field1=boc1.getClass().getDeclaredField("CategoryBudget");
        field1.setAccessible(true);
        field1.set(boc1,new BigDecimal("10000.00"));
        Field field2=boc1.getClass().getDeclaredField("CategorySpend");
        field2.setAccessible(true);
        field2.set(boc1,new BigDecimal("20000.00"));


        String a="Negative(¥10000.00) - Est. ¥20000.00 (¥-10000.00 Overspent)";
        assertEquals(a,boc1.toString());
    }

        //constructor with parameter
        //Author:LinCHEN(biylc2)
        //Last Modify:2021/04/21
    @Test
    void testToString3() throws IllegalAccessException, NoSuchFieldException {
        BoCCategory boc2= new BoCCategory("Positive");
        Field field1=boc2.getClass().getDeclaredField("CategoryBudget");
        field1.setAccessible(true);
        field1.set(boc2,new BigDecimal("3457834.023423"));
        Field field2=boc2.getClass().getDeclaredField("CategorySpend");
        field2.setAccessible(true);
        field2.set(boc2,new BigDecimal("667433.00564"));

        String a="Positive(¥3457834.023423) - Est. ¥667433.00564 (¥2790401.017783 Remaining)";
        assertEquals(a,boc2.toString());
    }


}