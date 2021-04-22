import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BoCCategoryTest {

    // Author: Leshan Tan
    // Last Modified: 2021/4/21
    @Test
    void BocCategory()throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory boc = new BoCCategory();
        final Field fieldName = boc.getClass().getDeclaredField("CategoryName");
        final Field fieldBudget = boc.getClass().getDeclaredField("CategoryBudget");
        final Field fieldSpend = boc.getClass().getDeclaredField("CategorySpend");
        fieldName.setAccessible(true);
        fieldBudget.setAccessible(true);
        fieldSpend.setAccessible(true);
        assertEquals("New Category", fieldName.get(boc),"Field CategoryName didn't match");
        assertEquals(new BigDecimal("0.00"),fieldBudget.get(boc),"Field CategoryBudget didn't match");
        assertEquals(new BigDecimal("0.00"), fieldSpend.get(boc),"Field CategorySpend didn't match");
    }

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

    //Author: Yicun Duan
    //Last Modified: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"/getRemainingBudgetTest.csv"})
    void getRemainingBudget(String budget, String spend, String remain) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory remainTest =  new BoCCategory();
        final Field field_budget = remainTest.getClass().getDeclaredField("CategoryBudget");
        field_budget.setAccessible(true);
        field_budget.set(remainTest, new BigDecimal(budget));
        final Field field_spend = remainTest.getClass().getDeclaredField("CategorySpend");
        field_spend.setAccessible(true);
        field_spend.set(remainTest, new BigDecimal(spend));

        final BigDecimal result = remainTest.getRemainingBudget();

        assertEquals(result, new BigDecimal(remain));

    }

    @Test
    void testToString() {
    }
}